package pl.coderslab.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Person;

@Component
@Transactional
public class PersonDao {
	@PersistenceContext
	EntityManager entityManager;

	public void save(Person person) {
		entityManager.persist(person);
	}

	public Person findById(long id) {
		return entityManager.find(Person.class, id);
	}
}
