package com.Unyime.springTutorial.domain.dto;

import com.Unyime.springTutorial.domain.entities.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private String isbn;

    private String title;

    private AuthorDto author;
}
