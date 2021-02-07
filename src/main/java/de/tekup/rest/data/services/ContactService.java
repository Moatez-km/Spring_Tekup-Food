package de.tekup.rest.data.services;


import java.util.List;

import de.tekup.rest.data.models.Contact;

public interface ContactService {
	void saveContactToDB(String email,String message,String date);
	Contact getEntityById(long id);
	List<Contact>getAllContact();

}
