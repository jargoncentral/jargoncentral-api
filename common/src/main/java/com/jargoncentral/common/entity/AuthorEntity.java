package com.jargoncentral.common.entity;

import com.jargoncentral.common.enums.Role;
import lombok.Data;

import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AuthorEntity extends AbstractEntity{

    protected Role role;
    protected String profilePic;

}
