package com.jargoncentral.core.repository;

import com.jargoncentral.core.model.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTagRepository extends JpaRepository<UserTag, Integer> {
}
