/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.controls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
@WebServlet(name = "ControleurPrincipal", urlPatterns = {"/ControleurPrincipal"})
public class ControleurPrincipal extends HttpServlet {

    /**
     * Se connecte à la base de données à l'arrivé sur l'application et enregistre la connection dans une variable de session
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Connection gcn = (Connection) session.getAttribute("connection");

        String lsMessage = "";

        if (gcn == null) {
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                gcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jeu_de_role", "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                lsMessage = "La connection à échouée";
            }

            session.setAttribute("connection", gcn);
        }

        request.setAttribute("message", lsMessage);
        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/JSP/Accueil.jsp").forward(request, response);
    }

}
