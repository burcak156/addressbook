package org.freesoftware.service;

import java.util.List;

import org.freesoftware.model.Person;

public interface PersonService {
	public void addPerson(Person person);

	public List<Person> getAllPersons();

	public void deletePerson(Integer personId);

	public Person getPerson(int personId);

	public Person updatePerson(Person person);
}