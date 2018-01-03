<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .welcome, .navigation-menu {
                width: 400px;
            }
        </style>
    </head>
    <body>
        <div class="welcome">
            <h1>Welcome ${requestScope.user.role}!</h1>
            <h3>You can now track the progress of students</h3>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/students">Students list</a>
                <a href="${pageContext.request.contextPath}/progress">Students progress</a>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
