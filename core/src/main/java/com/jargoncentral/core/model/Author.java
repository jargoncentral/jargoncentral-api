package com.jargoncentral.core.model;

import com.jargoncentral.common.entity.AuthorEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="authors_author")
@Data
@AttributeOverride(name = "profilePic", column = @Column(name = "profil_pic"))
public class Author extends AuthorEntity {

    public static final String TABLE_NAME = "authors_author";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "profil_pic")
    private String profilePic;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;
}

