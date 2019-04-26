package com.mouffronjo.recommander.dao;

import com.mouffronjo.recommander.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsername(final String username);
    User findByUsername(final String username);
}
