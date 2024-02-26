package com.Unyime.springTutorial.dao.impl;

import com.Unyime.springTutorial.TestDataUtil;
import com.Unyime.springTutorial.dao.AuthorDao;
import com.Unyime.springTutorial.domain.Author;
import com.Unyime.springTutorial.domain.Book;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTest {
    private final BookDaoImpl underTest;
    private final AuthorDao authorDao;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao){
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        Book book = TestDataUtil.createTestBook();
        authorDao.create(author);
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);

        Book book1 = TestDataUtil.createTestBook1();
        Book book2 = TestDataUtil.createTestBook2();
        Book book3 = TestDataUtil.createTestBook3();
        book1.setAuthorId(author.getId());
        book2.setAuthorId(author.getId());
        book3.setAuthorId(author.getId());
        underTest.create(book1);
        underTest.create(book2);
        underTest.create(book3);

        List<Book> result = underTest.find();
        assertThat(result)
                .hasSize(3)
                .containsExactly(book1, book2, book3);

    }

    @Test
    public void testThatBookCanBeUpdated(){

    }

}
