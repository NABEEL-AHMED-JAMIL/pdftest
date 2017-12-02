package com.ballistic.token_test.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Nabeel on 12/1/2017.
 */
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{


    @Column(name="email")
    private String email;
    @Column(name="name")
    private String name;
    @Column(name="nic")
    private String nic;
    @Column(name="primary_cell_no")
    private String cellNo;
    @Column(name="address")
    private String address;
    @Column(name="designation")
    private String designation;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCellNo() { return cellNo; }

    public void setCellNo(String cellNo) { this.cellNo = cellNo; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getDesignation() { return designation; }

    public void setDesignation(String designation) { this.designation = designation; }
}