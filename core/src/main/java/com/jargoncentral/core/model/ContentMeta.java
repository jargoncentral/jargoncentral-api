package com.jargoncentral.core.model;

import com.jargoncentral.common.entity.ContentMetaEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="articles_contentmeta")
public class ContentMeta extends ContentMetaEntity {

    public static final String TABLE_NAME = "articles_contentmeta";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
}
