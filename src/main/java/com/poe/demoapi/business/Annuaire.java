package com.poe.demoapi.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Annuaire {

    private ArrayList<Personne> personnes = new ArrayList<>();
    private long nextId = 1;

    public Personne addPersonne(Personne newPersonne) {
        newPersonne.setId(nextId);
        nextId++;
        personnes.add(newPersonne);
        return newPersonne;
    }

    public ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public Optional<Personne> getPersonne(long id) {
        for (Personne p : personnes) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public void updatePersonne(Personne personne) {

        Iterator<Personne> it = personnes.iterator();
        while (it.hasNext()) {
            Personne p = it.next();
            if (p.getId().equals(personne.getId())) {
                personnes.remove(p);
                personnes.add(personne);
                break;
            }
        }
    }

    public void deletePersonne(long id) {
        Iterator<Personne> it = personnes.iterator();
        while (it.hasNext()) {
            Personne p = it.next();
            if (p.getId().equals(id)) {
                personnes.remove(p);
                break;
            }
        }
    }

    public void setPersonnes(ArrayList<Personne> personnes) {
        this.personnes = personnes;
    }

    public long getNextId() {
        return nextId;
    }

    public void setNextId(long nextId) {
        this.nextId = nextId;
    }
}
