package com.Unyime.springTutorial.services;


import com.Unyime.springTutorial.domain.entities.BookEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    BookEntity save(BookEntity bookEntity);
}
