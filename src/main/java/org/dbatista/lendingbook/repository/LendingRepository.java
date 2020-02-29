package org.dbatista.lendingbook.repository;

import org.dbatista.lendingbook.domain.Lending;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Lending entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LendingRepository extends JpaRepository<Lending, Long> {

}
