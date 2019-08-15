package com.company.bookstorecontroller.dto;

import com.company.bookstorecontroller.dto.Authors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    @NotNull
    @Length(max = 100)
    private String title;
    @NotNull
    @Length(min = 4, max = 4)
    private String publishYear;
    @NotNull
    private Integer authorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId", updatable = false, insertable = false)
    private Authors authors;

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publish_year) {
        this.publishYear = publish_year;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books book = (Books) o;
        return Objects.equals(getId(), book.getId()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getPublishYear(), book.getPublishYear()) &&
                Objects.equals(getAuthors(), book.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPublishYear(), getAuthors());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", author=" + authors +
                '}';
    }
}
