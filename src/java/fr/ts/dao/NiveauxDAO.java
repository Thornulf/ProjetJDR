/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.dao;

import fr.ts.entities.Niveaux;
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
public class NiveauxDAO {
    
    public static List<Niveaux> selectAll(Connection cn) {
        List<Niveaux> niveau = new ArrayList();
        
        try {
            String lsSQL = "SELECT * FROM niveaux";
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(lsSQL);
            
            while(rs.next()) {                
                Niveaux lvl = new Niveaux(rs.getInt(1), rs.getInt(2));
                niveau.add(lvl);
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
        }
        
        return niveau;
    }
    
    /**
     * Selectionne un niveau dans la BD
     * @param cn
     * @param lvl
     * @return 
     */
    public static Niveaux selectOne(Connection cn, int lvl) {
        Niveaux niveau = null;
        
        try {
            String lsSQL = "SELECT * FROM niveaux WHERE niveau = ?";
            PreparedStatement lpst = cn.prepareStatement(lsSQL);
            lpst.setInt(1, lvl);
            ResultSet lrs = lpst.executeQuery();
            
            if(lrs.next()) {
                niveau = new Niveaux(lrs.getInt(1), lrs.getInt(2));
            }
            
            lrs.close();
            lpst.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return niveau;
    }
    
}
