package com.jargoncentral.core.repository;

import com.jargoncentral.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposistory extends JpaRepository<User, Integer> {
}
