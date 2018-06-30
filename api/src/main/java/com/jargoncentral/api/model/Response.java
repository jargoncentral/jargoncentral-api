package com.jargoncentral.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;

@Data
public class Response implements Serializable{

    private Integer status;
    private HashSet<Object> content;

    public Response(Integer status, HashSet<Object> content) {
        this.status = status;
        this.content = content;
    }


}