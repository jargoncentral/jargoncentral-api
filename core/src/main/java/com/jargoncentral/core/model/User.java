package com.jargoncentral.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jargoncentral.common.entity.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="auth_user")
@Data
@AttributeOverrides({
        @AttributeOverride(name="isSuperUser", column=@Column(name="is_superuser")),
        @AttributeOverride(name="userName", column=@Column(name="username"))
})
public class User extends UserEntity {

    public static final String TABLE_NAME = "auth_user";

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @Column(name = "last_login")
    private Date lastLogin;

    @JsonIgnore
    @Column(name = "is_superuser")
    private Boolean isSuperUser;

    @JsonIgnore
    @Column(name = "username")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @Column(name = "is_staff")
    private Boolean isStaff;

    @JsonIgnore
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "date_joined")
    private Date dateJoined;

}
