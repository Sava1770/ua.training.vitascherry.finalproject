<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error 403</title>
    <style>
        <%@ include file="/WEB-INF/view/style/main.css"%>

        /* Current file styles */
        .navigation-menu, .error {
            width: 600px;
        }
    </style>
</head>
<body>
<div class="error">
    <h1>403 Forbidden</h1>
    <h3>You do not have access to the ${requestScope["javax.servlet.forward.request_uri"]}</h3>
</div>
<div class="navigation-menu">
    <nav>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </nav>
</div>
</body>
</html>
