package com.ballistic.token_test.domain.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

/**
 * Created by Nabeel on 11/30/2017.
 */
public class BaseDto {


    @Override
    public String toString() {
        try {
            return toJsonString(this);
        } catch (Exception e) {
            return super.toString();
        }
    }

    protected static String toJsonString(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        map.registerModule(new Jdk8Module());
        map.registerModule(new JSR310Module());
        return map.writeValueAsString(r);
    }
}
