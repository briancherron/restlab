package com.di.restlab;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * A RESTful service to interact with {@link Contact}.
 * 
 * @author Brian Herron
 */
@Path("/contacts")
public class ContactService {
	
	/**
	 * Handles GET requests for the path /contacts by returning all contacts.
	 * 
	 * @return all contacts
	 */
	@GET
	@Produces("application/json")
	public Response findAll() {
		return Response.status(Response.Status.OK).entity(new ContactRepository().findAll()).build();
	}

	/**
	 * Handles GET requests for the path /contacts/{contactId} by returning the matching contact. If no matching 
	 * contact is found, a 404 Not Found response is returned.
	 * 
	 * @param id the contact id
	 * @return the matching contact, or the appropriate error response
	 */
	@GET
	@Path("/{contactId}")
	@Produces("application/json")
	public Response findById(@PathParam(value = "contactId") String id) {
		Contact contact = new ContactRepository().findById(id);
		if (contact == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("No contact found for id: " + id).build();
		}
		
		return Response.status(Response.Status.OK).entity(contact).build();
	}
	
	/**
	 * Handles POST requests for the path /contacts by creating a new contact.
	 * 
	 * @return the newly created contact, including the contact id
	 */
	@POST
	@Produces("application/json")
	public Response create(Contact contact) {
		if (contact != null) {
			return Response.status(Response.Status.CREATED).entity(new ContactRepository().create(contact)).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid contact").build();
		}
	}
	
	/**
	 * Handles PUT requests for the path /contacts/{contactId} by updating the matching contact. If no matching contact 
	 * is found, a 404 Not Found response is returned.
	 * 
	 * @param id the contact id
	 * @return the updated contact, or the appropriate error response
	 */
	@PUT
	@Path("/{contactId}")
	@Produces("application/json")
	public Response update(@PathParam(value = "contactId") String id, Contact contact) {
		boolean success = new ContactRepository().update(id, contact);
		if (success) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	/**
	 * Handles DELETE requests for the path /contacts/{contactId} by updating the matching contact. If no matching 
	 * contact is found, a 404 Not Found response is returned.
	 * 
	 * @param id the contact id
	 */
	@DELETE
	@Path("/{contactId}")
	@Produces("application/json")
	public Response delete(@PathParam(value = "contactId") String id) {
		boolean success = new ContactRepository().delete(id);
		if (success) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
