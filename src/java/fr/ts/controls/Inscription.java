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
import java.util.regex.Pattern;
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
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/JSP/Inscription.jsp").forward(request, response); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();        
        String regexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        Utilisateurs user = null;
        
        Connection cn = (Connection) session.getAttribute("connection");
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("mdp");
        String eMail = request.getParameter("email");
        String message = "";
        
        user = UtilisateursDAO.selectOneBy(cn, pseudo);
        
        if(user != null) {
            message = "Le pseudo est déjà utilisé";
        } else {
            if(Pattern.matches(regexEmail, eMail)) {
                user = new Utilisateurs();
                
                user.setPseudo(pseudo);
                user.setPassword(mdp);
                user.seteMail(eMail);
                user.setIdRole(1);
                UtilisateursDAO.insert(cn, user);
            } else {
                message = "L'adresse mail n'est pas valide";
            }
        }
        
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/JSP/Authentification.jsp").forward(request, response);
    }

}
