package org.training.testsmocksmodule.dao;


import java.util.List;

import org.training.testsmocksmodule.model.Person;

public interface PersonDAO {
	public Person findById(long personId);
	public long save(Person person);
	public boolean update(Person person);
	public boolean delete(Person person);
	public List<Person> getPeople();
}
