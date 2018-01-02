<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Successfully registered</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .navigation-menu, .navigation-menu {
                width: 400px;
            }
        </style>
    </head>
    <body>
        <h1>Successfully registered!</h1>
        <h3>Now you can login using your credentials</h3>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/login">Login</a>
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </nav>
        </div>
    </body>
</html>
