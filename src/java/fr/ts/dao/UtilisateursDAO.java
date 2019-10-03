/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.dao;

import fr.ts.entities.Utilisateurs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thomas
 */
public class UtilisateursDAO {
    
    /**
     * Selectionne un urilisateurs en fonction de son mot de passe et son pseudo utilisé pour l'authentification
     * @param pcnx
     * @param pseudo
     * @param mdp
     * @return 
     */
    public static Utilisateurs selectOne(Connection pcnx, String pseudo, String mdp) {
        Utilisateurs utilisateur = null;
        try {
            String lsSQL = "SELECT * FROM utilisateurs WHERE pseudo=? AND mdp=?";
            PreparedStatement lpst = pcnx.prepareStatement(lsSQL);
            lpst.setString(1, pseudo);
            lpst.setString(2, mdp);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                utilisateur = new Utilisateurs(lrs.getInt(1), lrs.getString(2), lrs.getString(3), lrs.getString(4), lrs.getInt(5));
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return utilisateur;
    }
    
    /**
     * Selection un utilisateur par son pseudo
     * @param pcnx
     * @param pseudo
     * @return 
     */
    public static Utilisateurs selectOneBy(Connection pcnx, String pseudo) {
        Utilisateurs utilisateur = null;
        try {
            String lsSQL = "SELECT * FROM utilisateurs WHERE pseudo=?";
            PreparedStatement lpst = pcnx.prepareStatement(lsSQL);
            lpst.setString(1, pseudo);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                utilisateur = new Utilisateurs(lrs.getInt(1), lrs.getString(2), lrs.getString(3), lrs.getString(4), lrs.getInt(5));
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return utilisateur;
    } /// selectOne

    /**
     * Enregistre un utilisateur dans la base de données
     * @param pcnx
     * @param utilisateur
     * @return
     */
    public static int insert(Connection pcnx, Utilisateurs utilisateur) {
        int liAffecte = 0;
        try {
            String lsSQL = "INSERT INTO utilisateurs(pseudo, mdp, e_mail, id_role) VALUES(?,?,?,?)";
            PreparedStatement lpst = pcnx.prepareStatement(lsSQL);
            lpst.setString(1, utilisateur.getPseudo());
            lpst.setString(2, utilisateur.getPassword());
            lpst.setString(3, utilisateur.geteMail());
            lpst.setInt(4, utilisateur.getIdRole());
            liAffecte = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
            liAffecte = -1;
        }
        return liAffecte;
    } /// insert

    /**
     * Supprime un utilisateur de la base de données
     * @param pcnx
     * @param utilisateur
     * @return
     */
    public static int delete(Connection pcnx, Utilisateurs utilisateur) {
        int liAffecte = 0;

        try {
            String lsSQL = "DELETE FROM utilisateurs WHERE email=? AND mdp=?";
            PreparedStatement lpst = pcnx.prepareStatement(lsSQL);
            lpst.setString(1, utilisateur.geteMail());
            lpst.setString(2, utilisateur.getPassword());
            liAffecte = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }
}
