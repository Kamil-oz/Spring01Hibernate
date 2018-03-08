package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	List<Author> findAuthorByLastNameLike(String LastName);
	@Query("SELECT b WHERE Book b WHERE b.pesel LIKE '?1%")
	List<Author> findAuthorWhichPeselStartsWith(String prefix);
}
