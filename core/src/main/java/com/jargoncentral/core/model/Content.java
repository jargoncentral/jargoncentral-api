package com.jargoncentral.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="articles_content")
@Data
public class Content {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String body;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @OneToOne(fetch = FetchType.EAGER)
    private Author author;


    @Override
    public String toString() {
        return "Content{" +
                "Id=" + Id +
                ", body='" + body + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", article=" + article +
                '}';
    }
}
