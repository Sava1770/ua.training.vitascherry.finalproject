<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="quiz.list.title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .quizzes {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1><fmt:message bundle="${particular}" key="quiz.list.title" /></h1>
        <hr>
        <div class="quizzes">
            <table>
                <tr class="table-header">
                    <th><fmt:message bundle="${common}" key="number" /></th><th><fmt:message bundle="${common}" key="name" /></th>
                </tr>
                <c:forEach var="quiz" items="${requestScope.quizzes}" varStatus="quizLoop">
                    <tr class="quiz-info">
                        <td><c:out value="${quizLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/quiz/${quiz.id}"><c:out value="${quiz.name}"/></a></td>
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
