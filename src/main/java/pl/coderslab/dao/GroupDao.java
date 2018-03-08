package pl.coderslab.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.model.Group;

@Component
@Transactional
public class GroupDao {
	@PersistenceContext
	EntityManager entityManager;

	public Collection<Group> getAll() {
		Query query = entityManager.createQuery("select group from Group group");
		return (Collection<Group>) query.getResultList();
	}

}
