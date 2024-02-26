package com.Unyime.springTutorial;

import com.Unyime.springTutorial.dao.AuthorDao;
import com.Unyime.springTutorial.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) {
        authorDao.create(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> optionalAuthor = authorDao.findOne(id);
        if (optionalAuthor.isPresent()) {
            return ResponseEntity.ok(optionalAuthor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

