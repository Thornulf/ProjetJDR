/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.controls;

import fr.ts.dao.UtilisateursDAO;
import fr.ts.entities.Utilisateurs;
import java.io.IOException;
import java.sql.Connection;
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
@WebServlet(name = "AuthentificationValidation", urlPatterns = {"/AuthentificationValidation"})
public class AuthentificationValidation extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("mdp");
        String lsMessage = "";
        
        HttpSession session = request.getSession();
        Connection lcn = (Connection) session.getAttribute("connection");

        Utilisateurs user = UtilisateursDAO.selectOne(lcn, pseudo, mdp);

        if (user == null) {
            lsMessage = "Le pseudo ou le mot de passe sont incorrect";
        } else {
            lsMessage = "Vous êtes connecté(e)";            
            session.setAttribute("utilisateur", user);
        }

        request.setAttribute("message", lsMessage);
        getServletContext().getRequestDispatcher("/JSP/Authentification.jsp").forward(request, response);
    }

}
