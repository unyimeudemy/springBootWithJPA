package com.Unyime.springTutorial.dao.impl;

import com.Unyime.springTutorial.TestDataUtil;
import com.Unyime.springTutorial.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTest {

    private final AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTest (AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author author1 = TestDataUtil.createTestAuthor1();
        Author author2 = TestDataUtil.createTestAuthor2();
        Author author3 = TestDataUtil.createTestAuthor3();

        underTest.create(author1);
        underTest.create(author2);
        underTest.create(author3);

        List<Author> result = underTest.find();
        assertThat(result)
                .hasSize(3)
                .containsExactly(author1, author2,author3);
    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        author.setName("UPDATED");
        underTest.update(author.getId(), author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);

    }
}
