<%-- 
    Document   : CreatePersonnage
    Created on : 31 août 2019, 18:08:02
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ProjetJDR/css/main.css" />
        <title>Création Personnage</title>
    </head>
    <body>
        <header>
            <%@include file="Header.jsp" %>
        </header>

        <nav>
            <%@include file="Nav.jsp" %>
        </nav>

        <article>
            <form action="" method="post">
                <label class="etiquette">Nom</label>
                <input type="text" name="nom">
                <br>
                <label class="etiquette">Prénom</label>
                <input type="text" name="prenom">
                <br>
                <label class="etiquette">Classe</label>
                <select name="classe">
                    <option value = "choisir">Choisir une classe</option>
                    <c:forEach var="classe" items="${classes}">
                        <option value="${classe.idClasse}">${classe.nomClasse}</option>
                    </c:forEach>
                </select>
                <br>
                <br>
                <h3>Caractéristiques</h3>
                <br>
                <label class="etiquette">Vie</label>
                <input type="number" name="vie">
                <br>
                <label class="etiquette">Force</label>
                <input type="number" name="FOR">
                <label class="etiquette">Constitution</label>
                <input type="number" name="CON">
                <br>
                <label class="etiquette">Intelligence</label>
                <input type="number" name="INT">
                <label class="etiquette">Sagesse</label>
                <input type="number" name="SAG">
                <br>
                <label class="etiquette">Dexterite</label>
                <input type="number" name="DEX">
                <label class="etiquette">Charisme</label>
                <input type="number" name="CHA">
                <br>

                <br>
                <button type="submit">Valider</button>
            </form>
            <br>
            <label>
                ${message}
            </label>
        </article>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
