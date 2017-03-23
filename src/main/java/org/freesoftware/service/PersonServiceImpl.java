package org.freesoftware.service;

import java.util.List;

import org.freesoftware.dao.PersonDAO;
import org.freesoftware.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Override
	@Transactional
	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}

	@Override
	@Transactional
	public List<Person> getAllPersons() {
		return personDAO.getAllPersons();
	}

	@Override
	@Transactional
	public void deletePerson(Integer personId) {
		personDAO.deletePerson(personId);
	}

	@Override
	@Transactional
	public Person getPerson(int personId) {
		return personDAO.getPerson(personId);
	}

	@Override
	@Transactional
	public Person updatePerson(Person person) {
		return personDAO.updatePerson(person);
	}

}
