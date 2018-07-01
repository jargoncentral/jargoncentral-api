package com.jargoncentral.core.repository;

import com.jargoncentral.core.model.Article;
import com.jargoncentral.core.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer>{
    Set<Content> findByArticle(Article id);
}
