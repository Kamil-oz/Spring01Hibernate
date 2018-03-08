package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findOneByTitle(String title);
	long countByTitle(String title);
	List<Book> findByAuthors(long id);
}
