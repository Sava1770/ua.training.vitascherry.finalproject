<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<fmt:setBundle basename="/i18n/register" var="bundle" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${bundle}" key="title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <script src="/static/js/jquery-3.2.1.min.js"></script>
        <script src="/static/js/register.js"></script>
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
        <h1><fmt:message bundle="${bundle}" key="title" /></h1>
        <hr>
        <div class="register">
            <form method="POST" action="${pageContext.request.contextPath}/register" autocomplete="on">
                <table>
                    <tr>
                        <td><label for="firstName"><fmt:message bundle="${bundle}" key="first.name" /><em>*</em></label></td>
                        <td><input type="text" name="firstName" id="firstName" autofocus required></td>
                    </tr>
                    <tr>
                        <td><label for="lastName"><fmt:message bundle="${bundle}" key="last.name" /><em>*</em></label></td>
                        <td><input type="text" name="lastName" id="lastName" required></td>
                    </tr>
                    <tr>
                        <td><label for="patronymic"><fmt:message bundle="${bundle}" key="patronymic" /><em>*</em></label></td>
                        <td><input type="text" name="patronymic" id="patronymic" required></td>
                    </tr>
                    <tr>
                        <td><label for="email">E-mail<em>*</em></label></td>
                        <td><input type="email" name="email" id="email" required></td>
                    </tr>
                    <c:if test="${requestScope.isNotUniqueEmail}">
                        <tr>
                            <td colspan="2" class="invalid"><c:out value="${requestScope.email}"/> <fmt:message bundle="${bundle}" key="duplicate" /></td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><label for="password"><fmt:message bundle="${bundle}" key="password" /><em>*</em></label></td>
                        <td><input type="password" name="password" id="password" required></td>
                    </tr>
                    <tr>
                        <td><label for="confirm"><fmt:message bundle="${bundle}" key="confirm" /><em>*</em></label></td>
                        <td><input type="password" name="confirm" id="confirm" required oninput="check(this)"></td>
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
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${bundle}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
