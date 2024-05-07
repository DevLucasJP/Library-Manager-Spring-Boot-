package jp.orion.spring_books.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import jp.orion.spring_books.model.entity.Books;

public interface BooksRepo extends CrudRepository<Books, Integer>, PagingAndSortingRepository<Books, Integer> {

}
