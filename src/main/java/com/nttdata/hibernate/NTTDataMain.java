package com.nttdata.hibernate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;

/**
 * Clase main
 * 
 * @author Jose
 *
 */
public class NTTDataMain {

	/** Log **/
	private static Logger log = LoggerFactory.getLogger(NTTDataMain.class);

	/**
	 * Metodo main
	 * 
	 * @param args - main
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);

		// Creacion de clientes
		final Customer customer1 = new Customer();
		customer1.setName("Juan");
		customer1.setFirstSurname("Lopez");
		customer1.setSecondSurname("Garcia");
		customer1.setDNI("45231232R");

		final Customer customer2 = new Customer();
		customer2.setName("Maria");
		customer2.setFirstSurname("Hernandez");
		customer2.setSecondSurname("Ochoa");
		customer2.setDNI("35960432Y");

		final Customer customer3 = new Customer();
		customer3.setName("Antonio");
		customer3.setFirstSurname("Navarro");
		customer3.setSecondSurname("Jimenez");
		customer3.setDNI("94532345F");

		final Customer customer4 = new Customer();
		customer4.setName("Manuel");
		customer4.setFirstSurname("Rincon");
		customer4.setSecondSurname("Rivera");
		customer4.setDNI("45954394F");

		// Inserccion de los clientes
		customerService.insertNewCustomer(customer1);
		customerService.insertNewCustomer(customer2);
		customerService.insertNewCustomer(customer3);
		customerService.insertNewCustomer(customer4);

		// Consultas
		List<Customer> customers = customerService.searchAll();

		Customer customerById = customerService.searchById(2L);

		List<Customer> customerByName = customerService.searchByNameAndSurnames("Antonio", "Navarro", "Jimenez");

		// Impresion de resultados

		log.info("\n");

		log.info("Todos los clientes: \n {} \n", customers);

		log.info("Cliente con id 2: {} \n", customerById);

		log.info("Cliente Antonio Navarro Jimenez: {}", customerByName);

		List<Customer> customerList = new ArrayList<>();

		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		customerList.add(customer4);

		// Crea un JSON
		createJSON(customerList);

		// Cierre de sesión.
		session.close();
	}

	/**
	 * Crea un json con los clientes
	 * @param customerList
	 */
	private static void createJSON(List<Customer> customerList) {
		
		//Crea un objeto json y crea un array de clientes
		JSONObject jsonObject = new JSONObject();
		JSONArray array = new JSONArray(customerList);
		jsonObject.put("Customers", array);
		
		//Crea el archivo
		final String root = "C:\\dev\\json\\json_array_output.json";
		File file = new File(root);
		file.getParentFile().mkdirs();

		try (FileWriter writer = new FileWriter(file)) {

			writer.write(jsonObject.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
