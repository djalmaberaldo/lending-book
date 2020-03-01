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

    private Long userId;

    private String bookTitle;

    private String userName;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LendingDTO)) {
            return false;
        }
        LendingDTO lendingDTO = (LendingDTO) o;
        return Objects.equals(id, lendingDTO.id) && Objects.equals(lendDate, lendingDTO.lendDate) && Objects.equals(isActive, lendingDTO.isActive) && Objects.equals(bookId, lendingDTO.bookId) && Objects.equals(userId, lendingDTO.userId) && Objects.equals(bookTitle, lendingDTO.bookTitle) && Objects.equals(userName, lendingDTO.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lendDate, isActive, bookId, userId, bookTitle, userName);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lendDate='" + getLendDate() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", bookId='" + getBookId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", bookTitle='" + getBookTitle() + "'" +
            ", userName='" + getUserName() + "'" +
            "}";
    }


}
