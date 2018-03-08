package pl.coderslab.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Author;

@Component
@Transactional
public class AuthorDao {
	@PersistenceContext
	EntityManager entityManager;

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
