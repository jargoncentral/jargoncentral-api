package com.jargoncentral.common.entity;

import lombok.Data;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AtricleEntity {

    @Transient
    protected Integer Id;
    protected String title;
    protected Integer status;
    protected String slug;
    protected Long views;
    protected BigDecimal rating;
    protected Date createdAt;
    protected Date updatedAt;
}
