package com.ballistic.token_test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Nabeel on 11/30/2017.
 */
// If your POJO does not contain certain properties which JSON does contain, they are ignored and no error is thrown.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends BaseDto{

    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;

    public Comment() {
    }

    public Comment(Integer postId, Integer id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
