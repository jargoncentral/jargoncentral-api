package com.jargoncentral.core.service;

import com.jargoncentral.core.model.Article;
import com.jargoncentral.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getArticle(Integer id) {
        return articleRepository.findById(id);
    }
}
