package com.Unyime.springTutorial.dao;

import com.Unyime.springTutorial.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    public void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();

    void update(String isbn, Book book);

    void delete(String isbn);
}
