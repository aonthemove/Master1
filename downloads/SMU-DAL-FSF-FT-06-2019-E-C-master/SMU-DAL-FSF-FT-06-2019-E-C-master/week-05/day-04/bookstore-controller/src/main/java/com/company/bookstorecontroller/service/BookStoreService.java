package com.company.bookstorecontroller.service;

import com.company.bookstorecontroller.dto.Books;

import java.util.List;

public interface BookStoreService {
    List<Books> getAllBooks();
    List<Books> getBooksByTitle(String title);
    List<Books> getBooksByAuthorLastName(String lastName);
    List<Books> getBooksByAuthorFullName(String firstName, String lastName);
    List<Books> getBooksByAuthorLastNameAndYearRange(String lastName, String startYear, String endYear);
}
