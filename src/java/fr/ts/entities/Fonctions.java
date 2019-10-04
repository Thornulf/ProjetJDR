/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.entities;

import fr.ts.dao.NiveauxDAO;
import fr.ts.entities.classes.*;
import fr.ts.dao.PersonnageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thomas
 */
public class Fonctions {

    /**
     * Supprime les accents d'une chaine de caractères
     *
     * @param source
     * @return
     */
    public static String removeAccent(String source) {
        return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
    }

    /**
     * Initialise un personnage en fonction de sa classe
     *
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
                Barbare barbare = new Barbare(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, barbare);
                break;
            case "2": // Barde
                Barde barde = new Barde(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, barde);
                break;
            case "3": // Druide
                Druide druide = new Druide(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, druide);
                break;
            case "4": // Ensorceleur
                Ensorceleur ensorceleur = new Ensorceleur(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, ensorceleur);
                break;
            case "5": // Guerrier
                Guerrier guerrier = new Guerrier(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, guerrier);
                break;
            case "6": // Magicien
                Magicien magicien = new Magicien(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, magicien);
                break;
            case "7": // Moine
                Moine moine = new Moine(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, moine);
                break;
            case "8": // Paladin
                Paladin paladin = new Paladin(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, paladin);
                break;
            case "9": // Prêtre
                Pretre pretre = new Pretre(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, pretre);
                break;
            case "10": // Rôdeur
                Rodeur rodeur = new Rodeur(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, rodeur);
                break;
            case "11": // Roublard
                Roublard roublard = new Roublard(nom, prenom, vie, FOR, DEX, INT, CON, SAG, CHA, 0, user.getIdUtilisateur(), Integer.parseInt(idClasse), 1);
                ok = PersonnageDAO.insertInto(cn, roublard);
                break;
        }

        return ok;
    }

    public static int updatePerso(Connection cn, Personnage perso, int vie, int FOR, int DEX, int CON, int INT, int SAG, int CHA) {
        int ok = 0;

        switch (perso.getIdClasse()) {
            case 1: // Barbare
                Barbare barbare = new Barbare(perso.getIdPersonnage(), perso.getNom(), perso.getPrenom(), perso.getVie(), perso.getForce(), perso.getDexterite(), perso.getIntelligence(), perso.getConstitution(),
                                               perso.getSagesse(), perso.getCharisme(), perso.getExperience(), perso.getIdUtilisateur(), perso.getIdClasse(), perso.getNiveaux());

                barbare.setNiveaux(gagnerNiveau(cn, perso));
                barbare.gagnerVie(vie);
                barbare.setForce(FOR);
                barbare.setDexterite(DEX);
                barbare.setConstitution(CON);
                barbare.setIntelligence(INT);
                barbare.setCharisme(CHA);
                barbare.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, barbare);
                break;
            case 2: // Barde
                Barde barde = (Barde) perso;

                barde.setNiveaux(perso.gagnerNiveau());
                barde.gagnerVie(vie);
                barde.setForce(FOR);
                barde.setDexterite(DEX);
                barde.setConstitution(CON);
                barde.setIntelligence(INT);
                barde.setCharisme(CHA);
                barde.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, barde);
                break;
            case 3: // Druide
                Druide druide = (Druide) perso;

                druide.setNiveaux(perso.gagnerNiveau());
                druide.gagnerVie(vie);
                druide.setForce(FOR);
                druide.setDexterite(DEX);
                druide.setConstitution(CON);
                druide.setIntelligence(INT);
                druide.setCharisme(CHA);
                druide.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, druide);
                break;
            case 4: // Ensorceleur
                Ensorceleur ensorceleur = (Ensorceleur) perso;

                ensorceleur.setNiveaux(perso.gagnerNiveau());
                ensorceleur.gagnerVie(vie);
                ensorceleur.setForce(FOR);
                ensorceleur.setDexterite(DEX);
                ensorceleur.setConstitution(CON);
                ensorceleur.setIntelligence(INT);
                ensorceleur.setCharisme(CHA);
                ensorceleur.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, ensorceleur);
                break;
            case 5: // Guerrier
                Guerrier guerrier = (Guerrier) perso;

                guerrier.setNiveaux(perso.gagnerNiveau());
                guerrier.gagnerVie(vie);
                guerrier.setForce(FOR);
                guerrier.setDexterite(DEX);
                guerrier.setConstitution(CON);
                guerrier.setIntelligence(INT);
                guerrier.setCharisme(CHA);
                guerrier.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, guerrier);
                break;
            case 6: // Magicien
                Magicien magicien = (Magicien) perso;

                magicien.setNiveaux(perso.gagnerNiveau());
                magicien.gagnerVie(vie);
                magicien.setForce(FOR);
                magicien.setDexterite(DEX);
                magicien.setConstitution(CON);
                magicien.setIntelligence(INT);
                magicien.setCharisme(CHA);
                magicien.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, magicien);
                break;
            case 7: // Moine
                Moine moine = (Moine) perso;

                moine.setNiveaux(perso.gagnerNiveau());
                moine.gagnerVie(vie);
                moine.setForce(FOR);
                moine.setDexterite(DEX);
                moine.setConstitution(CON);
                moine.setIntelligence(INT);
                moine.setCharisme(CHA);
                moine.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, moine);
                break;
            case 8: // Paladin
                Paladin paladin = (Paladin) perso;

                paladin.setNiveaux(perso.gagnerNiveau());
                paladin.gagnerVie(vie);
                paladin.setForce(FOR);
                paladin.setDexterite(DEX);
                paladin.setConstitution(CON);
                paladin.setIntelligence(INT);
                paladin.setCharisme(CHA);
                paladin.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, paladin);
                break;
            case 9: // Prêtre
                Pretre pretre = (Pretre) perso;

                pretre.setNiveaux(perso.gagnerNiveau());
                pretre.gagnerVie(vie);
                pretre.setForce(FOR);
                pretre.setDexterite(DEX);
                pretre.setConstitution(CON);
                pretre.setIntelligence(INT);
                pretre.setCharisme(CHA);
                pretre.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, pretre);
                break;
            case 10: // Rôdeur
                Rodeur rodeur = (Rodeur) perso;

                rodeur.setNiveaux(perso.gagnerNiveau());
                rodeur.gagnerVie(vie);
                rodeur.setForce(FOR);
                rodeur.setDexterite(DEX);
                rodeur.setConstitution(CON);
                rodeur.setIntelligence(INT);
                rodeur.setCharisme(CHA);
                rodeur.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, rodeur);
                break;
            case 11: // Roublard
                Roublard roublard = (Roublard) perso;

                roublard.setNiveaux(perso.gagnerNiveau());
                roublard.gagnerVie(vie);
                roublard.setForce(FOR);
                roublard.setDexterite(DEX);
                roublard.setConstitution(CON);
                roublard.setIntelligence(INT);
                roublard.setCharisme(CHA);
                roublard.setSagesse(SAG);

                ok = PersonnageDAO.update(cn, roublard);
                break;
        }

        return ok;
    }

    /**
     * Test pour savoir si le personnage a gagner un niveau
     *
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

            if (rs.next()) {
                int nivSup = rs.getInt(1);

                if (perso.getExperience() >= nivSup) {
                    test = true;
                }
            }

            rs.close();
            lpst.close();

        } catch (SQLException e) {

        }

        return test;
    }
    
    public static int gagnerNiveau(Connection cn, Personnage perso) {
           
        int newNiveau = perso.getNiveaux();
        
        try {
            List<Niveaux> niveau = NiveauxDAO.selectAll(cn);
            
            int i;
            Niveaux get;
            
            for (i = newNiveau; i < niveau.size(); i++) {
                get = niveau.get(i-1);                
                if(newNiveau == get.getNiveau() && perso.getExperience() >= get.getNivSup()) {
                    newNiveau++;                    
                }
                if(newNiveau < get.getNiveau()) {
                    break;
                }
            }
            
            get = niveau.get(i);
            if(perso.getExperience() < get.getNivSup()) {
                newNiveau--;
            }
            
        } catch (Exception e) {
        }
        
        return newNiveau;
    }

}
