package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findOneByTitle(String title);
	long countByTitle(String title);
	List<Book> findByPublisherId(long id);
	List<Book> findByRating(int rating);
	List<Book> findByAuthorsId(long id);
	Book findFirstByAuthorsOrderByTitle(Author author);
	List<Book> findByAuthors(Author author);
}
