package com.vik.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Address {
    private String street;
    private String city;
    private String country;

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Element toXmlElement(Document doc) {
        Element addressElement = doc.createElement("address");

        Element streetElement = doc.createElement("street");
        streetElement.appendChild(doc.createTextNode(street));
        addressElement.appendChild(streetElement);

        Element cityElement = doc.createElement("city");
        cityElement.appendChild(doc.createTextNode(city));
        addressElement.appendChild(cityElement);

        Element countryElement = doc.createElement("country");
        countryElement.appendChild(doc.createTextNode(country));
        addressElement.appendChild(countryElement);

        return addressElement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}