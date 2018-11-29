package com.jargoncentral.core.repository;

import com.jargoncentral.core.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    Set<Tag> findTop10ByOrderByWeightDesc();
}
