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
        <title>Acceuil</title>
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
            <br>
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
