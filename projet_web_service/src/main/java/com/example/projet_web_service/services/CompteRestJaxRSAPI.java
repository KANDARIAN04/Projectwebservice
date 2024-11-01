package com.example.projet_web_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.projet_web_service.entities.Compte;
import com.example.projet_web_service.repository.CompteRepository;

import jakarta.ws.rs.PathParam;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
@Autowired
private CompteRepository compteRepository;
   
     @Path("/comptes")
     @GET
     @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
      public List<Compte> getComptes(){
	     return compteRepository.findAll();
	}
	// READ: Récupérer un compte par son identifiant
	@Path("/comptes/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Compte getCompte(@PathParam("id") Long id) {
	    return compteRepository.findById(id).orElse(null);
	}

	// CREATE: Ajouter un nouveau compte
	@Path("/comptes")
	@POST
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Compte addCompte(Compte compte) {

	    return compteRepository.save(compte);
	}

	// UPDATE: Mettre à jour un compte existant
	@Path("/comptes/{id}")
	@PUT
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
	    Compte existingCompte = compteRepository.findById(id).orElse(null);
	    if (existingCompte != null) {
	        existingCompte.setSolde(compte.getSolde());
	        existingCompte.setDateCreation(compte.getDateCreation());
	        existingCompte.setType(compte.getType());
	        return compteRepository.save(existingCompte);
	    }
	    return null;
	}

	// DELETE: Supprimer un compte
	@Path("/comptes/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public void deleteCompte(@PathParam("id") Long id) {
	    compteRepository.deleteById(id);
	}

}
