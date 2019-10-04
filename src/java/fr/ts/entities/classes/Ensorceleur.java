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
public final class Ensorceleur extends Personnage {
    
    private static int ensorceleurPvMax = 6;

    public Ensorceleur() {
        super();
    }

    public Ensorceleur(String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public Ensorceleur(int idPersonnage, String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(idPersonnage, nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public int getEnsorceleurPvMax() {
        return ensorceleurPvMax;
    }

    public int setEnsorceleurPvMax(int ensorceleurPvMax) {
        return this.ensorceleurPvMax = ensorceleurPvMax;
    }
    
    @Override
    public int setVie(int vie) {
        if (vie > this.getEnsorceleurPvMax()) {
            this.vie = this.getEnsorceleurPvMax();
        } else {
            this.vie = vie;
        }
        return this.vie;
    }
    
    public int gagnerVie(int vie) {
        this.setEnsorceleurPvMax(this.getEnsorceleurPvMax() + 2);
        return this.setVie(vie);        
    }
}
