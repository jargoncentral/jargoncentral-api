package com.jargoncentral.common.entity;

import com.jargoncentral.common.enums.Preference;
import com.jargoncentral.common.enums.Source;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class UserTagEntity extends AbstractEntity{

    protected Preference preference;
    protected Source source;
}
