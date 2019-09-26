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

/**
 *
 * @author Thomas
 */
public class NiveauxDAO {
    
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
