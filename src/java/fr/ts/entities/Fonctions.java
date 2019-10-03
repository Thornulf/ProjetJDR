/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.entities;

import fr.ts.entities.classes.Roublard;
import fr.ts.entities.classes.Paladin;
import fr.ts.entities.classes.Barbare;
import fr.ts.entities.classes.Pretre;
import fr.ts.entities.classes.Rodeur;
import fr.ts.entities.classes.Druide;
import fr.ts.entities.classes.Barde;
import fr.ts.entities.classes.Moine;
import fr.ts.entities.classes.Guerrier;
import fr.ts.entities.classes.Magicien;
import fr.ts.entities.classes.Ensorceleur;
import fr.ts.dao.PersonnageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;

/**
 *
 * @author Thomas
 */
public class Fonctions {

    /**
     * Supprime les accents d'une chaine de caractères
     * @param source
     * @return 
     */
    public static String removeAccent(String source) {
        return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
    }

    /**
     * Initialise un personnage en fonction de sa classe
     * @param cn
     * @param idClasse
     * @param nom
     * @param prenom
     * @param vie
     * @param FOR
     * @param DEX
     * @param CON
     * @param INT
     * @param SAG
     * @param CHA
     * @param user
     * @return 
     */
    public static int initPerso(Connection cn, String idClasse, String nom, String prenom, int vie, int FOR, int DEX, int CON, int INT, int SAG, int CHA, Utilisateurs user) {
        int ok = 0;

        switch (idClasse) {
            case "1": // Barbare
                Barbare barbare = new Barbare(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, barbare);
                break;
            case "2": // Barde
                Barde barde = new Barde(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, barde);
                break;
            case "3": // Druide
                Druide druide = new Druide(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, druide);
                break;
            case "4": // Ensorceleur
                Ensorceleur ensorceleur = new Ensorceleur(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, ensorceleur);
                break;
            case "5": // Guerrier
                Guerrier guerrier = new Guerrier(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, guerrier);
                break;
            case "6": // Magicien
                Magicien magicien = new Magicien(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, magicien);
                break;
            case "7": // Moine
                Moine moine = new Moine(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, moine);
                break;
            case "8": // Paladin
                Paladin paladin = new Paladin(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, paladin);
                break;
            case "9": // Prêtre
                Pretre pretre = new Pretre(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, pretre);
                break;
            case "10": // Rôdeur
                Rodeur rodeur = new Rodeur(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, rodeur);
                break;
            case "11": // Roublard
                Roublard roublard = new Roublard(nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, roublard);
                break;
        }

        return ok;
    }
    
    /**
     * Test pour savoir si le personnage a gagner un niveau 
     * @param perso
     * @param cn
     * @return 
     */
    public static boolean okGagnerNiveau(Personnage perso, Connection cn) {
        boolean test = false;       
        
        try {
            String lsSql = "SELECT niv_sup FROM niveaux WHERE niveau = ?";
            PreparedStatement lpst = cn.prepareStatement(lsSql);
            lpst.setInt(1, perso.getNiveaux());
            ResultSet rs = lpst.executeQuery();
            
            if(rs.next()) {
                int nivSup = rs.getInt(1);
                
                if(perso.getExperience() >= nivSup) {
                    test = true;
                }
            }
            
            rs.close();
            lpst.close();
            
        } catch (SQLException e) {
            
        }
        
        return test;
    } 

}
