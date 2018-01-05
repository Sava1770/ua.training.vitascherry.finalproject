<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="/css/main.css">
        <script src="/js/jquery-3.2.1.min.js"></script>
        <script src="/js/register.js"></script>
        <style>
            .register {
                width: 400px;
                height: 100%;
            }
            table, td, th {
                border: none;
            }
            em {
                color: #ff0000;
            }
        </style>
    </head>
    <body>
        <h1>Register</h1>
        <hr>
        <div class="register">
            <form method="POST" action="${pageContext.request.contextPath}/register" autocomplete="on">
                <table>
                    <tr>
                        <td><label for="firstName">First name<em>*</em></label></td>
                        <td><input type="text" name="firstName" placeholder="Enter first name" id="firstName" autofocus required></td>
                    </tr>
                    <tr>
                        <td><label for="lastName">Last name<em>*</em></label></td>
                        <td><input type="text" name="lastName" placeholder="Enter last name" id="lastName" required></td>
                    </tr>
                    <tr>
                        <td><label for="patronymic">Patronymic<em>*</em></label></td>
                        <td><input type="text" name="patronymic" placeholder="Enter patronymic" id="patronymic" required></td>
                    </tr>
                    <tr>
                        <td><label for="email">E-mail<em>*</em></label></td>
                        <td><input type="email" name="email" placeholder="Enter E-mail" id="email" required></td>
                    </tr>
                    <c:if test="${requestScope.notUniqueEmail != null}">
                        <tr>
                            <td colspan="2" class="invalid"><c:out value="${requestScope.notUniqueEmail}"/></td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><label for="password">Password<em>*</em></label></td>
                        <td><input type="password" name="password" placeholder="Enter password" id="password" required></td>
                    </tr>
                    <tr>
                        <td><label for="confirm">Confirm password<em>*</em></label></td>
                        <td><input type="password" name="confirm" placeholder="Confirm password" id="confirm" required oninput="check(this)"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Submit"/></td>
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
