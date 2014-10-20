package org.training.vmelnychuk;

import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by Vasyl_Melnychuk on 10/20/2014.
 */
public class PersonRun {
    static final Logger logger = Logger.getLogger(Person.class);
    public static void main(String[] args) {
        Person firstPeson = new Person();
        Person secondPerson = new Person("Vasyl", 154);
        logger.info("Initial objects state");
        logger.info(firstPeson);
        logger.info(secondPerson);

        logger.info("call void changeName");
        changeName(firstPeson);
        changeName(secondPerson);
        logger.info(firstPeson);
        logger.info(secondPerson);

        logger.info("call int changeNumber");
        firstPeson.setFavoriteNumber(changeNumber(firstPeson));
        secondPerson.setFavoriteNumber(changeNumber(secondPerson));
        logger.info(firstPeson);
        logger.info(secondPerson);

        logger.info("call Person changePerson");
        firstPeson = changePerson(firstPeson);
        secondPerson = changePerson(secondPerson);
        logger.info(firstPeson);
        logger.info(secondPerson);

        System.out.println("Press enter...");
        new Scanner(System.in).nextLine();
        System.out.println("ok");
    }
    public static void changeName(Person person) {
        person  = new Person();
        person.setName("Peter");
    }
    public static int changeNumber(Person person) {
        person  = new Person();
        person.setName("Peter");
        return 24;
    }

    public static Person changePerson(Person person) {
        person  = new Person();
        person.setName("Peter");
        return person;
    }
}
