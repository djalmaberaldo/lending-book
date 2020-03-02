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

    private Long bookId;

    private Long userId;

    private String bookTitle;

    private String userName;

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

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LendingDTO id(Long id) {
        this.id = id;
        return this;
    }

    public LendingDTO lendDate(ZonedDateTime lendDate) {
        this.lendDate = lendDate;
        return this;
    }

    public LendingDTO bookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public LendingDTO userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public LendingDTO bookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
        return this;
    }

    public LendingDTO userName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LendingDTO)) {
            return false;
        }
        LendingDTO lendingDTO = (LendingDTO) o;
        return Objects.equals(id, lendingDTO.id) && Objects.equals(lendDate, lendingDTO.lendDate) && Objects.equals(bookId, lendingDTO.bookId) && Objects.equals(userId, lendingDTO.userId) && Objects.equals(bookTitle, lendingDTO.bookTitle) && Objects.equals(userName, lendingDTO.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lendDate, bookId, userId, bookTitle, userName);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lendDate='" + getLendDate() + "'" +
            ", bookId='" + getBookId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", bookTitle='" + getBookTitle() + "'" +
            ", userName='" + getUserName() + "'" +
            "}";
    }

   
}
