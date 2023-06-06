package com.vik.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String email;
    private List<Address> addresses;
    private Profile profile;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        this.addresses = new ArrayList<>();
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Element toXmlElement(Document doc) {
        Element personElement = doc.createElement("person");

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        personElement.appendChild(nameElement);

        Element emailElement = doc.createElement("email");
        emailElement.appendChild(doc.createTextNode(email));
        personElement.appendChild(emailElement);

        // Add addresses
        for (Address address : addresses) {
            Element addressElement = address.toXmlElement(doc);
            personElement.appendChild(addressElement);
        }

        // Add profile
        if (profile != null) {
            Element profileElement = profile.toXmlElement(doc);
            personElement.appendChild(profileElement);
        }

        return personElement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Profile getProfile() {
        return profile;
    }
}