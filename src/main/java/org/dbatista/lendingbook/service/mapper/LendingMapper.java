package org.dbatista.lendingbook.service.mapper;


import org.dbatista.lendingbook.domain.*;
import org.dbatista.lendingbook.service.dto.LendingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Lending} and its DTO {@link LendingDTO}.
 */
@Mapper(componentModel = "spring", uses = {BookMapper.class, UserMapper.class})
public interface LendingMapper extends EntityMapper<LendingDTO, Lending> {

    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "userName")
    LendingDTO toDto(Lending lending);

    @Mapping(source = "bookId", target = "book")
    @Mapping(source = "userId", target = "user")
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
