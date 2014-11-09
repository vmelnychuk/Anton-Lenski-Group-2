package org.training.testsmocksmodule.model;

public class Person {
	private static volatile long ids = 1L;
	private final long id;
	private String firstName;
	private String lastName;
	private String position;

	public Person() {
		this.id = ids++;
		this.firstName = "Nonename";
		this.lastName = "Nonename";
		this.position = "unemployed";
	}
	
	public Person(String fistName, String lastName) {
		this.id = ids++;
		this.firstName = fistName;
		this.lastName = lastName;
	}


	public Person(String firstName, String lastName, String position) {
		if (firstName == null)
			throw new PersonException("firstName is empty");
		if (lastName == null)
			throw new PersonException("lastName is empty");
		this.id = ids++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
	}
	
	public long getId() {
		return id;
	}
	public void setFirstName(String firstName) {
		if (firstName == null)
			throw new PersonException("fistName is set empty");
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		if (lastName == null)
			throw new PersonException("lastName is set empty");
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void hire(String position) {
		if (this.position != null)
			throw new PersonException("can't hire umployed person");
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void fire() {
		if (position == null)
			throw new PersonException("can't fire unemployed person");
		position = null;
	}
}
