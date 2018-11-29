package com.jargoncentral.api.controller;

import com.jargoncentral.api.model.Response;
import com.jargoncentral.common.enums.ContentStatus;
import com.jargoncentral.common.util.HTTPRequestUtil;
import com.jargoncentral.core.model.*;
import com.jargoncentral.core.service.ArticleService;
import com.jargoncentral.core.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    public Response topViews() {
        Set<Article> results = articleService.getTopListByViews();
        HashMap<String, Object> set = new HashMap();
        set.put("articles", results);
        return new Response(200, set);
    }

    @RequestMapping("/suggestion")
    public Response suggestions() {
        Set<Article> results = articleService.getByTopTags();
        HashMap<String, Object> set = new HashMap();
        set.put("articles", results);
        return new Response(200, set);
    }

    @RequestMapping("/search/{query}")
    public Response search(@PathVariable String query) {
        List<Article> results = articleService.search(query);
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
    public Response history(@PathVariable Integer id) {
        Optional<Article> article = articleService.getById(id);
        return getArticleResponse(article, ContentStatus.HISTORY);
    }

    @RequestMapping("/{id}/related")
    public Response related(@PathVariable Integer id){
        Set<Article> results = articleService.getRelated(id);
        HashMap<String, Object> set = new HashMap();
        set.put("articles", results);
        return new Response(200, set);
    }

    @RequestMapping("/{id}/network")
    public Response network(@PathVariable Integer id){
        HashMap<Article, HashMap> tree = articleService.getNetwork(id);
        HashMap<String, Object> set = new HashMap();
        set.put("articles", tree);
        return new Response(200, set);
    }

//region Private

    private Response getArticleResponse(Optional<Article> article, ContentStatus status) {
        if(article.isPresent()) {
            HashMap<String, Object> set = new HashMap();
            set.put("article", article.get());

            if (status == ContentStatus.CURRENT) {
            Optional<Content> content = contentService.getContent(article.get(), status);
                set.put("body", content);
            } else {
                List<Content> contents = contentService.getHistoryContent(article.get(), status);
                set.put("body", contents);
            }

            set.put("tags", article.get().getTags());

            return new Response(200, set);
        } else {
            return new Response(404,null);
        }
    }

//endregion

}