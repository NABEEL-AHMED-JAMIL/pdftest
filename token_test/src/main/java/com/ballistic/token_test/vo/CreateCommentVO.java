package com.ballistic.token_test.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Nabeel on 11/30/2017.
 */
public class CreateCommentVO {

    @NotNull
    @NotEmpty
    @Email(message = "Please provide a valid email address", regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String from;
    // this may be null able
    private String title;
    @NotNull
    @NotEmpty
    @Email(message = "Please provide a valid email address", regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String to;
    @NotNull(message = "Body must contain the Value")
    private String body;

    private Date created;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated() { return created; }

    public void setCreated(Date created) { this.created = created; }

}
