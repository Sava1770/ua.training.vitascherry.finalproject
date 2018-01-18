<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="sign.in.title" /></title>
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
        <h1><fmt:message bundle="${particular}" key="sign.in.title" /></h1>
        <hr>
        <div class="sign-in">
            <form method="POST" action="${pageContext.request.contextPath}/signin" autocomplete="on" >
                <table>
                    <c:if test="${requestScope.isInvalidCredentials}">
                        <tr>
                            <td colspan="2" class="invalid"><fmt:message bundle="${particular}" key="sign.in.invalid" /></td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><label for="email">E-mail</label></td>
                        <td><input type="email" name="email" id="email" required autofocus></td>
                    </tr>
                    <tr>
                        <td><label for="password"><fmt:message bundle="${particular}" key="sign.in.password" /></label></td>
                        <td><input type="password" name="password" id="password" required></td>
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
                <a href="${pageContext.request.contextPath}/register"><fmt:message bundle="${common}" key="register" /></a>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
