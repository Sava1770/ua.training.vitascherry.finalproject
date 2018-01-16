<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<fmt:setBundle basename="/i18n/index" var="bundle" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${bundle}" key="title" /></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    </head>
    <body>
        <h1><fmt:message bundle="${bundle}" key="welcome" /></h1>
        <h2><fmt:message bundle="${bundle}" key="choose.language" /></h2>
        <form action="${pageContext.request.contextPath}/" method="POST">
            <select name="locale" onchange="submit()">
                <option value="en_US" ${locale == 'en_US' ? 'selected' : ''}><fmt:message bundle="${bundle}" key="language.en"/></option>
                <option value="uk_UA" ${locale == 'uk_UA' ? 'selected' : ''}><fmt:message bundle="${bundle}" key="language.ua"/></option>
                <option value="ru_RU" ${locale == 'ru_RU' ? 'selected' : ''}><fmt:message bundle="${bundle}" key="language.ru"/></option>
            </select>
        </form>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/topics"><fmt:message bundle="${bundle}" key="quiz.catalogue" /></a>
                <a href="${pageContext.request.contextPath}/signin"><fmt:message bundle="${bundle}" key="sign.in" /></a>
                <a href="${pageContext.request.contextPath}/signout"><fmt:message bundle="${bundle}" key="sign.out" /></a>
                <a href="${pageContext.request.contextPath}/register"><fmt:message bundle="${bundle}" key="register" /></a>
            </nav>
        </div>
    </body>
</html>
