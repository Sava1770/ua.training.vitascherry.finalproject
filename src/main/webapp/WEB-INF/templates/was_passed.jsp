<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message bundle="${particular}" key="was.passed.title" /></title>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
</head>
<body>
<div class="error">
    <h1><fmt:message bundle="${particular}" key="was.passed.title" />!</h1>
    <h3><fmt:message bundle="${particular}" key="was.passed.h3" /></h3>
</div>
<div class="navigation-menu">
    <nav>
        <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
        <a href="${pageContext.request.contextPath}/available"><fmt:message bundle="${particular}" key="was.passed.available" /></a>
    </nav>
</div>
</body>
</html>
