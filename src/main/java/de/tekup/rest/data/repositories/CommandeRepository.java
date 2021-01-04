package de.tekup.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rest.data.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
