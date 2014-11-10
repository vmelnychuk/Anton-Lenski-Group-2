package org.training.testsmocksmodule.model;

import org.junit.BeforeClass;
import org.junit.Test;
import org.training.testsmocksmodule.dao.PersonDAO;
import org.training.testsmocksmodule.dao.PersonDAOFactory;

import static org.junit.Assert.*;

public class ValidatePersonTest {
    private static PersonDAO people;
    @BeforeClass
    public static void setUpBeforeClass() {
        people = PersonDAOFactory.getDAO();
    }
    @Test
    public void testIsValidWithValidPerson() {
        Person person = new Person("Vasyl", "Melnychuk", "Developer");
        people.save(person);
    }

    @Test(expected=PersonValidationException.class)
    public void testIsValidWithInvalidPerson() {
        Person person = new Person("Vasyl", "Melnychuk", "Developer111");
        people.save(person);
    }
}