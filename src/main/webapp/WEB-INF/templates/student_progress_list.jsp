<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="student.progress.list.title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .progresses {
                width: 800px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1><fmt:message bundle="${particular}" key="student.progress.list.title" /></h1>
        <hr>
        <div class="progresses">
            <table>
                <tr class="table-header">
                    <th><fmt:message bundle="${common}" key="number" /></th><th><fmt:message bundle="${particular}" key="student.progress.list.student" /></th><th><fmt:message bundle="${particular}" key="student.progress.list.quiz" /></th><th><fmt:message bundle="${particular}" key="student.progress.list.questions" /></th><th><fmt:message bundle="${particular}" key="student.progress.list.correct" /></th>
                </tr>
                <c:forEach var="studentProgress" items="${requestScope.progresses}" varStatus="progressLoop">
                    <tr class="progress-info">
                        <td><c:out value="${progressLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/student/${studentProgress.student.id}"><c:out value="${studentProgress.student.lastName} ${studentProgress.student.firstName} ${studentProgress.student.patronymic}"/></a></td><td><a href="${pageContext.request.contextPath}/result/${studentProgress.student.id}/${studentProgress.quiz.id}"><c:out value="${studentProgress.quiz.name}"/></a></td><td><c:out value="${studentProgress.questionCount}"/></td><td><c:out value="${studentProgress.correctCount}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="pagination">
            <fmt:message bundle="${common}" key="pages" />:
            <c:forEach begin="0" end="${requestScope.pagesCount - 1}" var="i">
                <a href="${pageContext.request.contextPath}/progresses?page=${i}"> ${i+1}</a>
            </c:forEach>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
