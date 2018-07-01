package com.jargoncentral.api.controller;

import com.jargoncentral.api.model.Response;
import com.jargoncentral.common.enums.ContentStatus;
import com.jargoncentral.common.util.HTTPRequestUtil;
import com.jargoncentral.core.model.*;
import com.jargoncentral.core.repository.AuthorRepository;
import com.jargoncentral.core.repository.ContentRepository;
import com.jargoncentral.core.service.ArticleService;
import com.jargoncentral.core.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController implements APIController {

    private ArticleService articleService;
    private ContentService contentService;

    @Autowired
    public ArticleController(ArticleService articleService, ContentService contentService) {
        this.articleService = articleService;
        this.contentService = contentService;
    }

    @RequestMapping("/top")
    public Response topList() {
        Set<Article> results = articleService.getTopList();
        HashMap<String, Object> set = new HashMap();
        set.put("articles", results);
        return new Response(200, set);
    }

    @RequestMapping("/search/{query}")
    public Response search(@PathVariable String query) {
        Set<Article> results = articleService.searchArticle(query);
        HashMap<String, Object> set = new HashMap();
        set.put("articles", results);
        return new Response(200, set);
    }

    @RequestMapping("/show/{slug}")
    public Response slug(@PathVariable String slug) {
        Optional<Article> article = articleService.getBySlug(slug);
        return getArticleResponse(article, ContentStatus.CURRENT);
    }

    @RequestMapping("/{id}")
    public Response get(@PathVariable Integer id, HttpServletRequest request) {
        String ip = HTTPRequestUtil.extractIPAddress(request);
        Optional<Article> article = articleService.getById(id);
        return getArticleResponse(article, ContentStatus.CURRENT);
    }

    @RequestMapping("/{id}/history")
    public Response getHistory(@PathVariable Integer id) {
        Optional<Article> article = articleService.getById(id);
        return getArticleResponse(article, ContentStatus.HISTORY);
    }

//region Private

    private Response getArticleResponse(Optional<Article> article, ContentStatus status) {
        if(article.isPresent()) {
            HashMap<String, Object> set = new HashMap();
            set.put("article", article.get());

            Optional<Content> content = contentService.getContent(article.get(), status);
            if (content.isPresent()){
                set.put("body", content);
            }

            set.put("tags", article.get().getTags());

            return new Response(200, set);
        } else {
            return new Response(404,null);
        }
    }

//endregion

}