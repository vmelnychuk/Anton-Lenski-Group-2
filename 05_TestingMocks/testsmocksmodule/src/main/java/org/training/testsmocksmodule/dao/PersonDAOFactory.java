package org.training.testsmocksmodule.dao;

public class PersonDAOFactory {
	private static PersonDAO dao = null;
	public static PersonDAO getDAO() {
		if(dao != null)
			return dao;
		dao = new PersonDAOListSource();
		return dao;
	}
}
