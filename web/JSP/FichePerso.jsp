<%-- 
    Document   : FichePerso
    Created on : 8 sept. 2019, 13:05:41
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ProjetJDR/css/main.css" />
        <link rel="stylesheet" type="text/css" href="/ProjetJDR/css/fichePerso.css" /> 
        <script type="text/javascript" src="/ProjetJDR/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="/ProjetJDR/js/FinDeQuete.js"></script>
        <title>Fiche de Personnage</title>
    </head>
    <body>

        <header>
            <%@include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %>
        </nav>
        <article>

            <div id="myBtnContainer" style="padding-left: 5%">
                <c:forEach var="personnage" items="${perso}">

                    <button class="btn" name="perso">${personnage.get(0)} ${personnage.get(1)}</button>

                </c:forEach>
            </div>

            <br>

            <c:forEach var="personnage" items="${perso}">

                <div style="padding-left: 5%">

                    <table name="${personnage.get(0)} ${personnage.get(1)}">
                        <thead>
                            <tr>
                                <th colspan="4">${personnage.get(0)} ${personnage.get(1)}</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <th colspan="2">${personnage.get(2)}</th>
                                <th>Niveau</th>
                                <th style="color: red">${personnage.get(3)}</th>
                            </tr>
                            <tr>
                                <th colspan="2">Vie</th>
                                <th colspan="2">${personnage.get(4)}</th> 
                            </tr>
                            <tr>
                                <th>Force</th>
                                <th style="color: blue">${personnage.get(6)}</th>
                                <th>Dextérité</th>
                                <th style="color: blue">${personnage.get(5)}</th>
                            </tr>
                            <tr>
                                <th>Intelligence</th>
                                <th style="color: blue">${personnage.get(7)}</th>
                                <th>Constitution</th>
                                <th style="color: blue">${personnage.get(8)}</th>
                            </tr>
                            <tr>
                                <th>Sagesse</th>
                                <th style="color: blue">${personnage.get(9)}</th>
                                <th>Charisme</th>
                                <th style="color: blue">${personnage.get(10)}</th>
                            </tr>
                        </tbody>
                    </table> 
                </div>
            </c:forEach>

        </article>        
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>

    </body>
</html>
