<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <h3>You can now sign-in using your credentials</h3>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/signin">Sign-in</a>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
