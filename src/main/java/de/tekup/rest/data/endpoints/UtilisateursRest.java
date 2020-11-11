package de.tekup.rest.data.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rest.data.models.UtilisateursEntity;
import de.tekup.rest.data.services.UtilisateursService;


@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateursRest {
	
	private UtilisateursService service;
	
    @Autowired
	public UtilisateursRest(UtilisateursService service) {
		super();
		this.service = service;
	}
	@GetMapping
	public List<UtilisateursEntity> getAll(){
		return service.getAllEntities();
		
	}
	@GetMapping("/{id}")
	public UtilisateursEntity getById(@PathVariable("id")Long id) {
		return service.getEntityById(id);
		
		
		
	}
    @PostMapping
	public UtilisateursEntity createUtilisateur(@RequestBody  UtilisateursEntity utilisateur) {
		return service.createUtilisateurs(utilisateur) ;
		
		
	}
	

}
