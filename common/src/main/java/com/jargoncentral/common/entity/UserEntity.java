package com.jargoncentral.common.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class UserEntity {

    @Transient
    protected Integer Id;
    protected String password;
    protected Date lastLogin;
    protected Boolean isSuperUser;
    protected String userName;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected Boolean isStaff;
    protected Boolean isActive;
    protected Date dateJoined;
}
