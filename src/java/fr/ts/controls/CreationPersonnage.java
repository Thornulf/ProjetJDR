/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.controls;

import fr.ts.dao.*;
import fr.ts.entities.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CreationPersonnage", urlPatterns = {"/CreationPersonnage"})
public class CreationPersonnage extends HttpServlet {

    List<Classes> classes = new ArrayList();

    /**
     * Permet de remplir la liste déroulante qui permet de choisir la classe du personnage lorsqu'on arrive sur la page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException      
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateurs user = (Utilisateurs) session.getAttribute("utilisateur");
        Connection cn = (Connection) session.getAttribute("connection");

        if (user != null) {

            classes = ClassesDAO.selectAll(cn);

            request.setAttribute("classes", classes);
            getServletContext().getRequestDispatcher("/JSP/CreatePersonnage.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            getServletContext().getRequestDispatcher("/JSP/Authentification.jsp").forward(request, response);
        }
    }

    /**
     * Controle des données et enregistrement dans la base de données après l'envoi du formulaire
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateurs user = (Utilisateurs) session.getAttribute("utilisateur");
        Connection cn = (Connection) session.getAttribute("connection");

        String nom = request.getParameter("nom").substring(0, 1).toUpperCase() + request.getParameter("nom").substring(1).toLowerCase();
        String prenom = request.getParameter("prenom").substring(0, 1).toUpperCase() + request.getParameter("prenom").substring(1).toLowerCase();
        String lsValue = request.getParameter("classe");

        // Récupération des champs du formulaire
        int vie = Integer.parseInt(request.getParameter("vie"));
        int FOR = Integer.parseInt(request.getParameter("FOR"));
        int DEX = Integer.parseInt(request.getParameter("DEX"));
        int CON = Integer.parseInt(request.getParameter("CON"));
        int INT = Integer.parseInt(request.getParameter("INT"));
        int SAG = Integer.parseInt(request.getParameter("SAG"));
        int CHA = Integer.parseInt(request.getParameter("CHA"));

        String message = "";

        String regexNom = "^[A-Z]{1}[']?[a-zàâäéèêëîïûüôö]{0,18}";

        Personnage perso = PersonnageDAO.selectOne(cn, nom, prenom);

        //Test sur la combianaison nom et prénom afin que l'ensemble reste unique dans la base de donneées
        if (perso != null) {
            message = "La combinaison nom et prenom du personnage est déjà prise";
        } else if (!prenom.equals("")) {
            if (Pattern.matches(regexNom, prenom)) {
                if (!nom.equals("") && Pattern.matches(regexNom, nom)) {
                    if (!lsValue.equals("choisir")) {
                        int ok = 0;
                        ok = Fonctions.initPerso(cn, lsValue, nom, prenom, vie, FOR,DEX, INT, CON, SAG, CHA, user);
                        if (ok == -1) {
                            message = "Une erreur c'est produite lors de l'enregistrement veuillez contacter l'administrateur";
                        }
                    } else {
                        message = "Veuiilez saisir une classe pour votre personnage";
                    }
                } else {
                    message = "le nom ne doit pas contenir de caractères spéciaux execpté \" ' \"";
                }
            } else {
                message = "le prenom ne doit pas contenir de caractères spéciaux execpté \" ' \"";
            }
        } else {
            message = "Veuillez renseigner le nom du personnage";
        }

        request.setAttribute("message", message);
        request.setAttribute("classes", classes);
        getServletContext().getRequestDispatcher("/JSP/CreatePersonnage.jsp").forward(request, response);
    }

}
