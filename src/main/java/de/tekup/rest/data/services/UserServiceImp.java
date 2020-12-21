package de.tekup.rest.data.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.rest.data.models.User;
import de.tekup.rest.data.repositories.UserRepository;
@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository UserRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return UserRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.UserRepository.save(user);
		
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> optional=UserRepository.findById(id);
		User user =null;
		if(optional.isPresent()) {
			user=optional.get();
			
			
		}else {
			throw new RuntimeException("User not found for id ::"+id);
		}
		
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		this.UserRepository.deleteById(id);
		
	}

	public List<User> findByKeyword(String keyword){
		return UserRepository.findByKeyword(keyword);
		
		
		
		
	}
	

}