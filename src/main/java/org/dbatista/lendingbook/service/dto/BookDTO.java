package org.dbatista.lendingbook.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.dbatista.lendingbook.domain.Book} entity.
 */
public class BookDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private String author;

    private Integer yearOfPublication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookDTO)) {
            return false;
        }
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) && Objects.equals(title, bookDTO.title) && Objects.equals(description, bookDTO.description) && Objects.equals(author, bookDTO.author) && Objects.equals(yearOfPublication, bookDTO.yearOfPublication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, yearOfPublication);
    }
   
}
