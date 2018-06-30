package com.jargoncentral.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="auth_user")
@Data
public class User {

    public static final String TABLE_NAME = "auth_user";

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String password;
    @Column(name = "last_login")
    private Date lastLogin;
    @Column(name = "is_superuser")
    private Boolean isSuperUser;
    @Column(name = "username")
    private String userName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "is_staff")
    private Boolean isStaff;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "date_joined")
    private Date dateJoined;

}
