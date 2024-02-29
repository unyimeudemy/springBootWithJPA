package com.Unyime.springTutorial.repository;

import com.Unyime.springTutorial.TestDataUtil;
import com.Unyime.springTutorial.domain.entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorEntityRepositoryIntegrationTest {

    private final AuthorRepository underTest;

    @Autowired
    public AuthorEntityRepositoryIntegrationTest(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthor();
        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity1 = TestDataUtil.createTestAuthor1();
        AuthorEntity authorEntity2 = TestDataUtil.createTestAuthor2();
        AuthorEntity authorEntity3 = TestDataUtil.createTestAuthor3();

        underTest.save(authorEntity1);
        underTest.save(authorEntity2);
        underTest.save(authorEntity3);

        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(authorEntity1, authorEntity2, authorEntity3);
    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthor();
        underTest.save(authorEntity);
        authorEntity.setName("UPDATED");
        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthor();
        underTest.save(authorEntity);
        underTest.deleteById(authorEntity.getId());
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAuthorWithLessThan(){
        AuthorEntity authorEntity1 = TestDataUtil.createTestAuthor1();
        AuthorEntity authorEntity2 = TestDataUtil.createTestAuthor2();
        AuthorEntity authorEntity3 = TestDataUtil.createTestAuthor3();

        underTest.save(authorEntity1);
        underTest.save(authorEntity2);
        underTest.save(authorEntity3);

        Iterable<AuthorEntity> result = underTest.ageLessThan(40);
        assertThat(result).containsExactly(authorEntity1, authorEntity2);

    }

    @Test
    public void testThatAuthorWithAgeGreaterThan(){
        AuthorEntity authorEntity1 = TestDataUtil.createTestAuthor1();
        AuthorEntity authorEntity2 = TestDataUtil.createTestAuthor2();
        AuthorEntity authorEntity3 = TestDataUtil.createTestAuthor3();

        underTest.save(authorEntity1);
        underTest.save(authorEntity2);
        underTest.save(authorEntity3);

        Iterable<AuthorEntity> result = underTest.findAuthorWithAgeGreaterThan(30);
        assertThat(result).containsExactly(authorEntity3);
    }
}
