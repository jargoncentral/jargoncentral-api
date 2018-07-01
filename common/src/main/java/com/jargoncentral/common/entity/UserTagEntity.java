package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class UserTagEntity extends AbstractEntity{

    protected Integer preference;
    protected Integer source;
}
