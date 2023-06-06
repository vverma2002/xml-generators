package com.vik.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Profile {
    private String username;
    private String bio;

    public Profile(String username, String bio) {
        this.username = username;
        this.bio = bio;
    }

    public Element toXmlElement(Document doc) {
        Element profileElement = doc.createElement("profile");

        Element usernameElement = doc.createElement("username");
        usernameElement.appendChild(doc.createTextNode(username));
        profileElement.appendChild(usernameElement);

        Element bioElement = doc.createElement("bio");
        bioElement.appendChild(doc.createTextNode(bio));
        profileElement.appendChild(bioElement);

        return profileElement;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}