package com.jargoncentral.core.model;

import com.jargoncentral.core.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="authors_author")
@Data
public class Author {

    public static final String TABLE_NAME = "authors_author";

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Role role;
    @Column(name = "profil_pic")
    private String profilePic;
    private Date createdAt;
    private Date updatedAt;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;
}