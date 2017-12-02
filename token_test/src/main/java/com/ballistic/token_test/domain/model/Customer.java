package com.ballistic.token_test.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by Nabeel on 12/1/2017.
 */
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{

    @Column(name="email")
    private String email;
    @Column(name="name")
    private String name;
    @Column(name="remarks",length=1000)
    private String remarks;
    @Column(name="primary_cell_no")
    private String cellNo;
    @Column(name="profile")
    private String profile;
    @Column(name="address")
    private String address;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
