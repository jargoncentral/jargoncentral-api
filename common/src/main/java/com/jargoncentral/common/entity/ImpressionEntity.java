package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class ImpressionEntity extends AbstractEntity {

    protected String ipAddress;
}
