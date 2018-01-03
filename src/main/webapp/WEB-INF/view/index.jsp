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
                width: 700px;
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
                <a href="${pageContext.request.contextPath}/topics">Topic list</a>
                <a href="${pageContext.request.contextPath}/quizzes">Quiz list</a>
                <a href="${pageContext.request.contextPath}/progress">Progress</a>
                <a href="${pageContext.request.contextPath}/students">Student list</a>
                <a href="${pageContext.request.contextPath}/signin">Sign-in</a>
                <a href="${pageContext.request.contextPath}/register">Register</a>
            </nav>
        </div>
    </body>
</html>
