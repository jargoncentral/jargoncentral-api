package com.jargoncentral.api.controller;

import com.jargoncentral.api.model.Response;
import com.jargoncentral.core.model.Tag;
import com.jargoncentral.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    private TagService tagService;

    @Autowired
    private TagController(TagService tagService){
        this.tagService = tagService;
    }

    @RequestMapping("/top")
    public Response topList(){
        Set<Tag> results = tagService.getTopListByWeight();
        HashMap<String, Object> set = new HashMap();
        set.put("tags", results);
        return new Response(200, set);
    }
}
