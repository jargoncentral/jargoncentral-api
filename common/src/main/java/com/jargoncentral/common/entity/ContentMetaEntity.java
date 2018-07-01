package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class ContentMetaEntity {

    protected String name;
    protected String data;
}
