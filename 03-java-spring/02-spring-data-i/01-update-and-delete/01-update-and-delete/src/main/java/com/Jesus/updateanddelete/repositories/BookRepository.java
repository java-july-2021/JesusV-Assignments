package com.Jesus.updateanddelete.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Jesus.updateanddelete.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
}
