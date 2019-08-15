package com.company.bookstorecontroller.dao;

import com.company.bookstorecontroller.dao.AuthorRepository;
import com.company.bookstorecontroller.dao.BookRepository;
import com.company.bookstorecontroller.dto.Authors;
import com.company.bookstorecontroller.dto.Books;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorDaoTest {
    @Autowired
    BookRepository bookRepo;
    @Autowired
    AuthorRepository authorRepo;

    // test objects
    Books book1;
    Books book2;
    Books book3;

    Authors author1;
    Authors author2;
    Authors author3;

    @Before
    public void setUp() {

        bookRepo.deleteAll();
        authorRepo.deleteAll();

        book1 = new Books();
        book1.setTitle("The Gunslinger");
        book1.setPublishYear("1982");

        book2 = new Books();
        book2.setTitle("The Stand");
        book2.setPublishYear("1978");

        book3 = new Books();
        book3.setTitle("Harry Potter and the Philosopher's Stone");
        book3.setPublishYear("1997");

        author1 = new Authors();
        author1.setFirstName("Stephen");
        author1.setLastName("King");

        author2 = new Authors();
        author2.setFirstName("JK");
        author2.setLastName("Rowling");

        author3 = new Authors();
        author3.setFirstName("Tabitha");
        author3.setLastName("King");
    }

    @Test
    @Transactional
    public void shouldAddAuthors() {
        authorRepo.save(author1);
        authorRepo.save(author2);


        assertNotNull(author1.getId());
        assertNotNull(author2.getId());
    }

    @Test
    @Transactional
    public void shouldGetAuthors() {

        authorRepo.save(author1);
        book1.setAuthors(author1);
        book1.getAuthors().setId(author1.getId());
        bookRepo.save(book1);

        book2.setAuthors(author1);
        book2.getAuthors().setId(author1.getId());

        bookRepo.save(book2);

        Set<Books> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);

        List<Authors> fromRepo = authorRepo.findAll();

        assertEquals(author1, fromRepo.get(0));
    }

    @Test
    @Transactional
    public void shouldDeleteAuthors() {

        authorRepo.save(author1);

        authorRepo.deleteById(author1.getId());

        Optional<Authors> fromRepo = authorRepo.findById(author1.getId());

        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetAuthorsByLastName() {
        authorRepo.save(author1);

        authorRepo.save(author2);

        authorRepo.save(author3);

        List<Authors> author1List = authorRepo.findByLastName(author1.getLastName());

        assertEquals(2, author1List.size());

        List<Authors> notPresentList = authorRepo.findByLastName("Hawkins");
        assertEquals(0, notPresentList.size());
    }

    @Test
    @Transactional
    public void shouldGetAuthorsByFirstAndLastName() {
        authorRepo.save(author1);

        authorRepo.save(author2);

        authorRepo.save(author3);

        List<Authors> author1List = authorRepo.findByFirstNameAndLastName(author1.getFirstName(),author1.getLastName());

        assertEquals(1, author1List.size());

        List<Authors> notPresentList = authorRepo.findByFirstNameAndLastName("Stephen", "Hawkins");
        assertEquals(0, notPresentList.size());
    }

    @After
    public void tearDown() {
        bookRepo.deleteAll();
        authorRepo.deleteAll();
    }
}
