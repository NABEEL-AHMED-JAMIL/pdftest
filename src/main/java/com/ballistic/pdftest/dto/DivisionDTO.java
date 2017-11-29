package com.ballistic.pdftest.dto;

/**
 * Created by Nabeel on 11/29/2017.
 */
public class DivisionDTO {

    private int id;
    private String name;

    public DivisionDTO() {
    }

    public DivisionDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
