package org.freesoftware.service;

import java.util.List;

import org.freesoftware.model.Person;

public interface PersonService {
	public void addPerson(Person person);

	public List<Person> getAllPersons();

	public void deletePerson(long personId);

	public Person getPerson(long personId);

	public Person updatePerson(Person person);
}