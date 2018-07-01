package com.jargoncentral.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jargoncentral.common.entity.ContentEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="articles_content")
@Data
public class Content extends ContentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @OneToOne(fetch = FetchType.EAGER)
    private Author author;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="content_id")
    private Set<ContentMeta> metas;
}
