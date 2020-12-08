package de.tekup.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rest.data.models.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
