package com.jargoncentral.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jargoncentral.common.entity.AtricleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name="articles_article")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Article.fullTextSearch",
                query = "SELECT * FROM articles_article WHERE title @@ to_tsquery(:query)",
                resultClass = Article.class
        )
})
public class Article extends AtricleEntity {

    public static final String TABLE_NAME = "articles_article";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "articles_article_tags",
            joinColumns = { @JoinColumn(name = "article_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private Set<Tag> tags;

}
