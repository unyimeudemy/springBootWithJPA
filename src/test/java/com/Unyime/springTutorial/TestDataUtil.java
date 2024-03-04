package com.Unyime.springTutorial;

import com.Unyime.springTutorial.domain.dto.AuthorDto;
import com.Unyime.springTutorial.domain.dto.BookDto;
import com.Unyime.springTutorial.domain.entities.AuthorEntity;
import com.Unyime.springTutorial.domain.entities.BookEntity;

public final class TestDataUtil {

    private TestDataUtil(){}

    public static AuthorEntity createTestAuthor() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(10)
                .build();
    }

    public static AuthorEntity createTestAuthor1() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(20)
                .build();
    }

    public static AuthorEntity createTestAuthor2() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Abigail Rose")
                .age(30)
                .build();
    }

    public static AuthorEntity createTestAuthor3() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Abigail Rose")
                .age(40)
                .build();
    }

    public static BookEntity createTestBook(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBook1(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBook2(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-1")
                .title("The Shadow in the Attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBook3(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Shadow in the Attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createBookDto(final AuthorDto author) {
        return BookDto.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Shadow in the Basement")
                .author(author)
                .build();
    }

    public static AuthorDto createAuthorDto() {
        return AuthorDto.builder()
                .id(3L)
                .name("Angela Rose")
                .age(70)
                .build();
    }
}
