package com.ballistic.token_test.domain.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by Nabeel on 11/30/2017.
 */
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(notes = "The give us valid email like 'nabeel.amd93@gmail.com'")
    private Integer id;

    @Column(name = "user_from", nullable = false)
    @ApiModelProperty(notes = "Email User from Send message", required = true)
    private String from;

    @Column(name = "title")
    @ApiModelProperty(notes = "Title for Positive message")
    private String title;

    @Column(name = "user_to", nullable = false)
    @ApiModelProperty(notes = "Email User to Send message", required = true)
    private String to;

    @Column(name = "body")
    @ApiModelProperty(notes = "Message write in body Section", required = true)
    private String body;

    @Column(name = "commit_created", updatable=false)
    @CreationTimestamp
    @ApiModelProperty(notes = "Create value in Date form")
    private Date created;

    @Column(name = "commit_updated")
    @ApiModelProperty(notes = "Update value in Date form")
    @UpdateTimestamp
    private Date updated;


    public Comment() {}

    public Comment(String to, String title, String from, Date created, Date updated, String body) {
        this.to = to;
        this.title = title;
        this.from = from;
        this.created = created;
        this.updated = updated;
        this.body = body;
    }

    public String getTo() { return to; }

    public void setTo(String to) { this.to = to; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getFrom() { return from; }

    public void setFrom(String from) { this.from = from; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public Date getCreated() { return created; }

    public void setCreated(Date created) { this.created = created; }

    public Date getUpdated() { return updated; }

    public void setUpdated(Date updated) { this.updated = updated; }


}
