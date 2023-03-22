<%-- 
    Document   : hello-jsp
    Created on : 17 mar 2023, 16:23:25
    Author     : ospite
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <table>
            <thead>
            <th>ID</th>
            <th>TITOLO</th>
            <th>DATA</th>
            <th>AUTORE</th>
        </thead>
        <tbody>
            <c:forEach items="${libriStore.allLibri()}" var="libro">
                <tr>
                    <td><c:out  value="${libro.id}" /></td>
                    <td><c:out  value="${libro.titolo}" /></td>
                    <td><c:out  value="${libro.dataPubblicazione}" /></td>
                    <td><c:out  value="${libro.autore.cognome}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
