package com.company.bookstorecontroller.dao;

import com.company.bookstorecontroller.dto.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Integer> {
    List<Authors> findByLastName(String lastName);
    List<Authors> findByFirstNameAndLastName(String firstName, String lastName);
}
