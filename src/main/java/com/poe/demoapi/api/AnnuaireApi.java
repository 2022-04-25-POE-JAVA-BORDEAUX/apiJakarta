package com.poe.demoapi.api;

import com.poe.demoapi.business.Annuaire;
import com.poe.demoapi.business.Personne;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/personnes")
public class AnnuaireApi {
    
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public ArrayList<Personne> getPersonnes(@Context HttpServletRequest request) {
        
        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        if(annuaire == null) {
            annuaire = new Annuaire();       
        }
        return annuaire.getPersonnes();
    }
    
    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Personne postPersonne(Personne newPersonne, @Context HttpServletRequest request) {
        
        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        if(annuaire == null) {
            annuaire = new Annuaire();       
        }
        Personne personne = annuaire.addPersonne(newPersonne);
        request.getSession().setAttribute("annuaire", annuaire);
        return personne;
    }
    
    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Personne getPersonne(@PathParam("id") long personneId, @Context HttpServletRequest request) {
        
        Annuaire annuaire = (Annuaire)request.getSession().getAttribute("annuaire");
        if(annuaire == null) {
            annuaire = new Annuaire();       
        }
        Optional<Personne> op = annuaire.getPersonne(personneId);
        if(op.isPresent()){
            return op.get();
        }
        
        // TODO : à améliorer ?
        return new Personne();
    }
}
