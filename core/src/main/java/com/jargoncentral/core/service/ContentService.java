package com.jargoncentral.core.service;

import com.jargoncentral.common.enums.ContentStatus;
import com.jargoncentral.core.model.Article;
import com.jargoncentral.core.model.Content;
import com.jargoncentral.core.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContentService {

    @Autowired
    ContentRepository contentRepository;

    public Optional<Content> getContent(final Article article, final ContentStatus status){
        List<Content> contents = contentRepository.findByArticle(article).stream().filter(
                p -> p.getStatus().equals(status)
        ).collect(Collectors.toList());

        if(!contents.isEmpty()){
            return Optional.of(contents.get(0));
        } else {
            return Optional.empty();
        }
    }

    public List<Content> getHistoryContent(final Article article, final ContentStatus status){
        List<Content> contents = contentRepository.findByArticle(article).stream().filter(
                p -> p.getStatus().equals(status)
        ).collect(Collectors.toList());

        if(!contents.isEmpty()){
            return contents;
        } else {
            return null;
        }
    }
}
