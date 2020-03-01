package org.dbatista.lendingbook.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Book.
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "year_of_publication")
    private Integer yearOfPublication;

    @OneToMany(mappedBy = "book")
    private Set<Lending> lendings = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfPublication() {
        return this.yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Set<Lending> getLendings() {
        return this.lendings;
    }

    public void setLendings(Set<Lending> lendings) {
        this.lendings = lendings;
    }

    public Book id(Long id) {
        this.id = id;
        return this;
    }

    public Book title(String title) {
        this.title = title;
        return this;
    }

    public Book description(String description) {
        this.description = description;
        return this;
    }

    public Book author(String author) {
        this.author = author;
        return this;
    }

    public Book yearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;
    }

    public Book lendings(Set<Lending> lendings) {
        this.lendings = lendings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(author, book.author) && Objects.equals(yearOfPublication, book.yearOfPublication) && Objects.equals(lendings, book.lendings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, yearOfPublication, lendings);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", author='" + getAuthor() + "'" +
            ", yearOfPublication='" + getYearOfPublication() + "'" +
            ", lendings='" + getLendings() + "'" +
            "}";
    }


}
