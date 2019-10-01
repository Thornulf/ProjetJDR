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
    
    private static int BARDE_PV_MAX = 8;

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

    @Override
    public int setVie(int vie) {
        if(vie > BARDE_PV_MAX) {
            this.vie = BARDE_PV_MAX;
        } else {
           this.vie = vie; 
        }
        
        return this.vie;
    }

    @Override
    public int setDexterite(int dexterite) {
        this.dexterite = dexterite;
        
        return this.dexterite;
    } 
          
}
