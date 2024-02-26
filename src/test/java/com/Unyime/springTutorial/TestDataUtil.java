package com.Unyime.springTutorial;

import com.Unyime.springTutorial.domain.Author;
import com.Unyime.springTutorial.domain.Book;

public final class TestDataUtil {

    private TestDataUtil(){}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthor1() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthor2() {
        return Author.builder()
                .id(2L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthor3() {
        return Author.builder()
                .id(3L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book createTestBook1() {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book createTestBook2() {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book createTestBook3() {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }
}
