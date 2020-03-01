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

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne
    @JoinColumn(unique = true)
    private Book book;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getLendDate() {
        return lendDate;
    }

    public Lending lendDate(ZonedDateTime lendDate) {
        this.lendDate = lendDate;
        return this;
    }

    public void setLendDate(ZonedDateTime lendDate) {
        this.lendDate = lendDate;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Lending isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Book getBook() {
        return book;
    }

    public Lending book(Book book) {
        this.book = book;
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lending)) {
            return false;
        }
        Lending lending = (Lending) o;
        return Objects.equals(id, lending.id) && Objects.equals(lendDate, lending.lendDate) && Objects.equals(isActive, lending.isActive) && Objects.equals(book, lending.book) && Objects.equals(user, lending.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lendDate, isActive, book, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lendDate='" + getLendDate() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", book='" + getBook() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}
