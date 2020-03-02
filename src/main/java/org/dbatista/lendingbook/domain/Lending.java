package org.dbatista.lendingbook.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Lending.
 */
@Entity
@Table(name = "lending")
public class Lending implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lend_date")
    private ZonedDateTime lendDate;

    @OneToOne
    @JoinColumn(unique = true)
    private Book book;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;


    public Lending() {
    }

    public Lending(Long id, ZonedDateTime lendDate, Book book, User user) {
        this.id = id;
        this.lendDate = lendDate;
        this.book = book;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getLendDate() {
        return this.lendDate;
    }

    public void setLendDate(ZonedDateTime lendDate) {
        this.lendDate = lendDate;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lending id(Long id) {
        this.id = id;
        return this;
    }

    public Lending lendDate(ZonedDateTime lendDate) {
        this.lendDate = lendDate;
        return this;
    }

    public Lending book(Book book) {
        this.book = book;
        return this;
    }

    public Lending user(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lending)) {
            return false;
        }
        Lending lending = (Lending) o;
        return Objects.equals(id, lending.id) && Objects.equals(lendDate, lending.lendDate) && Objects.equals(book, lending.book) && Objects.equals(user, lending.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lendDate, book, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lendDate='" + getLendDate() + "'" +
            ", book='" + getBook() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

    
}
