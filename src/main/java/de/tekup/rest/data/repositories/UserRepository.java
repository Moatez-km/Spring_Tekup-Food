package de.tekup.rest.data.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tekup.rest.data.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	
	@Query(value = "select * from User u where u.nom like %:keyword% or u.prenom like %:keyword%",nativeQuery = true)
	List<User> findByKeyword(@Param("keyword") String keyword);
	
	User findUserByEmailAndPassword(String email,String password);

}
