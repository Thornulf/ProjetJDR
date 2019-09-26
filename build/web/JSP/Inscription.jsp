<%-- 
    Document   : inscription
    Created on : 1 sept. 2019, 17:31:42
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ProjetJDR/css/main.css" />
        <title>S'inscrire</title>
    </head>
    <body>
        <header>
            <%@include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %>
        </nav>
        <article>
            <form method="post" action="/ProjetJDR/Inscription">
                <label class="etiquette">Pseudo</label>
                <input type="text" name="pseudo" placeholder="Saisissez un Pseudo">
                <br>
                <label class="etiquette">Mot de passe</label>
                <input type="password" name="mdp" placeholder="Entrez un mot de passe">
                <br>
                <label class="etiquette">Email</label>
                <input type="email" name="email" placeholder="Saisissez votre addresse Mail">
                <br>
                <button type="submit">S'inscrire</button>
            </form>
            
            <label>
                ${message}
            </label>
        </article>
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
