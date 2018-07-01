package com.jargoncentral.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

@Data
public class Response implements Serializable{

    private Integer status;
    private HashMap<String, Object> content;

    public Response(Integer status, HashMap<String, Object> content) {
        this.status = status;
        this.content = content;
    }


}