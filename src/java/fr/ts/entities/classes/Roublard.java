/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.entities.classes;

import fr.ts.entities.Personnage;

/**
 *
 * @author Thomas
 */
public final class Roublard extends Personnage{
    
    private static int roublardPvMax = 8;

    public Roublard() {
        super();
    }

    public Roublard(String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public Roublard(int idPersonnage, String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(idPersonnage, nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public int getRoublardPvMax() {
        return roublardPvMax;
    }

    public static void setRoublardPvMax(int roublardPvMax) {
        Roublard.roublardPvMax = roublardPvMax;
    }
    
    @Override
    public int setVie(int vie) {
        if(vie > this.getRoublardPvMax()){
            this.vie = this.getRoublardPvMax();
        } else {
            this.vie = vie;            
        }
        return this.vie;
    }

    @Override
    public int setNiveaux(int niveaux) {
        this.niveaux = niveaux;
        
        return this.niveaux;
    }
    
    public int gagnerVie(int vie) {
        this.setRoublardPvMax(this.getRoublardPvMax() + 2);
        return this.setVie(vie);        
    }
    
}
