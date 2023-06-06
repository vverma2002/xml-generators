package com.vik;

import com.vik.model.Address;
import com.vik.model.Person;
import com.vik.model.Profile;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Random;

public class VelocityXMLGenerator {

    public static void main(String[] args) {
        // Create Velocity engine
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        // Create Velocity context
        VelocityContext context = new VelocityContext();
        generateModel(context);

        // Process the template
        StringWriter writer = new StringWriter();
        velocityEngine.mergeTemplate("velocity.vm", "UTF-8", context, writer);

        // Output the generated XML
        String xml = writer.toString();
        System.out.println(xml);
    }

    private static void generateModel(VelocityContext context) {
        Person person = new Person("User", "Test@test.com");
        context.put("person", person);

        // Generate random number of Address elements
        Random random = new Random();
        int numAddresses = random.nextInt(3) + 1; // Random number between 1 and 2

        // Add addresses to the Person model
        for (int i = 1; i <= numAddresses; i++) {
            // Create Address model
            person.addAddress(new Address(i + " Street", "City", "Country"));
        }
        // Create Profile model
        person.setProfile(new Profile("John Doe", "Google User"));
    }
}