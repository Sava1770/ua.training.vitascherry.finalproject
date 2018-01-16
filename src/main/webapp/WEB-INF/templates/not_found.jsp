<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<fmt:setBundle basename="/i18n/not_found" var="bundle" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${bundle}" key="title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    </head>
    <body>
        <div class="error">
            <h1><fmt:message bundle="${bundle}" key="title" />!</h1>
            <h3>${requestScope["javax.servlet.forward.request_uri"]} <fmt:message bundle="${bundle}" key="h3" /></h3>
        </div>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${bundle}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
