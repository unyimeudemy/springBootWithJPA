package com.Unyime.springTutorial.repository;

import com.Unyime.springTutorial.domain.entities.BookEntity;
import org.hibernate.query.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> ,
        PagingAndSortingRepository<BookEntity, String> {
}
