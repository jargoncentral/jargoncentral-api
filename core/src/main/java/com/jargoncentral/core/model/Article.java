package com.jargoncentral.core.model;

import com.jargoncentral.common.entity.AtricleEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name="articles_article")
public class Article extends AtricleEntity {

    public static final String TABLE_NAME = "articles_article";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String title;
//    private Integer status;
//    private String slug;
//    private Long views;
//    private BigDecimal rating;
//    private Date createdAt;
//    private Date updatedAt;

//    @OneToMany(fetch = FetchType.LAZY)
//    private Set<Content> contents = new HashSet<>();

    public void hell(){
        System.out.print(this.title);
    }

}
