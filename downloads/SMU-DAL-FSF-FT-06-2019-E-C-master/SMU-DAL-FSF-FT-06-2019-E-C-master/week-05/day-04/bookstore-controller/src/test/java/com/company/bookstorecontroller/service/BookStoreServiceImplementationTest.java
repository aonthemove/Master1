package com.company.bookstorecontroller.service;

import com.company.bookstorecontroller.dao.BookRepository;
import com.company.bookstorecontroller.dto.Authors;
import com.company.bookstorecontroller.dto.Books;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookStoreServiceImplementationTest {
    @Mock
    @Autowired
    BookRepository bookRepoMock;

    @InjectMocks
    BookStoreServiceImplementation bookStoreService;

    Books book1;
    Books book2;
    Books book3;


    Authors author1;
    Authors author2;

    List<Books> bookList;

    @Before
    public void setup(){

        author1 = new Authors();
        author1.setFirstName("Stephen");
        author1.setLastName("King");

        author2 = new Authors();
        author2.setFirstName("JK");
        author2.setLastName("Rowling");

        book1 = new Books();
        book1.setTitle("The Gunslinger");
        book1.setPublishYear("1982");
        book1.setAuthors(author1);

        book2 = new Books();
        book2.setTitle("The Stand");
        book2.setPublishYear("1978");
        book2.setAuthors(author1);


        book3 = new Books();
        book3.setTitle("Harry Potter and the Philosopher's Stone");
        book3.setPublishYear("1997");
        book3.setAuthors(author2);

        bookList = Arrays.asList(book1, book2, book3);
    }


    @Test
    public void shouldGetAllBooks(){
        List<Books> expectedList = Arrays.asList(book1, book2, book3);
        when(bookRepoMock.findAll()).thenReturn(bookList);
        assertEquals(expectedList, bookStoreService.getAllBooks());
    }

    @Test
    public void shouldGetBooksByTitle(){
        List<Books> expectedList = Arrays.asList(book3);
        List<Books> bookList= Arrays.asList(book3);
        when(bookRepoMock.findByTitle(book3.getTitle())).thenReturn(bookList);
        assertEquals(expectedList, bookStoreService.getBooksByTitle(book3.getTitle()));
    }

    @Test
    public void shouldGetBooksByAuthorLastName(){
        List<Books> expectedList = Arrays.asList(book1, book2);
        List<Books> bookList= Arrays.asList(book1, book2);
        when(bookRepoMock.findByAuthorsLastName(book1.getAuthors().getLastName())).thenReturn(bookList);
        assertEquals(expectedList, bookStoreService.getBooksByAuthorLastName(book1.getAuthors().getLastName()));
    }



    @Test
    public void shouldGetBooksByAuthorFullName(){
        List<Books> expectedList = Arrays.asList(book1, book2);
        List<Books> bookList= Arrays.asList(book1, book2);
        when(bookRepoMock.findByAuthorsFirstNameAndAuthorsLastName(book1.getAuthors().getFirstName(), book1.getAuthors().getLastName())).thenReturn(bookList);
        assertEquals(expectedList, bookStoreService.getBooksByAuthorFullName(book1.getAuthors().getFirstName(), book1.getAuthors().getLastName()));
    }


    @Test
    public void shouldGetBooksByAuthorLastNameAndYearRangeInclusively(){
        List<Books> expectedList = Arrays.asList(book1, book2);
        List<Books> bookList= Arrays.asList(book1, book2);
        String startYear = book2.getPublishYear();
        String endYear = book1.getPublishYear();
        when(bookRepoMock.findByAuthorsLastName(book1.getAuthors().getLastName())).thenReturn(bookList);
        assertEquals(expectedList, bookStoreService.getBooksByAuthorLastNameAndYearRange(book1.getAuthors().getLastName(), startYear, endYear));
    }

    @Test
    public void shouldGetBooksByAuthorLastNameAndYearRangeExcludingBooksOutsideRange(){
        List<Books> expectedList = Arrays.asList(book2);
        List<Books> bookList= Arrays.asList(book1, book2);
        String startYear = book2.getPublishYear();
        String endYear = Integer.toString(Integer.parseInt(book1.getPublishYear()) - 1);
        when(bookRepoMock.findByAuthorsLastName(book1.getAuthors().getLastName())).thenReturn(bookList);
        assertEquals(expectedList, bookStoreService.getBooksByAuthorLastNameAndYearRange(book1.getAuthors().getLastName(), startYear, endYear));
    }
}
