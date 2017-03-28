package org.freesoftware.dao;

import java.util.List;

import org.freesoftware.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPerson(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return sessionFactory.getCurrentSession().createCriteria(Person.class).list();
	}

	@Override
	public void deletePerson(Integer personId) {
		Person person = (Person) sessionFactory.getCurrentSession().load(Person.class, personId);
		if (null != person) {
			this.sessionFactory.getCurrentSession().delete(person);
		}
	}

	@Override
	public Person updatePerson(Person person) {
		sessionFactory.getCurrentSession().update(person);
		return person;
	}

	@Override
	public Person getPerson(long personId) {
		return (Person) sessionFactory.getCurrentSession().get(Person.class, personId);
	}

}
