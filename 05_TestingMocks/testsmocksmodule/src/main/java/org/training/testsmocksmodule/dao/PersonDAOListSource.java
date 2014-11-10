package org.training.testsmocksmodule.dao;

import java.util.ArrayList;
import java.util.List;

import org.training.testsmocksmodule.model.Person;
import org.training.testsmocksmodule.model.ValidatePerson;

public class PersonDAOListSource implements PersonDAO {
    private List<Person> people;
    public PersonDAOListSource() {
        this.people = new ArrayList<Person>();
    }
    @Override
    public Person findById(long personId) {
        for(Person person : people) {
            if(person.getId() == personId)
                return person;
        }
        return null;
    }

    @Override
    public long save(Person person) {
        if (ValidatePerson.isValid(person)) {
            people.add(person);
            return person.getId();
        }
        return -1;
    }

    @Override
    public boolean update(Person person) {
        Person savedPerson = findById(person.getId());
        if (savedPerson == null)
            return false;
        savedPerson = person;
        return true;
    }

    @Override
    public boolean delete(Person person) {
        return people.remove(person);
    }
    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "PersonDAOListSource{" +
                "people=" + people +
                '}';
    }
}
