package com.company.bookstorecontroller.service;

import com.company.bookstorecontroller.dao.AuthorRepository;
import com.company.bookstorecontroller.dao.BookRepository;
import com.company.bookstorecontroller.dto.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookStoreServiceImplementation implements BookStoreService {
    @Autowired
    BookRepository bookRepo;
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public List<Books> getAllBooks() {

        return bookRepo.findAll();
    }

    @Override
    public List<Books> getBooksByTitle(String title) {

        return bookRepo.findByTitle(title);
    }

    @Override
    public List<Books> getBooksByAuthorLastName(String lastName) {

        return bookRepo.findByAuthorsLastName(lastName);
    }

    @Override
    public List<Books> getBooksByAuthorFullName(String firstName, String lastName) {
        return bookRepo.findByAuthorsFirstNameAndAuthorsLastName(firstName, lastName);
    }

    @Override
    public List<Books> getBooksByAuthorLastNameAndYearRange(String lastName, String startYear, String endYear) {
        List<Books> bookList = bookRepo.findByAuthorsLastName(lastName)
                .stream()
                .filter(book -> book.getPublishYear().compareTo(startYear) >= 0 &&
                        book.getPublishYear().compareTo(endYear) <= 0 )
                .collect(Collectors.toList());
        return bookList;
    }

    public Books addBook(Books book) {
        return bookRepo.save(book);
    }
}
