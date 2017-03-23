package org.freesoftware.dao;

import java.util.List;
import org.freesoftware.model.Person;

public interface PersonDAO {

	public void addPerson(Person person);

	public List<Person> getAllPersons();

	public void deletePerson(Integer personId);

	public Person updatePerson(Person person);

	public Person getPerson(int personId);

}