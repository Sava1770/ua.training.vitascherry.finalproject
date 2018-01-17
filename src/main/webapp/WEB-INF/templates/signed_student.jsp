<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="signed.student.title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    </head>
    <body>
        <h1><fmt:message bundle="${particular}" key="signed.student.title" />, ${sessionScope.user.firstName}!</h1>
        <h3><fmt:message bundle="${particular}" key="signed.student.h3" /></h3>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/topics"><fmt:message bundle="${particular}" key="signed.student.quiz.catalogue" /></a>
                <a href="${pageContext.request.contextPath}/quizzes"><fmt:message bundle="${particular}" key="signed.student.all.quizzes" /></a>
                <a href="${pageContext.request.contextPath}/progress/${sessionScope.user.id}"><fmt:message bundle="${particular}" key="signed.student.my.progress" /></a>
                <a href="${pageContext.request.contextPath}/student/${sessionScope.user.id}"><fmt:message bundle="${particular}" key="signed.student.my.profile" /></a>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
