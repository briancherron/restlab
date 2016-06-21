package com.di.restlab;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Represents a contact.
 */
public class Contact {

	/**
	 * The contact id.
	 */
	private String id;
	
	/**
	 * The contact name.
	 */
	private String name;
	
	/**
	 * The contact phone number.
	 */
	private String phone;
	
	/**
	 * The contact email address.
	 */
	private String email;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}
}
