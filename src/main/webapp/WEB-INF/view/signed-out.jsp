<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See you later</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .signed-out, .navigation-menu {
                width: 400px;
            }
        </style>
    </head>
    <body>
        <div class="signed-out">
            <h1>You are now signed out!</h1>
            <h3>You can return to the home page or sign in again</h3>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/sign-in">Sign In</a>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
