<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<fmt:setBundle basename="/i18n/student_list" var="bundle" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${bundle}" key="title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .students {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1><fmt:message bundle="${bundle}" key="title" /></h1>
        <hr>
        <div class="students">
            <table>
                <tr class="table-header">
                    <th><fmt:message bundle="${bundle}" key="number" /></th><th><fmt:message bundle="${bundle}" key="full.name" /></th><th><fmt:message bundle="${bundle}" key="email" /></th>
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
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${bundle}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
