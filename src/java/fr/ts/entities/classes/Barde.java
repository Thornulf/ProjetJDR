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
public final class Barde extends Personnage{
    
    private static int bardePvMAX = 8;

    public Barde() {
        super();
    }

    public Barde(String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    } 

    public Barde(int idPersonnage, String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(idPersonnage, nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public int getBardePvMAX() {
        return bardePvMAX;
    }

    public int setBardePvMAX(int bardePvMAX) {
        return this.bardePvMAX = bardePvMAX;
    }
    
    @Override
    public int setVie(int vie) {
        if(vie > this.getBardePvMAX()) {
            this.vie = this.getBardePvMAX();
        } else {
           this.vie = vie; 
           this.setBardePvMAX(vie);
        }
        
        return this.vie;
    }
    
    public int gagnerVie(int vie) {
        this.setBardePvMAX(this.getBardePvMAX() + 2);
        return this.setVie(vie);        
    }
          
}
