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
public class Personnage{
    
    //Déclaration des attributs privés
    
    protected int idPersonnage;
    protected String nom;
    protected String prenom;
    protected int vie;
    protected int force;
    protected int dexterite;
    protected int intelligence;
    protected int constitution;
    protected int sagesse;
    protected int charisme;
    protected int experience;
    protected int idUtilisateur;
    protected int idClasse;
    protected int niveaux;

    public Personnage() {
    }

    public Personnage(String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        this.nom = this.setNom(nom);
        this.prenom = this.setPrenom(prenom);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
        this.experience = this.setExperience(experience);
        this.idUtilisateur = this.setIdUtilisateur(idUtilisateur);
        this.idClasse = this.setIdClasse(idClasse);
        this.niveaux = this.setNiveaux(niveaux);
    }
    
    public Personnage(int idPersonnage, String nom, String prenom, int vie, int force, int dexterite, int intelligence, int constitution, int sagesse, int charisme, int experience, int idUtilisateur, int idClasse, int niveaux) {
        this.idPersonnage = this.setIdPersonnage(idPersonnage);
        this.nom = this.setNom(nom);
        this.prenom = this.setPrenom(prenom);
        this.vie = this.setVie(vie);
        this.force = this.setForce(force);
        this.dexterite = this.setDexterite(dexterite);
        this.intelligence = this.setIntelligence(intelligence);
        this.constitution = this.setConstitution(constitution);
        this.sagesse = this.setSagesse(sagesse);
        this.charisme = this.setCharisme(charisme);
        this.experience = this.setExperience(experience);
        this.idUtilisateur = this.setIdUtilisateur(idUtilisateur);
        this.idClasse = this.setIdClasse(idClasse);
        this.niveaux = this.setNiveaux(niveaux);
    }
    
    //Function Getter et Setter
    
    public int getIdPersonnage() {
        return idPersonnage;
    }

    public int setIdPersonnage(int idPersonnage) {
         return this.idPersonnage = idPersonnage;
    }

    public String getNom() {
        return nom;
    }

    public String setNom(String nom) {
        return this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String setPrenom(String prenom) {
        return this.prenom = prenom;
    }

    public int getVie() {
        return vie;
    }

    public int setVie(int vie) {
        return this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public int setForce(int force) {
        return this.force = force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public int setDexterite(int dexterite) {
        return this.dexterite = dexterite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int setIntelligence(int intelligence) {
        return this.intelligence = intelligence;
    }

    public int getConstitution() {
        return constitution;
    }

    public int setConstitution(int constitution) {
        return this.constitution = constitution;
    }

    public int getSagesse() {
        return sagesse;
    }

    public int setSagesse(int sagesse) {
        return this.sagesse = sagesse;
    }

    public int getCharisme() {
        return charisme;
    }

    public int setCharisme(int charisme) {
        return this.charisme = charisme;
    }

    public int getExperience() {
        return experience;
    }

    public int setExperience(int experience) {
         return this.experience = experience;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int setIdUtilisateur(int idUtilisateur) {
        return this.idUtilisateur = idUtilisateur;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public int setIdClasse(int idClasse) {
        return this.idClasse = idClasse;
    }

    public int getNiveaux() {
        return niveaux;
    }

    public int setNiveaux(int niveaux) {
        return this.niveaux = niveaux;
    }
    
    // Function
    public int gagnerExperience(int experience) {
        return this.getExperience() + experience;
    }
    
    public int gagnerNiveau() {
        return this.getNiveaux() + 1;
    }
    
}
