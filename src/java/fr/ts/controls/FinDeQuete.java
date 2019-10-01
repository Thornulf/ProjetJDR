/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.controls;

import fr.ts.dao.PersonnageDAO;
import fr.ts.entities.Fonctions;
import fr.ts.entities.Personnage;
import fr.ts.entities.Utilisateurs;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(name = "FinDeQuete", urlPatterns = {"/FinDeQuete"})
public class FinDeQuete extends HttpServlet {

    private List<List<String>> initPage(Connection cn, Utilisateurs user) {
        List<List<String>> listPerso = new ArrayList();

        try {
            String lsSQL = "SELECT p.prenom, p.nom, c.nom_classe, p.niveau,p.vie, "
                    + "p.p_dexterite, p.p_force, p.p_intelligence, p.p_constitution, p.p_sagesse, p.p_charisme, p.experience "
                    + "FROM personnages AS p "
                    + "INNER JOIN classes AS c on p.id_classe = c.id_classe "
                    + "WHERE p.id_utilisateur != " + user.getIdUtilisateur();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(lsSQL);

            while (rs.next()) {
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
                out.add(Integer.toString(rs.getInt(12)));

                listPerso.add(out);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return listPerso;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateurs user = (Utilisateurs) session.getAttribute("utilisateur");
        Connection cn = (Connection) session.getAttribute("connection");

        if (user != null) {

            if (user.getIdRole() != 1) {

                List<List<String>> listPerso = initPage(cn, user);
                
                request.setAttribute("perso", listPerso);
                getServletContext().getRequestDispatcher("/JSP/FinDeQuete.jsp").forward(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
                getServletContext().getRequestDispatcher("/JSP/AccesRefuse.jsp").forward(request, response);
            }

        } else {
            response.setContentType("text/html;charset=UTF-8");
            getServletContext().getRequestDispatcher("/JSP/Authentification.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateurs user = (Utilisateurs) session.getAttribute("utilisateur");
        Connection cn = (Connection) session.getAttribute("connection");        
        
        String message = "";

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        
        Personnage perso = PersonnageDAO.selectOne(cn, nom, prenom);
        
        String vie, FOR, DEX, CON, INT, CHA, SAG, EXP;
        
        if(!request.getParameter("vie").equals("")) {
            vie = request.getParameter("vie");
        } else {
            vie = String.valueOf(perso.getVie());
        }
        
        if(!request.getParameter("force").equals("")) {
            FOR = request.getParameter("force");
        } else {
            FOR = String.valueOf(perso.getForce());
        }
        
        if(!request.getParameter("dexterite").equals("")) {
            DEX = request.getParameter("vie");
        } else {
            DEX = String.valueOf(perso.getDexterite());
        }
        
        if(!request.getParameter("constitution").equals("")) {
            CON = request.getParameter("constitution");
        } else {
            CON = String.valueOf(perso.getConstitution());
        }
        
        if(!request.getParameter("intelligence").equals("")) {
            INT = request.getParameter("intelligence");
        } else {
            INT = String.valueOf(perso.getIntelligence());
        }
        
        if(!request.getParameter("charisme").equals("")) {
            CHA = request.getParameter("charisme");
        } else {
            CHA = String.valueOf(perso.getCharisme());
        }
        
        if(!request.getParameter("sagesse").equals("")) {
            SAG = request.getParameter("sagesse");
        } else {
            SAG = String.valueOf(perso.getSagesse());
        }
        
        if(!request.getParameter("experience").equals("")) {
            EXP = request.getParameter("experience");
        } else {
            EXP = String.valueOf(perso.getExperience());
        }

        if (Fonctions.okGagnerNiveau(perso, cn)) {
            perso.setNiveaux(perso.gagnerNiveau());
            perso.setVie(Integer.valueOf(vie));
            perso.setForce(Integer.valueOf(FOR));
            perso.setDexterite(Integer.valueOf(DEX));
            perso.setConstitution(Integer.valueOf(CON));
            perso.setIntelligence(Integer.valueOf(INT));
            perso.setCharisme(Integer.valueOf(CHA));
            perso.setSagesse(Integer.valueOf(SAG));
        }

        perso.setExperience(perso.gagnerExperience(Integer.valueOf(EXP)));
        PersonnageDAO.update(cn, perso);

        List<List<String>> listPerso = initPage(cn, user);
        
        request.setAttribute("message", message);
        request.setAttribute("perso", listPerso);
        getServletContext().getRequestDispatcher("/JSP/FinDeQuete.jsp").forward(request, response);
    }

}
