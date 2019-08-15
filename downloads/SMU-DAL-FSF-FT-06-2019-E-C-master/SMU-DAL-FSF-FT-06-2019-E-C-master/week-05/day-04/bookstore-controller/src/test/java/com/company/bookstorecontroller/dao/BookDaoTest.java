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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    BookRepository bookRepo;
    @Autowired
    AuthorRepository authorRepo;

    Books book1;
    Books book2;
    Books book3;

    Authors author1;
    Authors author2;

    @Before
    public void setUp() {
        bookRepo.deleteAll();
        authorRepo.deleteAll();

        book1 = new Books();
        book1.setTitle("The Gunsliner");
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
    }

    @Test
    @Transactional
    public void shouldAddBooks() {
        authorRepo.save(author1);
        bookRepo.save(book1);
        bookRepo.save(book2);

        assertNotNull(book1.getId());
        assertNotNull(book2.getId());
    }

    @Test
    @Transactional
    public void shouldGetBooks() {
        authorRepo.save(author1);

        book1.setAuthors(author1);
        bookRepo.save(book1);

        book2.setAuthors(author1);
        bookRepo.save(book2);

        List<Books> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        List<Books> fromRepo = bookRepo.findAll();

        assertEquals(bookList, fromRepo);
    }

    @Test
    @Transactional
    public void shouldDeleteBooks() {
        authorRepo.save(author1);
        book1.setAuthors(author1);
        bookRepo.save(book1);
        bookRepo.deleteById(book1.getId());
        Optional<Books> fromRepo = bookRepo.findById(book1.getId());
        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetBooksByTitle() {

        authorRepo.save(author1);
        book1.setAuthors(author1);
        bookRepo.save(book1);
        book2.setAuthors(author1);
        bookRepo.save(book2);
        authorRepo.save(author2);
        book3.setAuthors(author2);
        bookRepo.save(book3);

        List<Books> titleList = bookRepo.findByTitle(book3.getTitle());

        assertEquals(book3, titleList.get(0));
    }

    @Test
    @Transactional
    public void shouldGetBooksByAuthorLastName() {

        authorRepo.save(author1);
        book1.setAuthors(author1);
        bookRepo.save(book1);
        book2.setAuthors(author1);
        bookRepo.save(book2);
        authorRepo.save(author2);
        book3.setAuthors(author2);
        bookRepo.save(book3);

        List<Books> fromRepo = bookRepo.findByAuthorsLastName(book2.getAuthors().getLastName());

        assertEquals(2, fromRepo.size());

        fromRepo = bookRepo.findByAuthorsLastName(book3.getAuthors().getLastName());

        assertEquals(1, fromRepo.size());
    }

    @Test
    @Transactional
    public void shouldGetBooksByAuthorFullName() {

        authorRepo.save(author1);

        book1.setAuthors(author1);
        bookRepo.save(book1);

        book2.setAuthors(author1);
        bookRepo.save(book2);

        authorRepo.save(author2);

        book3.setAuthors(author2);
        bookRepo.save(book3);

        List<Books> fromRepo = bookRepo.findByAuthorsFirstNameAndAuthorsLastName(book2.getAuthors().getFirstName(), book2.getAuthors().getLastName());

        assertEquals(2, fromRepo.size());

        fromRepo = bookRepo.findByAuthorsFirstNameAndAuthorsLastName(book3.getAuthors().getFirstName(), book3.getAuthors().getLastName());

        assertEquals(1, fromRepo.size());
    }

    @After
    public void tearDown() {
        bookRepo.deleteAll();
        authorRepo.deleteAll();
    }
}
