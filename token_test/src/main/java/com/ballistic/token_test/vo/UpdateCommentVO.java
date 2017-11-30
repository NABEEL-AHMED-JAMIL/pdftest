package com.ballistic.token_test.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Nabeel on 11/30/2017.
 */
public class UpdateCommentVO {

    @NotNull(message = "Id Must have value")
    private Integer id;
    private String title;
    @NotNull(message = "Comment message Update Must Contain value")
    private String body;
    private Date updated;
    @NotNull
    @NotEmpty
    @Email(message = "Please provide a valid email address", regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String from;
    @NotNull
    @NotEmpty
    @Email(message = "Please provide a valid email address", regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String to;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getUpdated() { return updated; }

    public void setUpdated(Date updated) { this.updated = updated; }

    public String getFrom() { return from; }

    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }

    public void setTo(String to) { this.to = to; }

}
