package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase cliente
 * 
 * @author Jose
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long customerId;

	/** Nombre */
	private String name;

	/** Primer apellido */
	private String firstSurname;

	/** Segundo apellido */
	private String secondSurname;

	/** DNI */
	private String dni;

	/**
	 * Devuelve el id del cliente
	 * @return customerId (id)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * Coloca el id del cliente
	 * @param customerId (id)
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Devuelve el nombre
	 * @return name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Coloca el nombre
	 * @param name nombre
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve el primer apellido
	 * @return firstSurname
	 */
	@Column(name = "FIRST_SURNAME", nullable = true)
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * Coloca el primer apellido
	 * @param firstSurname (primerApellido)
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * Devuelve el segundo apellido
	 * 
	 * @return secondSurname (segundoApellido)
	 */
	@Column(name = "SECOND_SURNAME", nullable = true)
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * Coloca el segundo apellido
	 * 
	 * @param secondSurname (segundoApellido)
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * Coloca el dni
	 * 
	 * @param dni (dni)
	 */
	public void setDNI(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el dni
	 * 
	 * @return dni
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	public String getDNI() {
		return dni;
	}

	@Override
	public String toString() {
		return " customerId = " + customerId + ", name = " + name + ", firstSurname = " + firstSurname
				+ ", secondSurname = " + secondSurname + ", dni = " + dni + " ";
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Customer.class;
	}
}
