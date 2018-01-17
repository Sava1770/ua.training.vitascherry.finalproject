<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="student.list.title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .students {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1><fmt:message bundle="${particular}" key="student.list.title" /></h1>
        <hr>
        <div class="students">
            <table>
                <tr class="table-header">
                    <th><fmt:message bundle="${common}" key="number" /></th><th><fmt:message bundle="${particular}" key="student.list.full.name" /></th><th><fmt:message bundle="${particular}" key="student.list.email" /></th>
                </tr>
                <c:forEach var="student" items="${requestScope.students}" varStatus="studentLoop">
                    <tr class="student-info">
                        <td><c:out value="${studentLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/student/${student.id}"><c:out value="${student.lastName} ${student.firstName} ${student.patronymic}"/></a></td><td><c:out value="${student.email}"/></td>
                    </tr>
                </c:forEach>
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
