package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Interfaz del Dao de cliente
 * 
 * @author Jose
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer> {

	public List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname);

}
