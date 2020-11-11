package de.tekup.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rest.data.models.UtilisateursEntity;

public interface UtilisateursRepository extends JpaRepository<UtilisateursEntity, Long> {

}
