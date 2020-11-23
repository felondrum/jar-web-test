package ru.sber.jd.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.jd.dto.BookDto;
import ru.sber.jd.entities.BookEntity;
import ru.sber.jd.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookServices {

    private final BookRepository bookRepository;

    public BookDto save (BookDto dto) {
        BookEntity save = bookRepository.save(mapToEntity(dto));
        return mapToDto(save);
    }

    private BookEntity mapToEntity(BookDto dto) {
        BookEntity entity = new BookEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setYear(dto.getYear());
        return entity;
    }


    public BookDto getById(Integer id) {
        return mapToDto(bookRepository.findById(id).orElse(new BookEntity()));
    }

    public List<BookDto> getAll () {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).map(this::mapToDto).collect(Collectors.toList());

    }

    private BookDto mapToDto(BookEntity bookEntity) {
        BookDto dto = new BookDto();
        dto.setId(bookEntity.getId());
        dto.setName(bookEntity.getName());
        dto.setYear(bookEntity.getYear());
        return dto;
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

}
