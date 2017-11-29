package com.ballistic.pdftest.entity;

import java.util.Date;

/**
 * Created by Nabeel on 11/29/2017.
 */
public class Employee {

    private int id;
    private String name;
    private Division division;
    private Date startDt;

    public Employee() {
    }

    public Employee(int id, String name, Division division, Date startDt) {
        this.id = id;
        this.name = name;
        this.division = division;
        this.startDt = startDt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }
}
