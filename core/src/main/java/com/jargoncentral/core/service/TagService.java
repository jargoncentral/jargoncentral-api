package com.jargoncentral.core.service;

import com.jargoncentral.core.model.Tag;
import com.jargoncentral.core.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Set<Tag> getTopListByWeight() {
        return tagRepository.findTop10ByOrderByWeightDesc();
    }
}
