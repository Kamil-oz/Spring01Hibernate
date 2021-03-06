package pl.coderslab.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;

@Component
@Transactional
public class AuthorDao {
	@PersistenceContext
	EntityManager entityManager;


	public Collection<Author> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Author a");
		return (Collection<Author>) query.getResultList();
	} 
	
	public void save(Author entity) {
		entityManager.persist(entity);
	}

	public Author findById(long id) {
		return entityManager.find(Author.class, id);
	}

	public void update(Author entity) {
		entityManager.merge(entity);
	}

	public void delete(Author entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
