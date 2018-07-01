package com.jargoncentral.core.service;

import com.jargoncentral.core.model.Article;
import com.jargoncentral.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getById(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            this.addImpression(article.get());
        }
        return articleRepository.findById(id);
    }

    public Optional<Article> getBySlug(String slug) {
        return articleRepository.findBySlugEquals(slug);
    }

    public Set<Article> searchArticle(String query) {
        return articleRepository.searchByTitle(query);
    }

    public Set<Article> getTopList() {
        return articleRepository.findTop10ByOrderByRatingDesc();
    }

//region Private

    private void addImpression(Article article){
        article.setViews(article.getViews()+1);
        articleRepository.save(article);
    }

//endregion

}
