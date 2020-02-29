package org.dbatista.lendingbook.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.dbatista.lendingbook.domain.Lending} entity.
 */
public class LendingDTO implements Serializable {

    private Long id;

    private ZonedDateTime lendDate;

    private Boolean isActive;

    private Long bookId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getLendDate() {
        return lendDate;
    }

    public void setLendDate(ZonedDateTime lendDate) {
        this.lendDate = lendDate;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LendingDTO lendingDTO = (LendingDTO) o;
        if (lendingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), lendingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LendingDTO{" +
            "id=" + getId() +
            ", lendDate='" + getLendDate() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", bookId=" + getBookId() +
            "}";
    }
}
