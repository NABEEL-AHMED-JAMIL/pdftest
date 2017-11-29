package com.ballistic.pdftest.entity;

/**
 * Created by Nabeel on 11/29/2017.
 */
public class SimpleDestination {

    private String name;
    private String description;

    public SimpleDestination() {
    }

    public SimpleDestination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
