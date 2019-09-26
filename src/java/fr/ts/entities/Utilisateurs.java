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
public class Utilisateurs {
    private int idUtilisateur;
    private String pseudo;
    private String password;
    private String eMail;
    private int idRole;

    public Utilisateurs() {
    }    
    
    public Utilisateurs(int idUtilisateur, String pseudo, String password, String eMail, int idRole) {
        this.idUtilisateur = idUtilisateur;
        this.pseudo = pseudo;
        this.password = password;
        this.eMail = eMail;
        this.idRole = idRole;
    }    

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }  
        
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
