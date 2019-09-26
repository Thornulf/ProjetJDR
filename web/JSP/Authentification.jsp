<%-- 
    Document   : Authentification
    Created on : 28 août 2019, 23:00:45
    Author     : Thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ProjetJDR/css/main.css" />
        <title>Authentification</title>
    </head>
    <body>
        <header>
            <%@ include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %>
        </nav>

        <article>
            <div style="padding-left: 40%; padding-top: 10%">
                <h1>Se connecter</h1>
                <br>
                <form method="POST" action="/ProjetJDR/AuthentificationValidation">

                    <label class="etiquette">Pseudo</label>
                    <input type="text" name="pseudo" placeholder="Saisissez votre pseudo">
                    <br>
                    <label class="etiquette">Mot de passe</label>
                    <input type="password" name="mdp" placeholder="Mot de passe">
                    <br>
                    <button class="btn btn-primary">Connexion</button>

                </form>

                <label>
                    ${message}
                </label>
            </div>
        </article>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
