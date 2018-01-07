<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    </head>
    <body>
        <h1>Welcome, ${sessionScope.user.firstName}!</h1>
        <h3>You can now pass our tests</h3>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/topics">Quiz catalogue</a>
                <a href="${pageContext.request.contextPath}/quizzes">All quizzes</a>
                <a href="${pageContext.request.contextPath}/progress/${sessionScope.user.id}">My progress</a>
                <a href="${pageContext.request.contextPath}/student/${sessionScope.user.id}">My profile</a>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
