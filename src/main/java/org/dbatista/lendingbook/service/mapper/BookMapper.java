package org.dbatista.lendingbook.service.mapper;


import org.dbatista.lendingbook.domain.*;
import org.dbatista.lendingbook.service.dto.BookDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Book} and its DTO {@link BookDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BookMapper extends EntityMapper<BookDTO, Book> {

    @Mapping(source = "owner.id", target = "ownerId")
    BookDTO toDto(Book book);

    @Mapping(target = "lendings", ignore = true)
    Book toEntity(BookDTO bookDTO);

    default Book fromId(Long id) {
        if (id == null) {
            return null;
        }
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
