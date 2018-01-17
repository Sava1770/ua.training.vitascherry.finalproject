<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="student.profile.title" /> ${requestScope.student.id}</title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .student {
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
        <h1><fmt:message bundle="${particular}" key="student.profile.title" /> ${requestScope.student.id}</h1>
        <hr>
        <div class="student">
            <table>
                <tr>
                    <td class="label-col"><fmt:message bundle="${particular}" key="student.profile.full.name" />:</td><td><c:out value="${requestScope.student.lastName} ${requestScope.student.firstName} ${requestScope.student.patronymic}"/></td>
                </tr>
                <tr>
                    <td class="label-col"><fmt:message bundle="${particular}" key="student.profile.email" />:</td><td><c:out value="${requestScope.student.email}"/></td>
                </tr>
            </table>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
