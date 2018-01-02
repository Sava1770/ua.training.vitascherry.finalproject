<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Inspector</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .navigation-menu {
                width: 600px;
            }
            .navigation-menu a {
                margin-right: 1em;
            }
        </style>
    </head>
    <body>
        <h1>Welcome to Student Inspector!</h1>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/topics">Topic list</a>
                <a href="${pageContext.request.contextPath}/quizzes">Quiz list</a>
                <a href="${pageContext.request.contextPath}/progress">Progress</a>
                <a href="${pageContext.request.contextPath}/students">Student list</a>
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </nav>
        </div>
    </body>
</html>
