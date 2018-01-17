<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="signed.admin.title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    </head>
    <body>
        <h1><fmt:message bundle="${particular}" key="signed.admin.title" />, <fmt:message bundle="${particular}" key="signed.admin.admin" /></h1>
        <h3><fmt:message bundle="${particular}" key="signed.admin.h3" /></h3>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/students"><fmt:message bundle="${particular}" key="signed.admin.student.list" /></a>
                <a href="${pageContext.request.contextPath}/progresses"><fmt:message bundle="${particular}" key="signed.admin.student.progress.list" /></a>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
