/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.controls;

import fr.ts.entities.Utilisateurs;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thomas
 */
@WebServlet(name = "FichePerso", urlPatterns = {"/FichePerso"})
public class FichePerso extends HttpServlet {

    /**
     * Permet l'affichage de tous les personnages créés par l'utilisateur connecté
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateurs user = (Utilisateurs) session.getAttribute("utilisateur");
        Connection cn = (Connection) session.getAttribute("connection");
        
        if (user != null) {

            List<List<String>> listPerso = new ArrayList();
            
            try {
                String lsSQL = "CALL personnageSelect (?)";
                
                PreparedStatement lpst = cn.prepareStatement(lsSQL);
                lpst.setInt(1, user.getIdUtilisateur());                
                ResultSet rs = lpst.executeQuery();
                
                while(rs.next()) {
                    List<String> out = new ArrayList();
                    
                    out.add(rs.getString(1));
                    out.add(rs.getString(2));
                    out.add(rs.getString(3));
                    out.add(Integer.toString(rs.getInt(4)));
                    out.add(Integer.toString(rs.getInt(5)));
                    out.add(Integer.toString(rs.getInt(6)));
                    out.add(Integer.toString(rs.getInt(7)));
                    out.add(Integer.toString(rs.getInt(8)));
                    out.add(Integer.toString(rs.getInt(9)));
                    out.add(Integer.toString(rs.getInt(10)));
                    out.add(Integer.toString(rs.getInt(11)));
                    
                    listPerso.add(out);
                }
                
                rs.close();
                lpst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            request.setAttribute("perso", listPerso);
            getServletContext().getRequestDispatcher("/JSP/FichePerso.jsp").forward(request, response);
            
        } else {
            response.setContentType("text/html;charset=UTF-8");
            getServletContext().getRequestDispatcher("/JSP/Authentification.jsp").forward(request, response);
        }
        
    }
    
}
