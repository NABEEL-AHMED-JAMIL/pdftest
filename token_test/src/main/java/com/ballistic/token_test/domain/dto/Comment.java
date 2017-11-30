package com.ballistic.token_test.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Nabeel on 11/30/2017.
 */
// If your POJO does not contain certain properties which JSON does contain, they are ignored and no error is thrown.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends BaseDto{

    private Integer id;
    private String from;
    private String title;
    private String to;
    private String body;
    private Date created;
    private Date updated;


    public Comment() {
    }

    public Comment(Integer id, String to, String title, String from, String body, Date created, Date updated) {
        this.id = id;
        this.to = to;
        this.title = title;
        this.from = from;
        this.body = body;
        this.created = created;
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getFrom() { return from; }

    public void setFrom(String from) { this.from = from; }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTo() { return to; }

    public void setTo(String to) { this.to = to; }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
