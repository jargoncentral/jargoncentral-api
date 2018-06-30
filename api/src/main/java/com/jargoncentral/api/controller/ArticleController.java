package com.jargoncentral.api.controller;

import com.jargoncentral.api.model.Response;
import com.jargoncentral.core.model.Article;
import com.jargoncentral.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController implements APIController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/get/{id}")
    public Response get(@PathVariable Integer id) throws Exception {
        Optional<Article> article = articleService.getArticle(id);
        if(article.isPresent()) {
            HashSet<Object> set = new HashSet<>();
            set.add(article.get());
            return new Response(200, set);
        } else {
            return new Response(404,null);
        }
    }

}