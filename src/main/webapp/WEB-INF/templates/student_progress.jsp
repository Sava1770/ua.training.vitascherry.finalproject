<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message bundle="${particular}" key="student.progress.title" /> ${requestScope.studentId}</title>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    <style>
        .progresses {
            width: 600px;
            height: 100%;
        }
    </style>
</head>
<body>
<h1><fmt:message bundle="${particular}" key="student.progress.title" /> ${requestScope.studentId}</h1>
<hr>
<div class="progresses">
    <table>
        <tr class="table-header">
            <th><fmt:message bundle="${common}" key="number" /></th><th><fmt:message bundle="${particular}" key="student.progress.quiz" /></th><th><fmt:message bundle="${particular}" key="student.progress.questions" /></th><th><fmt:message bundle="${particular}" key="student.progress.correct" /></th>
        </tr>
        <c:forEach var="progress" items="${requestScope.progresses}" varStatus="progressLoop">
            <tr class="progress-info">
                <td><c:out value="${progressLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/result/${progress.student.id}/${progress.quiz.id}"><c:out value="${progress.quiz.name}"/></a></td><td><c:out value="${progress.questionCount}"/></td><td><c:out value="${progress.correctCount}"/></td>
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
