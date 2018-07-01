package com.jargoncentral.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jargoncentral.common.entity.ArticleTagEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="articles_article_tags")
public class ArticleTag extends ArticleTagEntity {

    public static final String TABLE_NAME = "articles_article_tags";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    @JsonIgnore
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
