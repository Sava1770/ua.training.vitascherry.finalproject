<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Inspector</title>
        <style>
            .menu {
                width: 640px;
            }
            .menu nav {
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
        <div class="menu">
            <nav>
                <a href="${pageContext.request.contextPath}/students">Students</a>
                <a href="${pageContext.request.contextPath}/topics">Topics</a>
                <a href="${pageContext.request.contextPath}/quizzes">Quizzes</a>
                <a href="${pageContext.request.contextPath}/quiz/1">Quiz 1</a>
            </nav>
        </div>
    </body>
</html>
