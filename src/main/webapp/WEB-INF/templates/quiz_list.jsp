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
                    <th><fmt:message bundle="${common}" key="number" /></th><th><fmt:message bundle="${particular}" key="topic.list.name" /></th>
                </tr>
                <c:forEach var="quiz" items="${requestScope.quizzes}" varStatus="quizLoop">
                    <tr class="quiz-info">
                        <td><c:out value="${quizLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/quiz/${quiz.id}"><c:out value="${quiz.name}"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="pagination">
            <fmt:message bundle="${common}" key="pages" />:
            <c:forEach begin="0" end="${requestScope.pagesCount - 1}" var="i">
                <c:choose>
                    <c:when test="${requestScope.topicId == null}">
                        <a href="${pageContext.request.contextPath}/quizzes?page=${i}"> ${i+1}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/topic/${requestScope.topicId}?page=${i}"> ${i+1}</a>
                    </c:otherwise>
                </c:choose>
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
