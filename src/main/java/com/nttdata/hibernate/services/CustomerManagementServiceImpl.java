package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.persistence.CustomerDaoI;
import com.nttdata.hibernate.persistence.CustomerDaoImpl;

/**
 * Clase servicios de cliente
 * 
 * @author Jose
 *
 */
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {
	private CustomerDaoI customerDao;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public CustomerManagementServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(Customer newCustomer) {
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Insercci�n del nuevo cliente.
			customerDao.insert(newCustomer);
		}
	}

	@Override
	public void updateCustomer(Customer updatedCustomer) {
		// Verificaci�n de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Actualizaci�n del jugador.
			customerDao.update(updatedCustomer);
		}
	}

	@Override
	public void deleteCustomer(Customer deletedCustomer) {
		// Verificaci�n de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Eliminaci�n del jugador.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public Customer searchById(Long customerId) {
		// Resultado.
		Customer customer = null;

		// Verificaci�n de nulidad.
		if (customerId != null) {

			// Obtenci�n del partido por ID.
			customer = customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	public List<Customer> searchAll() {

		// Resultado.
		List<Customer> customerList;

		// Obtenci�n de equipos.
		customerList = customerDao.searchAll();

		return customerList;
	}

	@Override
	public List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname) {
		List<Customer> customers = new ArrayList<>();

		// Verificaci�n de nulidad.
		if (name != null && firstSurname != null && secondSurname != null) {

			// Obtenci�n del cliente por dni.
			customers = customerDao.searchByNameAndSurnames(name, firstSurname, secondSurname);
		}

		return customers;
	}

}