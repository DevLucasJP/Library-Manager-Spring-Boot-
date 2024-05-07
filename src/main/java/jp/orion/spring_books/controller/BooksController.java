package jp.orion.spring_books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.orion.spring_books.model.entity.Books;
import jp.orion.spring_books.model.repository.BooksRepo;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksRepo booksRepo;

	@PostMapping("/addBook")
	public @ResponseBody Books addBook(@RequestBody Books book) {

//		boolean nameLength = name.length() > 255 ? true : false;
//		boolean authorLength = author.length() > 255 ? true : false;

		booksRepo.save(book);
		return book;
	}

//	@GetMapping("/all")
//	public Iterable<Books> getBooks() {
//		return booksRepo.findAll();
//	}

	@GetMapping(path = "/pag/{num}")
	public Iterable<Books> getBooksByPag(@PathVariable int num) {

		Pageable pag = PageRequest.of(num - 1, 10);
		return booksRepo.findAll(pag);
	}

	@PutMapping("/updateBook")
	public Books updateBook(@Validated Books book) {

		booksRepo.save(book);
		return book;
	}

	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable int id) {
		booksRepo.deleteById(id);
	}
}
