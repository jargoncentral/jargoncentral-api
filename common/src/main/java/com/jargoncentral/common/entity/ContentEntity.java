package com.jargoncentral.common.entity;

import com.jargoncentral.common.enums.ContentStatus;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@Data
@MappedSuperclass
public abstract class ContentEntity extends AbstractEntity{

    protected String body;
    protected ContentStatus status;
}
