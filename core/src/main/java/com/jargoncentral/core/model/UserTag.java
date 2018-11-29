package com.jargoncentral.core.model;

import com.jargoncentral.common.entity.UserTagEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="authors_usertag")
public class UserTag extends UserTagEntity {

    public static final String TABLE_NAME = "authors_usertag";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
