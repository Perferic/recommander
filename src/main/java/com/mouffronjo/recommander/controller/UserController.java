package com.mouffronjo.recommander.controller;

import com.mouffronjo.recommander.model.User;
import com.mouffronjo.recommander.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users/")
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("")
    public List<User> getUsers(){
        return UserService.getAll();
    }
    @GetMapping("{id}")
    public Optional<User> getUser(@Validated @PathVariable long id, BindingResult res){
        if (res.hasErrors()){
            return Optional.empty();
        } else {
            return Optional.ofNullable(UserService.getOneById(id));
        }
    }

    @PutMapping("/edit")
    public void editUser(@Validated @ModelAttribute User user, BindingResult res){
        if ( !res.hasErrors()){
            UserService.edit(user);
        }
    }

    @PatchMapping("/patch")
    public void patchUser(@Validated @ModelAttribute User user, BindingResult res){
        if ( !res.hasErrors()){
            UserService.edit(user);
        }
    }

    @PostMapping("/add")
    public void createUser(@Validated @ModelAttribute User user, BindingResult res){
        if ( !res.hasErrors()){
            UserService.create(user);
        }
    }

    @DeleteMapping("{id}")
    public void deleteUser(@Validated @PathVariable long id, BindingResult res){
        if ( !res.hasErrors()){
            UserService.deleteById(id);
        }
    }

}

