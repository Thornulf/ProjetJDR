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
public final class Magicien extends Personnage {
    
    private static int magicienPvMax = 6;

    public Magicien() {
        super();
    }

    public Magicien(String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public Magicien(int idPersonnage, String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(idPersonnage, nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public int getMagicienPvMax() {
        return magicienPvMax;
    }

    public int setMagicienPvMax(int magicienPvMax) {
        return this.magicienPvMax = magicienPvMax;
    }

    @Override
    public int setVie(int vie) {
        if (vie > this.getMagicienPvMax()) {
            this.vie = this.getMagicienPvMax();
        } else {
            this.vie = vie;
        }
        return this.vie;
    }
   
    public int gagnerVie(int vie) {
        this.setMagicienPvMax(this.getMagicienPvMax() + 2);
        return this.setVie(vie);        
    }
}
