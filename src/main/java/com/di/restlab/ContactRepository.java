package com.di.restlab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents the repository of contacts.
 * 
 * @author Brian Herron
 */
public class ContactRepository {

	/**
	 * A map of contacts, stored by id.
	 */
	private static final Map<String, Contact> CONTACTS = new TreeMap<String, Contact>();
	
	/**
	 * A static initialization block to pre-load some contacts.
	 */
	static {
		Contact bob = new Contact();
		bob.setId("1");
		bob.setName("Bob Weir");
		bob.setPhone("555-123-4567");
		bob.setEmail("bob.weir@restlab.com");
		CONTACTS.put(bob.getId(), bob);
		
		Contact mike = new Contact();
		mike.setId("2");
		mike.setName("Mike Gordon");
		mike.setPhone("555-987-6543");
		mike.setEmail("mike.gordon@restlab.com");
		CONTACTS.put(mike.getId(), mike);
		
		Contact lucinda = new Contact();
		lucinda.setId("3");
		lucinda.setName("Lucinda Williams");
		lucinda.setPhone("555-963-8527");
		lucinda.setEmail("lucinda.williams@restlab.com");
		CONTACTS.put(lucinda.getId(), lucinda);
	}
	
	/**
	 * Finds all contacts.
	 * 
	 * @return all contacts
	 */
	public List<Contact> findAll() {
		return new ArrayList<Contact>(CONTACTS.values());
	}
	
	/**
	 * Finds a contact by id.
	 * 
	 * @param id the contact id
	 * @return the contact, or null if no contact is found
	 */
	public Contact findById(String id) {
		return CONTACTS.get(id);
	}
	
	/**
	 * Creates a contact.
	 * 
	 * @param contact the contact to create
	 * @return the created contact, complete with an id
	 */
	public Contact create(Contact contact) {
		contact.setId(String.valueOf(Integer.parseInt(Collections.max(CONTACTS.keySet())) + 1));
		CONTACTS.put(contact.getId(), contact);
		
		return contact;
	}
	
	/**
	 * Updates a contact.
	 * 
	 * @param contact the contact to update
	 * @return <code>true</code> if the contact was found and updated
	 */
	public boolean update(String id, Contact contact) {
		contact.setId(id);
		if (CONTACTS.get(contact.getId()) == null) {
			return false;
		}
		
		CONTACTS.put(contact.getId(), contact);
		return true;
	}
	
	/**
	 * Deletes a contact.
	 * 
	 * @param id the contact id
	 * @return <code>true</code> if the contact was found and deleted
	 */
	public boolean delete(String id) {
		return CONTACTS.remove(id) != null;
	}
}
