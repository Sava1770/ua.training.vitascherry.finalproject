<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Inspector</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .welcome, .navigation-menu {
                width: 1000px;
            }
            .navigation-menu a {
                margin-right: 1em;
            }
        </style>
    </head>
    <body>
        <div class="welcome">
            <h1>Welcome to Student Inspector!</h1>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/topics">Quiz catalogue</a>
                <a href="${pageContext.request.contextPath}/progresses">Student's Progress list</a>
                <a href="${pageContext.request.contextPath}/progress/${sessionScope.user.id}">My progress</a>
                <a href="${pageContext.request.contextPath}/students">Student list</a>
                <a href="${pageContext.request.contextPath}/student/${sessionScope.user.id}">My profile</a>
                <a href="${pageContext.request.contextPath}/signin">Sign-in</a>
                <a href="${pageContext.request.contextPath}/signout">Sign-out</a>
                <a href="${pageContext.request.contextPath}/register">Register</a>
            </nav>
        </div>
    </body>
</html>
