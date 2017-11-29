package com.ballistic.pdftest.dto;

/**
 * Created by Nabeel on 11/29/2017.
 */
public class EmployeeDTO {

    private int employeeId;
    private String employeeName;
    private DivisionDTO division;
    private String employeeStartDt;

    public EmployeeDTO() {}

    public EmployeeDTO(int employeeId, String employeeName, DivisionDTO division, String employeeStartDt) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.division = division;
        this.employeeStartDt = employeeStartDt;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public DivisionDTO getDivision() {
        return division;
    }

    public void setDivision(DivisionDTO division) { this.division = division; }

    public String getEmployeeStartDt() {
        return employeeStartDt;
    }

    public void setEmployeeStartDt(String employeeStartDt) {
        this.employeeStartDt = employeeStartDt;
    }
}
