package org.training.testsmocksmodule.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
	@Test
	public void testConstructors() {
		Person person = new Person("Vasyl", "Melnychuk");
		assertEquals(person.getFirstName(), "Vasyl");
		assertEquals(person.getLastName(), "Melnychuk");
		person = new Person("Vasyl", "Melnychuk", "Developer");
		assertNotNull(person.getPosition());
	}
	@Test(expected=PersonException.class)
	public void testConstructorsWithNulls() {
		Person person = new Person("Vasyl", null, null);
		person.fire();
	}
	
	@Test
	public void testAccesors() {
		Person person = new Person();
		person.setFirstName("Petro");
		person.setLastName("Petrenko");
		assertEquals(person.getFirstName(), "Petro");
		assertEquals(person.getLastName(), "Petrenko");
	}
	@Test
	public void testHireFire() {
		Person person = new Person("Vasyl", "Melnychuk");
		person.hire("Developer");
		assertEquals(person.getPosition(), "Developer");
		person.fire();
		assertNull(person.getPosition());
		assertEquals(null, person.getPosition());
	}
	
}
