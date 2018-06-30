package com.jargoncentral.core.repository;

import com.jargoncentral.core.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{
//    @Query("SELECT a FROM Article a WHERE UPPER(a.title) LIKE CONCAT('%',UPPER(:title),'%')")
//    List<Article> searchByTitle(@Param("title") String title);
}
