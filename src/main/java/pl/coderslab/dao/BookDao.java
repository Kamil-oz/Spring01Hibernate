package pl.coderslab.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Book;

@Component
@Transactional
public class BookDao {
	@PersistenceContext
	EntityManager entityManager;

	public Collection<Book> getAllPropositions(){
		Query query = entityManager.createQuery("SELECT b FROM Book b WHERE proposition=1");
		return (Collection<Book>) query.getResultList();
	}

	
	public Collection<Book> getAll(){
		Query query = entityManager.createQuery("SELECT b FROM Book b");
		return (Collection<Book>) query.getResultList();
	}
	
	public void saveBook(Book entity) {
		entityManager.persist(entity);
	}

	public Book findById(long id) {
		return entityManager.find(Book.class, id);
	}

	public void update(Book entity) {
		entityManager.merge(entity);
	}

	public void delete(Book entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
