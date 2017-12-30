<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Inspector</title>
        <style>
            .navigation-menu {
                width: 640px;
            }
            nav {
                width: 100%;
                margin: 1em 0 1em 0;
            }
            a {
                color: rgb(119,34,51);
            }
            a:link {
                color: rgb(119,34,51);
                margin-right: 1em;
                text-decoration: none;
            }
            a:hover {
                color: rgb(6,69,173);
            }
            a:visited {
                color: rgb(119,34,51);
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
