package com.mouffronjo.recommander.controller;

import com.mouffronjo.recommander.model.Film;
import com.mouffronjo.recommander.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/films/")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("")
    public List<Film> getFilms(){
        return filmService.getAll();
    }
    @GetMapping("{id}")
    public Optional<Film> getFilm(@Validated @PathVariable long id, BindingResult res){
        if (res.hasErrors()){
            return Optional.empty();
        } else {
            return Optional.ofNullable(filmService.getOneById(id));
        }
    }

    @PutMapping("/edit")
    public void editFilm(@Validated @ModelAttribute Film film, BindingResult res){
        if ( !res.hasErrors()){
            filmService.edit(film);
        }
    }

    @PatchMapping("/patch")
    public void patchFilm(@Validated @ModelAttribute Film film, BindingResult res){
        if ( !res.hasErrors()){
            filmService.edit(film);
        }
    }

    @PostMapping("/add")
    public void createFilm(@Validated @ModelAttribute Film film, BindingResult res){
        if ( !res.hasErrors()){
            filmService.create(film);
        }
    }

    @DeleteMapping("{id}")
    public void deleteFilm(@Validated @PathVariable long id, BindingResult res){
        if ( !res.hasErrors()){
            filmService.deleteById(id);
        }
    }

}
