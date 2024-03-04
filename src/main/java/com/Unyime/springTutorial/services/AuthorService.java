package com.Unyime.springTutorial.services;

import com.Unyime.springTutorial.domain.dto.AuthorDto;
import com.Unyime.springTutorial.domain.entities.AuthorEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {

     AuthorEntity save(AuthorEntity authorEntity);

     List<AuthorEntity> findAll();

     Optional<AuthorEntity> findOne(Long isbn);

    boolean isExists(Long id);

    AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    void delete(Long id);
}
