package com.ballistic.component;


import org.springframework.stereotype.Component;

@Component
public class HotelBean {

    private Long id = 1l;
    private String name = "Nabeel";
    private Integer classification = 2;
    private Boolean isOpen = true;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getClassification() { return classification; }
    public void setClassification(Integer classification) { this.classification = classification; }

    public Boolean getOpen() { return isOpen; }
    public void setOpen(Boolean open) { isOpen = open; }


}
