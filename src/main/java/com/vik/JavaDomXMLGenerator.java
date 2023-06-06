package com.vik;

import com.vik.model.Address;
import com.vik.model.Person;
import com.vik.model.Profile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Random;

public class JavaDomXMLGenerator {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilder
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Create XML document
            Document doc = docBuilder.newDocument();

            // Create root element
            Element rootElement = doc.createElement("data");
            doc.appendChild(rootElement);

            // Generate XML with models
            generateXMLWithModels(doc, rootElement);

            // Transform XML document to string
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);

            // Output XML to console
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateXMLWithModels(Document doc, Element rootElement) {
        // Create Person model
        Person person = new Person("User", "Test@test.com");

        // Generate random number of Address elements
        Random random = new Random();
        int numAddresses = random.nextInt(3) + 1; // Random number between 1 and 2

        // Add addresses to the Person model
        for (int i = 1; i <= numAddresses; i++) {
            // Create Address model
            Address address = new Address(i + " Street", "City", "Country");
            person.addAddress(address);
        }


        // Create Profile model
        Profile profile = new Profile("John Doe", "Google User");

        person.setProfile(profile);

        // Generate XML for the Person model
        Element personElement = person.toXmlElement(doc);
        rootElement.appendChild(personElement);
    }
}