package com.Unyime.springTutorial.services;

import com.Unyime.springTutorial.domain.entities.AuthorEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

     AuthorEntity save(AuthorEntity authorEntity);
}
