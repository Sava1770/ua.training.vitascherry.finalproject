<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student ${requestScope.user.id}</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .student, .navigation-menu {
                width: 400px;
                height: 100%;
            }
            .label-col {
                font-weight: bold;
            }
            table, td, th {
                border: none;
            }
        </style>
    </head>
    <body>
        <h1>Student ${requestScope.user.id}</h1>
        <hr>
        <div class="student">
            <table>
                <tr>
                    <td class="label-col">Full name:</td><td><c:out value="${requestScope.user.firstName} ${requestScope.user.lastName} ${requestScope.user.patronymic}"/></td>
                </tr>
                <tr>
                    <td class="label-col">Email:</td><td><c:out value="${requestScope.user.email}"/></td>
                </tr>
            </table>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
