package com.Unyime.springTutorial.controllers;

import com.Unyime.springTutorial.domain.dto.AuthorDto;
import com.Unyime.springTutorial.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto author){
        return authorService.createAuthor(author);
    }
}
