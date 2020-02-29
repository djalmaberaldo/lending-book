package org.dbatista.lendingbook.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

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

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lending)) {
            return false;
        }
        return id != null && id.equals(((Lending) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Lending{" +
            "id=" + getId() +
            ", lendDate='" + getLendDate() + "'" +
            ", isActive='" + isIsActive() + "'" +
            "}";
    }
}
