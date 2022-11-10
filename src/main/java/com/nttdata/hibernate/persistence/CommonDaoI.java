package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Dao generico
 * 
 * @author jose
 *
 * @param <T>
 */
public interface CommonDaoI<T> {

	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);

	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);

	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public T searchById(final Long id);

	/**
	 * Busqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */

	public List<T> searchAll();

	/**
	 * Busca por nombre y apellidos
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return List<Customer>
	 */
	List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname);

}
