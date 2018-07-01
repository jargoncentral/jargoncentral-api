package com.jargoncentral.common.entity;

import lombok.Data;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AtricleEntity extends AbstractEntity{

    protected String title;
    protected Integer status;
    protected String slug;
    protected Long views;
    protected BigDecimal rating;
}
