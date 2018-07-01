package com.jargoncentral.core.model;

import com.jargoncentral.common.entity.TagEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tags_tag")
public class Tag extends TagEntity {

    public static final String TABLE_NAME = "tags_tag";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
}
