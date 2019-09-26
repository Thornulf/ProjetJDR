/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.entities;

/**
 *
 * @author Thomas
 */
public class Caracteristiques {
    
    private int idCaracteristique;
    private int vie;
    private int force;
    private int dexterite;
    private int intelligence;
    private int constitution;
    private int sagesse;
    private int charisme;

    public Caracteristiques() {
    }

    public Caracteristiques(int idCaracteristique, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme) {
        this.idCaracteristique = idCaracteristique;
        this.vie = vie;
        this.force = force;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.sagesse = sagesse;
        this.charisme = charisme;
    }

    public int getIdCarcteristique() {
        return idCaracteristique;
    }

    public void setIdCaracteristique(int idCaracteristique) {
        this.idCaracteristique = idCaracteristique;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getSagesse() {
        return sagesse;
    }

    public void setSagesse(int sagesse) {
        this.sagesse = sagesse;
    }

    public int getCharisme() {
        return charisme;
    }

    public void setCharisme(int charisme) {
        this.charisme = charisme;
    }  
        
}
