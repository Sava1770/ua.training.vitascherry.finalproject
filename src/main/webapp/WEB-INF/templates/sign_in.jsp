<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign-in</title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .sign-in {
                width: 400px;
                height: 100%;
            }
            table, td, th {
                border: none;
            }
        </style>
    </head>
    <body>
        <h1>Sign-in</h1>
        <hr>
        <div class="sign-in">
            <form method="POST" action="${pageContext.request.contextPath}/signin" autocomplete="on">
                <table>
                    <c:if test="${requestScope.invalidCredentials != null}">
                        <tr>
                            <td colspan="2" class="invalid"><c:out value="${requestScope.invalidCredentials}"/></td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><label for="email">E-mail</label></td>
                        <td><input type="email" name="email" placeholder="Enter E-mail" id="email" required autofocus></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password</label></td>
                        <td><input type="password" name="password" placeholder="Enter password" id="password" required></td>
                    </tr>
                    <tr>
                        <td colspan ="2"><input type="submit" value="Submit"/></td>
                    </tr>
                </table>
            </form>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
