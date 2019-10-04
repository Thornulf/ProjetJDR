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
public final class Barbare extends Personnage {

    private int barbarePvMax = 12;

    public Barbare() {
        super();
    }

    public Barbare(String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public Barbare(int idPersonnage, String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        super(idPersonnage, nom, prenom, vie, force, dexterite, intelligence, constitution, sagesse, charisme, experience, idUtilisateur, idClasse, niveaux);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
    }

    public int getBarbarePvMax() {
        return barbarePvMax;
    }

    public int setBarbarePvMax(int barbarePvMax) {
        return this.barbarePvMax = barbarePvMax;
    }

    @Override
    public int setVie(int vie) {
        if (vie > this.getBarbarePvMax()) {
            this.vie = this.getBarbarePvMax();
        } else {
            this.vie = vie;
            this.setBarbarePvMax(vie);
        }
        return this.vie;
    }

    public int gagnerVie(int vie) {
        this.setBarbarePvMax(this.getBarbarePvMax() + 2);
        return this.setVie(vie);
    }
}
