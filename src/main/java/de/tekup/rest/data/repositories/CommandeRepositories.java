package de.tekup.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rest.data.models.Commande;

public interface CommandeRepositories extends JpaRepository<Commande, Integer> {

}
