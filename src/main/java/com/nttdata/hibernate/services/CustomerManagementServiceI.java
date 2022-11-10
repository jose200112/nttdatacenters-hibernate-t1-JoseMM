package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Customer;

/**
 * Interfaz de Servicios
 * 
 * @author Jose
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final Customer newCustomer);

	/**
	 * Actualiza un cliente
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final Customer updatedCustomer);

	/**
	 * Borra un cliente
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final Customer deletedCustomer);

	/**
	 * Busca los clientes por id
	 * 
	 * @param customerId
	 * @return Customer
	 */
	public Customer searchById(final Long customerId);

	/**
	 * Busca todos los clientes
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchAll();

	/**
	 * Busca los clientes por nombre y apellidos
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname);

}
