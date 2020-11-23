package ru.sber.jd.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sber.jd.entities.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
}
