<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="forbidden.title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    </head>
    <body>
    <h1><fmt:message bundle="${particular}" key="forbidden.h1" /></h1>
        <h3><fmt:message bundle="${particular}" key="forbidden.h3" />${requestScope["javax.servlet.forward.request_uri"]}</h3>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
