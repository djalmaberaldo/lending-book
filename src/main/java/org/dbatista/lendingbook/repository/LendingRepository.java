package org.dbatista.lendingbook.repository;

import org.dbatista.lendingbook.domain.Book;
import org.dbatista.lendingbook.domain.Lending;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Lending entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LendingRepository extends JpaRepository<Lending, Long> {

    @Query("Select book "
    + "FROM Lending lending "
    + "LEFT JOIN lending.book book "
    + "WHERE lending.user.id = ?1")
    Page<Book> findAllBooksWithUser(Long id, Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(Lending) > 0 THEN 'true' ELSE 'false' END "
        + "FROM Lending lending "
        + "WHERE lending.book.id = ?1 "
        + "AND lending.user.id != ?2 "
        + "AND  lending.isActive=true")
    boolean existOtherWithBookAndUser(Long bookId, Long userId);

}
