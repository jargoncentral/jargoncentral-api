package com.jargoncentral.core.service;

import com.jargoncentral.core.model.Article;
import com.jargoncentral.core.model.Tag;
import com.jargoncentral.core.repository.ArticleRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    private TagService tagService;
    private EntityManagerFactory entityMnagerFactory;

    @Autowired
    private ArticleService(TagService tagService, EntityManagerFactory entityMnagerFactory){
        this.tagService = tagService;
        this.entityMnagerFactory = entityMnagerFactory;
    }

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

    public List<Article> search(String query) {
        Session session = entityMnagerFactory.createEntityManager().unwrap(Session.class);
        Query queryParams = session.getNamedQuery("Article.fullTextSearch");
        queryParams.setParameter("query", query);
        return queryParams.getResultList();
    }

    public Set<Article> getTopListByRating() {
        return articleRepository.findTop10ByOrderByRatingDesc();
    }

    public Set<Article> getTopListByViews() {
        return articleRepository.findTop10ByOrderByViewsDesc();
    }

    public Set<Article> getByTopTags(){
        Set<Tag> tags = this.tagService.getTopListByWeight();
        return articleRepository.findTop10ByTagsInOrderByViewsDesc(tags);
    }

    public Set<Article> getRelated(Integer id){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            Set<Article> articles = articleRepository.findTop10ByTagsInOrderByViewsDesc(article.get().getTags());
            articles.removeIf(x -> article.get().getId() == x.getId());
            return articles;
        }
        return null;
    }

    public HashMap<Article, HashMap> getNetwork(Integer id){
        Set<Article> excludes = new HashSet<>();
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()) {
            return this.getArticleNetwork(article.get(), 0, excludes);
        }
        return null;
    }

//region Private

    private HashMap<Article, Set<Article>> getArticleNetwork(Article article, int level, Set<Article> excludes){
        HashMap<Article, Set<Article>> tree = new HashMap<>();
        excludes.add(article);
        Set<Article> related = articleRepository.findTop10ByTagsInOrderByViewsDesc(article.getTags());
        related.removeAll(excludes);
        if (related.size() > 0 && level < 10){
            for(Article artl: related){
                return tree.put(article, this.getArticleNetwork(artl, ++level, excludes).get(article));
            }
        } else {
            tree.put(article, )
        }
        return tree;
    }

    private void addImpression(Article article){
        article.setViews(article.getViews()+1);
        articleRepository.save(article);
    }

//endregion

}
