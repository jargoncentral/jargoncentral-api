package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@MappedSuperclass
public class ContentRating extends AbstractEntity {

    protected BigDecimal value;
}
