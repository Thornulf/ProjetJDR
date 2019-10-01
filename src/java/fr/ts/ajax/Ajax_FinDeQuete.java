/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.ajax;

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
@WebServlet(name = "Ajax_FinDeQuete", urlPatterns = {"/Ajax_FinDeQuete"})
public class Ajax_FinDeQuete extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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

        System.out.println("JE SUIS PASSE");

        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/JSP/Acceuil.jsp").forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateurs user = (Utilisateurs) session.getAttribute("utilisateur");
        Connection cn = (Connection) session.getAttribute("connection");

        System.out.println("JE SUIS PASSE");

        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/JSP/Acceuil.jsp").forward(request, response);

    }

}
