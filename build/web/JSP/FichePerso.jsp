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

            <c:forEach var="personnage" items="${perso}">
                <div style="padding-left: 5%">
                    <div>
                        <div>
                            <h3>Personnage : ${personnage.get(0)} ${personnage.get(1)}</h3> 
                        </div>
                        <div>
                            <p>${personnage.get(2)} de niveau ${personnage.get(3)}</p>
                        </div>
                        <br>
                    </div>
                    <div>                    
                        <div>
                            <h4>Caractéristiques</h4> 
                        </div>
                        <p>Vie : ${personnage.get(4)}</p>
                        <div style="float: left; margin: 0;">
                            <p>Force : ${personnage.get(6)}</p>
                            <p>Dextérité : ${personnage.get(5)}</p>
                            <p>Intelligence : ${personnage.get(7)}</p>
                        </div>
                        <div style="margin: 0; margin-left: 150px;">
                            <p>Constitution : ${personnage.get(8)}</p>
                            <p>Sagesse : ${personnage.get(9)}</p>
                            <p>Charisme : ${personnage.get(10)}</p>
                        </div>

                        <br>
                    </div>
                </div>
            </c:forEach>

        </article>        
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>
