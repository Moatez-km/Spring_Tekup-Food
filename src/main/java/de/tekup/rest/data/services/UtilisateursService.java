package de.tekup.rest.data.services;

import java.util.List;


import de.tekup.rest.data.models.UtilisateursEntity;


public interface UtilisateursService {

	List<UtilisateursEntity>getAllEntities();
	UtilisateursEntity getEntityById(long id);
}
