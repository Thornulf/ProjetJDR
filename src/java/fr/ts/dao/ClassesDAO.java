/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.dao;

import fr.ts.entities.Classes;
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
public class ClassesDAO {
    
    /**
     * Permet d'avoir tous les classes de la BD
     * @param cn
     * @return 
     */
    public static List<Classes> selectAll(Connection cn) {
        List<Classes> out = new ArrayList();
        
        try {
            String lsSQL = "SELECT * FROM classes";
            Statement stmt = cn.createStatement();
            ResultSet lrs = stmt.executeQuery(lsSQL);          
                        
            while(lrs.next()) {
                Classes list = new Classes();
                list.setIdClasse(lrs.getInt(1));
                list.setNomClasse(lrs.getString(2));
                out.add(list);
            }
            
            lrs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return out;
    }
    
    /**
     * Selectionne une classe en fonction de son id
     * @param cn
     * @param id
     * @return 
     */
    public static Classes selectOne(Connection cn, int id) {
        Classes classe = null;
        
        try {
            String lsSQL = "SELECT * FROM classes WHERE id_classe = ?";
            PreparedStatement lpst = cn.prepareStatement(lsSQL);
            lpst.setInt(1, id);
            ResultSet lrs = lpst.executeQuery();
            
            if(lrs.next()) {
                classe = new Classes(lrs.getInt(1), lrs.getString(2));
            }
            
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return classe;
    }
    
    /**
     * permet de créer une nouvelle classe
     * @param cn
     * @param nomClasse
     * @return 
     */
    public static int insert(Connection cn, String nomClasse) {
        int liAffect = 0;
        
        try {
            String lsSQL = "INSERT INTO classes('nom_classe') VALUES (?)";
            PreparedStatement lpst = cn.prepareStatement(lsSQL);
            lpst.setString(1, nomClasse);
            liAffect = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return liAffect;
    }
    
}
