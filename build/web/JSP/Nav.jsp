<%-- 
    Document   : Nav
    Created on : 28 août 2019, 22:57:33
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="fr.ts.entities.Utilisateurs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Utilisateurs user = (Utilisateurs) session.getAttribute("utilisateur");
%>

<% if (user == null) { %> 
<ul style="display: block; text-align: right;">          
    <li>
        <a href="/ProjetJDR/Authentification">Se connecter | </a>       
    </li>   
    <li>
        <a href="/ProjetJDR/Inscription">S'incrire</a>
    </li>
</ul>

<% } else { %>

<ul style="padding-left: 5%">             
    <li>
        <a href="/ProjetJDR/CreationPersonnage">Créer un personnage | </a>
    </li>
    <li>
        <a href="/ProjetJDR/FichePerso">Fiche personnage | </a>
    </li>
    <% if (user.getIdRole() == 3) { %>
    <li>
        <a href="">Administrateur | </a>
    </li>
    <% }
        if (user.getIdRole() != 1) {
    %>
    <li>
        <a href="/ProjetJDR/FinDeQuete">Récompenses | </a>
    </li>
    <% } %>
    <li>
        <a href="/ProjetJDR/Deconnexion">Se déconnecter</a>       
    </li>
</ul>

<% } %>