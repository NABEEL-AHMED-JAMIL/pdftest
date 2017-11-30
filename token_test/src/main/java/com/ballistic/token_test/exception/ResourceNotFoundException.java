package com.ballistic.token_test.exception;

/**
 * Created by Nabeel on 11/30/2017.
 */
public class ResourceNotFoundException extends RuntimeException {

    private Integer resourceId;

    public ResourceNotFoundException(Integer resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
