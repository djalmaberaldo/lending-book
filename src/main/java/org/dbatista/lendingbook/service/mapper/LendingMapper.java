package org.dbatista.lendingbook.service.mapper;


import org.dbatista.lendingbook.domain.*;
import org.dbatista.lendingbook.service.dto.LendingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Lending} and its DTO {@link LendingDTO}.
 */
@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface LendingMapper extends EntityMapper<LendingDTO, Lending> {

    @Mapping(source = "book.id", target = "bookId")
    LendingDTO toDto(Lending lending);

    @Mapping(source = "bookId", target = "book")
    Lending toEntity(LendingDTO lendingDTO);

    default Lending fromId(Long id) {
        if (id == null) {
            return null;
        }
        Lending lending = new Lending();
        lending.setId(id);
        return lending;
    }
}
