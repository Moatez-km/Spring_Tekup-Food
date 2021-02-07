package de.tekup.rest.data.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.rest.data.models.Contact;

import de.tekup.rest.data.repositories.ContactRepository;
@Service
public class ContactServiceImpl  implements ContactService{
	@Autowired
	ContactRepository contactRepo;

	@Override
	public void saveContactToDB(String email, String message,String date) {
		// TODO Auto-generated method stub
		Contact c=new Contact();
		c.setEmail(email);
		c.setMessage(message);
		c.setDate(date);
		contactRepo.save(c);
		
		
	}

	@Override
	public Contact getEntityById(long id) {
		// TODO Auto-generated method stub
		Optional<Contact> opt=contactRepo.findById(id);
		Contact entity;
		if(opt.isPresent()) 
			entity=opt.get();
		else
			throw new NoSuchElementException("Contact with this Id is not found");
		
		return entity;
	}

	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return contactRepo.findAll();
	}

}
