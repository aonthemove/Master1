package com.company.bookstorecontroller.dao;

import com.company.bookstorecontroller.dto.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    List<Books> findByTitle(String title);

    List<Books> findByAuthorsLastName(String lastName);

    List<Books> findByAuthorsFirstNameAndAuthorsLastName(String firstName, String lastName);
}