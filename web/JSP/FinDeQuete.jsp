<%-- 
    Document   : FinDeQuete
    Created on : 14 sept. 2019, 16:47:17
    Author     : Thomas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/ProjetJDR/css/main.css" />
        <script type="text/javascript" src="/ProjetJDR/js/jquery-3.4.1.min.js"></script>
        <title>Fin de quête</title>
    </head>
    <body>
        <header>
            <%@include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %>
        </nav>
        <article>
            <br>
            <c:forEach var="perso" items="${perso}">
                <form method="post">
                    <input type="text" name="nom" value="${perso.get(1)}" hidden="hidden">
                    <input type="text" name="prenom" value="${perso.get(0)}" hidden="hidden">
                    
                    <table style="margin-left: 100px">
                        <thead>
                            <tr>
                                <th colspan="3">
                                    <h3>${perso.get(0)} ${perso.get(1)}</h3>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th colspan="2">Classe & Niveau</th>
                                <th>${perso.get(2)} de niveau ${perso.get(3)}</th>
                            </tr>
                            <tr>
                                <th>Vie</th>
                                <th>${perso.get(4)}</th>
                                <th>
                                    <input type="number" name="vie">
                                </th>
                            </tr>
                            <tr>
                                <th>Dexterite</th>
                                <th>${perso.get(5)}</th>
                                <th>
                                    <input type="number" name="dexterite">
                                </th>
                            </tr>
                            <tr>
                                <th>Force</th>
                                <th>${perso.get(6)}</th>
                                <th>
                                    <input type="number" name="force">
                                </th>
                            </tr>
                            <tr>
                                <th>Intelligence</th>
                                <th>${perso.get(7)}</th>
                                <th>
                                    <input type="number" name="intelligence">
                                </th>
                            </tr>
                            <tr>
                                <th>Constitution</th>
                                <th>${perso.get(8)}</th>
                                <th>
                                    <input type="number" name="constitution">
                                </th>
                            </tr>
                            <tr>
                                <th>Sagesse</th>
                                <th>${perso.get(9)}</th>
                                <th>
                                    <input type="number" name="sagesse">
                                </th>
                            </tr>
                            <tr>
                                <th>Charisme</th>
                                <th>${perso.get(10)}</th>
                                <th>
                                    <input type="number" name="charisme">
                                </th>
                            </tr>
                            <tr>
                                <th>Expérience</th>
                                <th>${perso.get(11)}</th>
                                <th>
                                    <input type="number" name="experience">
                                </th>
                            </tr>
                            <tr>
                                <th colspan="3">
                                    <button type="submit" name="submit">Valider</button>
                                    <label hidden="hidden">${perso.get(0)}</label>
                                    <label hidden="hidden">${perso.get(1)}</label>
                                </th>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <br>
                <br>
            </c:forEach>
        </article>
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
