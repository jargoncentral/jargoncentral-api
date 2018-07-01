package com.jargoncentral.core.repository;

import com.jargoncentral.core.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
    @Query("SELECT a FROM Article a WHERE UPPER(a.title) LIKE CONCAT('%',UPPER(:title),'%')")
    Set<Article> searchByTitle(@Param("title") String title);

    Optional<Article> findBySlugEquals(String slug);

//    @Query("SELECT a FROM Article a ORDER BY rating DESC")
//    Set<Article> orderArticlesByRating();

    Set<Article> findTop10ByOrderByRatingDesc();
}
