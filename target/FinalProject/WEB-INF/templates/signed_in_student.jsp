<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<fmt:setBundle basename="/i18n/signed_student" var="bundle" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${bundle}" key="title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    </head>
    <body>
        <h1><fmt:message bundle="${bundle}" key="title" />, ${sessionScope.user.firstName}!</h1>
        <h3><fmt:message bundle="${bundle}" key="h3" /></h3>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/topics"><fmt:message bundle="${bundle}" key="quiz.catalogue" /></a>
                <a href="${pageContext.request.contextPath}/quizzes"><fmt:message bundle="${bundle}" key="all.quizzes" /></a>
                <a href="${pageContext.request.contextPath}/progress/${sessionScope.user.id}"><fmt:message bundle="${bundle}" key="my.progress" /></a>
                <a href="${pageContext.request.contextPath}/student/${sessionScope.user.id}"><fmt:message bundle="${bundle}" key="my.profile" /></a>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${bundle}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
