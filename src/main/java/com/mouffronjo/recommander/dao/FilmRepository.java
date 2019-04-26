package com.mouffronjo.recommander.dao;

import com.mouffronjo.recommander.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.validation.constraints.NotNull;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "film", path = "films")
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByTitle(@NotNull final String title);
    Film findByTitle(@NotNull final String title);
}
