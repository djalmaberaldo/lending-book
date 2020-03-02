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

    private Long ownerId;

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

    public Long getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public BookDTO id(Long id) {
        this.id = id;
        return this;
    }

    public BookDTO title(String title) {
        this.title = title;
        return this;
    }

    public BookDTO description(String description) {
        this.description = description;
        return this;
    }

    public BookDTO author(String author) {
        this.author = author;
        return this;
    }

    public BookDTO yearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;
    }

    public BookDTO ownerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BookDTO)) {
            return false;
        }
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) && Objects.equals(title, bookDTO.title) && Objects.equals(description, bookDTO.description) && Objects.equals(author, bookDTO.author) && Objects.equals(yearOfPublication, bookDTO.yearOfPublication) && Objects.equals(ownerId, bookDTO.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, yearOfPublication, ownerId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", author='" + getAuthor() + "'" +
            ", yearOfPublication='" + getYearOfPublication() + "'" +
            ", ownerId='" + getOwnerId() + "'" +
            "}";
    }
   
   
}
