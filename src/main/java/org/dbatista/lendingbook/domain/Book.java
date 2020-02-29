package org.dbatista.lendingbook.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
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

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Book title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Book description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public Book author(String author) {
        this.author = author;
        return this;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public Book yearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Set<Lending> getLendings() {
        return lendings;
    }

    public Book lendings(Set<Lending> lendings) {
        this.lendings = lendings;
        return this;
    }

    public Book addLendings(Lending lending) {
        this.lendings.add(lending);
        lending.setBook(this);
        return this;
    }

    public Book removeLendings(Lending lending) {
        this.lendings.remove(lending);
        lending.setBook(null);
        return this;
    }

    public void setLendings(Set<Lending> lendings) {
        this.lendings = lendings;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        return id != null && id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", author='" + getAuthor() + "'" +
            ", yearOfPublication=" + getYearOfPublication() +
            "}";
    }
}
