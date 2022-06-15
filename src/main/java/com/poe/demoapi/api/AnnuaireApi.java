package com.poe.demoapi.api;

import com.poe.demoapi.business.Personne;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/personnes")
public class AnnuaireApi {
    
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public ArrayList<Personne> getPersonnes() {
        ArrayList<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("JC", "Dominguez"));
        return personnes;
    }
}
