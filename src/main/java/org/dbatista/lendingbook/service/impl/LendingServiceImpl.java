package org.dbatista.lendingbook.service.impl;

import org.dbatista.lendingbook.service.LendingService;
import org.dbatista.lendingbook.domain.Lending;
import org.dbatista.lendingbook.repository.LendingRepository;
import org.dbatista.lendingbook.service.dto.BookDTO;
import org.dbatista.lendingbook.service.dto.LendingDTO;
import org.dbatista.lendingbook.service.mapper.BookMapper;
import org.dbatista.lendingbook.service.mapper.LendingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Lending}.
 */
@Service
@Transactional
public class LendingServiceImpl implements LendingService {

    private final Logger log = LoggerFactory.getLogger(LendingServiceImpl.class);
    
    @Autowired
    private LendingRepository lendingRepository;

    @Autowired
    private LendingMapper lendingMapper;

    @Autowired
    private BookMapper bookMapper;

    /**
     * Save a lending.
     *
     * @param lendingDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public LendingDTO save(LendingDTO lendingDTO) {
        log.debug("Request to save Lending : {}", lendingDTO);
        Lending lending = lendingMapper.toEntity(lendingDTO);
        lending.setLendDate(ZonedDateTime.now());
        lending = lendingRepository.save(lending);
        return lendingMapper.toDto(lending);
    }

    /**
     * Get all the lendings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<LendingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Lendings");
        return lendingRepository.findAll(pageable).map(lendingMapper::toDto);
    }

    /**
     * Get one lending by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LendingDTO> findOne(Long id) {
        log.debug("Request to get Lending : {}", id);
        return lendingRepository.findById(id).map(lendingMapper::toDto);
    }

    /**
     * Delete the lending by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Lending : {}", id);
        lendingRepository.deleteById(id);
    }

    @Override
    public Page<BookDTO> findAllWithUser(Pageable pageable, Long userId) {
        return lendingRepository.findAllBooksWithUser(userId, pageable).map(bookMapper::toDto);
    }
}
