package org.training.testsmocksmodule;

import org.apache.log4j.Logger;
import org.training.testsmocksmodule.dao.PersonDAO;
import org.training.testsmocksmodule.dao.PersonDAOFactory;
import org.training.testsmocksmodule.model.Person;


public class App {
    private final static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args ) {
        PersonDAO people = PersonDAOFactory.getDAO();
        Person p1 = new Person("V", "D", "Developer");
        Person p2 = new Person("K", "J", "Tester");
        people.save(p1);
        people.save(p2);
        logger.info(people);
    }
}
