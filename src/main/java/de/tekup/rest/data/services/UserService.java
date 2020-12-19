package de.tekup.rest.data.services;

import java.util.List;

import de.tekup.rest.data.models.User;



public interface UserService {
	List<User> getAllUsers();
	void saveUser(User user);
	User getUserById(Long id);
	void deleteUserById(Long id);

}
