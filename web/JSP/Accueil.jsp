<%--
    Document   : Acceuil
    Created on : 28 août 2019, 22:51:20
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ProjetJDR/css/main.css" />
        <title>Accueil</title>
    </head>
    
    <body>
        <header>
            <%@ include file="Header.jsp" %>
        </header>

        <nav>
            <%@ include file="Nav.jsp" %>
        </nav>
        
        <article id="articleAccueil">
            <h1>Accueil</h1>
            <img src="images/Pathfinder.jpg" align="center" height="500" width="900">
            <label class="messageOrange">
                ${message}
            </label>
            <br><br>
        </article>

        <footer>
            <%@ include file="Footer.jsp" %>
        </footer>
    </body>
</html>
