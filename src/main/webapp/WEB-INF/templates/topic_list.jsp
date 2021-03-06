<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="topic.list.title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .topics {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1><fmt:message bundle="${particular}" key="topic.list.title" /></h1>
        <hr>
        <div class="topics">
            <table>
                <tr class="table-header">
                    <th><fmt:message bundle="${common}" key="number" /></th><th><fmt:message bundle="${common}" key="name" /></th>
                </tr>
                <c:forEach var="topic" items="${requestScope.topics}" varStatus="topicLoop">
                    <tr class="topic-info">
                        <td><c:out value="${topicLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/topic/${topic.id}"><c:out value="${topic.name}"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="pagination">
            <fmt:message bundle="${common}" key="pages" />:
            <c:forEach begin="0" end="${requestScope.pagesCount - 1}" var="i">
                <a href="${pageContext.request.contextPath}/topics?page=${i}"> ${i+1}</a>
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
