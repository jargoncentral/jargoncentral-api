package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public abstract class TagEntity extends AbstractEntity{

    protected String name;
    protected String slug;
    protected BigDecimal weight;
}
