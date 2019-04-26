package com.mouffronjo.recommander.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Year;
import java.util.Map;
import java.util.Set;

@javax.persistence.Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film implements Entity {

    private static final long serialVersionUID = 9141878885939655969L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected long id;

    protected String title;

    @ElementCollection
    protected Set<Genre> genres;
    @ElementCollection
    protected Set<SubGenre> subgenres;
    @ElementCollection
    protected Set<Country> countries;
    @ElementCollection
    protected Set<Collaborator> collaborators;

    @NotNull
    @NotEmpty
    protected Duration runtime;

    @Min(1890)
    @Max(3000)
    protected Year year;

    @Min(0)
    protected BigDecimal budget;

    protected String alternateTitle;
    @Min(0)
    @Max(10)
    protected double rating;
    @ElementCollection
    protected Map<User, Double> users;


}
