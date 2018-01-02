<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page isErrorPage="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .navigation-menu, .error {
                width: 400px;
            }
        </style>
    </head>
    <body>
        <div class="error">
            <h1>404 Not Found</h1>
            <h3>The requested URI ${requestScope["javax.servlet.forward.request_uri"]} was not found on this server.</h3>
        </div>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </nav>
        </div>
    </body>
</html>
