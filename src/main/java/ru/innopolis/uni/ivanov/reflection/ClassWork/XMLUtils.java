package ru.innopolis.uni.ivanov.reflection.ClassWork;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class XMLUtils {


    /**
     * Serialize an object with only primitive and String types of fields.
     * Fields values gets from getter methods and write to XML file specified in "path"
     *
     * @param object the object to serialize
     * @param path   filepath to serialize
     */
    public void serializeToXML(Object object, String path) {
        try {
            Document document = docBuild(object);
            // write the content into xml file
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(document);
            StreamResult result =
                    new StreamResult(new File(path));
            transformer.transform(source, result);
        } catch (InvocationTargetException | ParserConfigurationException | TransformerException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Document docBuild(Object object) throws ParserConfigurationException, InvocationTargetException, IllegalAccessException {
        Class clazz = object.getClass();

        String clazzName = clazz.getName();

        Method[] clazzMethods = clazz.getMethods();

        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder =
                dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        // root element
        Element rootElement = doc.createElement(clazzName);
        doc.appendChild(rootElement);


        for (Method method : clazzMethods) {
            String methodName = method.getName();
            int methodParameterCount = method.getParameterCount();
            if (methodName.startsWith("get") && methodParameterCount == 0 && !methodName.equals("getClass")) {
                String name = method.getReturnType().getSimpleName();
                String s = method.invoke(object).toString();

                attributeFields(methodName.substring(3).toLowerCase(), name, s, doc, rootElement);
            }
        }
        return doc;
    }

    private void attributeFields(String fieldName, String typeField, String fieldValue, Document doc, Element rootElement) throws ParserConfigurationException {

        //  fieldName element
        Element field = doc.createElement(fieldName);
        rootElement.appendChild(field);

        // setting attribute to element
        Attr attrType = doc.createAttribute("type");
        attrType.setValue(typeField);
        field.setAttributeNode(attrType);

        Attr attrValue = doc.createAttribute("value");
        attrValue.setValue(fieldValue);
        field.setAttributeNode(attrValue);
    }


    /**
     * Reads full class name from XML file and get new object instance.
     * Fills field values from XML uses setters. Works with primitive and String fields only
     *
     * @param path the path ro XML file
     * @return the object with field values from XML file
     */
    public Object deserializeFromXml(String path) {
        Object desObject = null;
        try {
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            Element element = doc.getDocumentElement();

            Map<String, Object> attributeMap = readAttribute(path, element);

            String clazzName = element.getNodeName();

            Class clazz = Class.forName(clazzName);

            desObject = clazz.newInstance();

            Method[] clazzMethods = clazz.getMethods();

            for (Method method : clazzMethods) {
                if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                    Object arg = attributeMap.get(method.getName().substring(3).toLowerCase());
                    method.invoke(desObject, arg);
                }
            }
        } catch (IOException | InstantiationException | ParserConfigurationException | InvocationTargetException | ClassNotFoundException | IllegalAccessException | SAXException e) {
            e.printStackTrace();
        }
        return desObject;
    }

    private Map<String, Object> readAttribute(String path, Element element) throws ParserConfigurationException, IOException, SAXException {

        NodeList childNodes = element.getChildNodes();

        Map<String, Object> attributeMap = new HashMap<>();

        for (int i = 1; i < childNodes.getLength(); i = i + 2) {
            Node node = childNodes.item(i);
            String type = node.getAttributes().item(0).getNodeValue();
            String value = node.getAttributes().item(1).getNodeValue();
            attributeMap.put(node.getNodeName(), parsedPrimitive(type, value));
        }

        return attributeMap;
    }


    private Object parsedPrimitive(String fieldType, String fieldValue) {
        switch (fieldType) {
            case "int":
                return Integer.parseInt(fieldValue);

            case "double":
                return Double.parseDouble(fieldValue);

            case "float":
                return Float.parseFloat(fieldValue);

            case "long":
                return Long.parseLong(fieldValue);

            case "char":
                return fieldValue.toCharArray()[0];

            case "boolean":
                return Boolean.parseBoolean(fieldValue);

            case "byte":
                return Byte.parseByte(fieldValue);

            case "short":
                return Short.parseShort(fieldValue);

            case "String":
                return fieldValue;

            default:
                return null;
        }
    }

}
