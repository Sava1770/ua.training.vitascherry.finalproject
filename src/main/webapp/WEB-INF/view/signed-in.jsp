<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .signed-in, .navigation-menu {
                width: 400px;
            }
        </style>
    </head>
    <body>
        <div class="signed-in">
            <h1>Welcome!</h1>
            <h3>Now you can pass our tests</h3>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/topics">Quiz catalogue</a>
                <a href="${pageContext.request.contextPath}/quizzes">All quizzes</a>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
