package pl.coderslab.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Group;
import pl.coderslab.model.Publisher;


@Component
@Transactional
public class PublisherDao {
	@PersistenceContext
	EntityManager entityManager;
	

	public Collection<Publisher> getAll() {
		Query query = entityManager.createQuery("SELECT p FROM Publisher p");
		return (Collection<Publisher>) query.getResultList();
	}
	
	public void save(Publisher entity) {
		entityManager.persist(entity);
	}

	public Publisher findById(long id) {
		return entityManager.find(Publisher.class, id);
	}

	public void update(Publisher entity) {
		entityManager.merge(entity);
	}

	public void delete(Publisher entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
