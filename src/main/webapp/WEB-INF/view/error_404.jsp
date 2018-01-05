<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error 404</title>
        <link rel="stylesheet" type="text/css" href="/css/main.css">
        <style>
            .navigation-menu, .error {
                width: 600px;
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
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
