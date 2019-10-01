/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.dao;

import fr.ts.entities.Personnage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class PersonnageDAO {

    public static List<Personnage> selectAll(Connection cn) {
        List<Personnage> listPersonnage = new ArrayList();

        try {
            String lsSQL = "SELECT * FROM personnages";
            Statement stmt = cn.createStatement();
            ResultSet lrs = stmt.executeQuery(lsSQL);

            while (lrs.next()) {
                Personnage perso = new Personnage();
                perso.setIdPersonnage(lrs.getInt(1));
                perso.setPrenom(lrs.getString(2));
                perso.setNom(lrs.getString(3));
                perso.setVie(lrs.getInt(4));
                perso.setForce(lrs.getInt(5));
                perso.setDexterite(lrs.getInt(6));
                perso.setIntelligence(lrs.getInt(7));
                perso.setConstitution(lrs.getInt(8));
                perso.setSagesse(lrs.getInt(9));
                perso.setCharisme(lrs.getInt(10));
                perso.setExperience(lrs.getInt(11));
                perso.setIdUtilisateur(lrs.getInt(12));
                perso.setIdClasse(lrs.getInt(13));
                perso.setNiveaux(lrs.getInt(14));
                listPersonnage.add(perso);
            }

            lrs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listPersonnage;
    }

    public static Personnage selectOne(Connection cn, String nom, String prenom) {
        Personnage perso = null;

        try {
            String lsSQL = "SELECT * FROM personnages WHERE prenom=? AND nom=?";

            PreparedStatement lpst = cn.prepareStatement(lsSQL);
            lpst.setString(1, prenom);
            lpst.setString(2, nom);
            ResultSet lrs = lpst.executeQuery();

            if (lrs.next()) {
                perso = new Personnage(
                        lrs.getString(2),
                        lrs.getString(3),
                        lrs.getInt(4),
                        lrs.getInt(5),
                        lrs.getInt(6),
                        lrs.getInt(7),
                        lrs.getInt(8),
                        lrs.getInt(9),
                        lrs.getInt(10),
                        lrs.getInt(11),
                        lrs.getInt(12),
                        lrs.getInt(13),
                        lrs.getInt(14));
            }

            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return perso;
    }

    public static int insertInto(Connection cn, Personnage perso) {
        int liAffect = 0;

        try {
            String lsSQL = "CALL personnageInsert(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement lpst = cn.prepareStatement(lsSQL);
            lpst.setString(1, perso.getPrenom());
            lpst.setString(2, perso.getNom());
            lpst.setInt(3, perso.getVie());
            lpst.setInt(4, perso.getForce());
            lpst.setInt(5, perso.getDexterite());
            lpst.setInt(6, perso.getIntelligence());
            lpst.setInt(7, perso.getConstitution());
            lpst.setInt(8, perso.getSagesse());
            lpst.setInt(9, perso.getCharisme());
            lpst.setInt(10, perso.getExperience());
            lpst.setInt(11, perso.getIdUtilisateur());
            lpst.setInt(12, perso.getIdClasse());
            lpst.setInt(13, perso.getNiveaux());
            liAffect = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            liAffect = -1;
        }

        return liAffect;
    }

    public static int update(Connection cn, Personnage perso) {
        int liAffect = -1;

        String lsSQL = "UPDATE personnages";
        lsSQL += " SET vie = ?, p_force = ?, p_dexterite = ?, p_intelligence = ?, p_constitution = ?, p_sagesse = ?, p_charisme = ?, experience = ?, niveau = ?";
        lsSQL += " WHERE prenom = ? AND nom = ?";
        
        try (PreparedStatement lpst = cn.prepareStatement(lsSQL)) {
            
            lpst.setInt(1, perso.getVie());
            lpst.setInt(2, perso.getForce());
            lpst.setInt(3, perso.getDexterite());
            lpst.setInt(4, perso.getIntelligence());
            lpst.setInt(5, perso.getConstitution());
            lpst.setInt(6, perso.getSagesse());
            lpst.setInt(7, perso.getCharisme());
            lpst.setInt(8, perso.getExperience());
            lpst.setInt(9, perso.getNiveaux());
            lpst.setString(10, perso.getNom());
            lpst.setString(11, perso.getPrenom());

            liAffect = lpst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liAffect;
    }

    public static int delete(Connection cn, Personnage perso) {
        int liAffect = 0;

        try {
            String lsSQL = "DELTE FROM personnages WHERE nom = ? AND prenom = ?";
            PreparedStatement lpst = cn.prepareCall(lsSQL);
            lpst.setString(1, perso.getNom());
            lpst.setString(2, perso.getPrenom());
            liAffect = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liAffect;
    }
}
