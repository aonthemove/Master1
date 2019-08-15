package com.company.bookstorecontroller.controller;

import com.company.bookstorecontroller.dto.Books;
import com.company.bookstorecontroller.service.BookStoreServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/books")
public class BookStoreController {

    @Autowired
    BookStoreServiceImplementation bookService;

    @GetMapping
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/title/{title}")
    public List<Books> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping(value = "/author/{lastName}")
    public List<Books> getBooksByAuthorLastName(@PathVariable String lastName) {
        return bookService.getBooksByAuthorLastName(lastName);
    }

    @GetMapping(value = "/author/{firstName}/{lastName}")
    public List<Books> getBooksByAuthorFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return bookService.getBooksByAuthorFullName(firstName, lastName);
    }

    @GetMapping(value = "/author/{lastName}/{startYear}/{endYear}")
    public List<Books> getBooksByAuthorLastNameAndYearRange(@PathVariable String lastName,
                                                            @PathVariable String startYear,
                                                            @PathVariable String endYear) {
        if (startYear.length() != 4 || endYear.length() != 4) {
            throw new IllegalArgumentException("Year must be exactly 4 digits");
        }

        return bookService.getBooksByAuthorLastNameAndYearRange(lastName, startYear, endYear);
    }

    @PostMapping
    public Books addBook(@RequestBody @Valid Books book) {
        return bookService.addBook(book);
    }
}
