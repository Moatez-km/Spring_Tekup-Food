package de.tekup.rest.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rest.data.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
