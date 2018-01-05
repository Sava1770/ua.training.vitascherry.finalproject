<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See you later</title>
        <link rel="stylesheet" type="text/css" href="/css/main.css">
        <style>
            .goodbye, .navigation-menu {
                width: 600px;
            }
        </style>
    </head>
    <body>
        <div class="goodbye">
            <h1>You are now signed out!</h1>
            <h3>You can return to the home page or sign-in again</h3>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/signin">Sign-in</a>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
