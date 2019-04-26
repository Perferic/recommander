package com.mouffronjo.recommander.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.Map;
import java.util.Set;

@javax.persistence.Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Entity {

    private static final long serialVersionUID = 1002989597484506026L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @NotNull
    @NotEmpty
    @Min(3)
    protected String username;

    @Email
    @NotEmpty
    @NotNull
    protected String email;

    protected Role role;

    @NotEmpty
    @NotNull
    @Min(8)
    protected String password;

    @PastOrPresent
    protected Date dateOfBirth;

    @CreatedDate
    protected Date dateOfmembership;
    @ElementCollection
    protected Map<Film, Double> films;
    @ElementCollection
    protected Set<User> scouts;
}
