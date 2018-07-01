package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Transient
    protected Integer Id;
    protected Date createdAt;
    protected Date updatedAt;

}
