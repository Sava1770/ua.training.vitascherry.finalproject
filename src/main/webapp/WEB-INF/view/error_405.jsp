<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error 405</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <style>
        .navigation-menu, .error {
            width: 600px;
        }
    </style>
</head>
<body>
<div class="error">
    <h1>405 Method Not Allowed</h1>
    <h3>Sorry, you have already passed this quiz. Try another one!</h3>
</div>
<div class="navigation-menu">
    <nav>
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/available">Available quizzes</a>
    </nav>
</div>
</body>
</html>
