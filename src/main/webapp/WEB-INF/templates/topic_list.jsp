<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<fmt:setBundle basename="/i18n/topic_list" var="bundle" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${bundle}" key="title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .topics {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1><fmt:message bundle="${bundle}" key="title" /></h1>
        <hr>
        <div class="topics">
            <table>
                <tr class="table-header">
                    <th><fmt:message bundle="${bundle}" key="number" /></th><th><fmt:message bundle="${bundle}" key="name" /></th>
                </tr>
                <c:forEach var="topic" items="${requestScope.topics}" varStatus="topicLoop">
                    <tr class="topic-info">
                        <td><c:out value="${topicLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/topic/${topic.id}"><c:out value="${topic.name}"/></a></td>
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
