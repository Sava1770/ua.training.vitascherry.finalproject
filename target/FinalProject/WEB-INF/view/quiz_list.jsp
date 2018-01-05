<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topic list</title>
        <link rel="stylesheet" type="text/css" href="/css/main.css">
        <style>
            .quizzes, .navigation-menu {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1>Quiz list</h1>
        <hr>
        <div class="quizzes">
            <table>
                <tr class="table-header">
                    <th>#</th><th>Name</th>
                </tr>
                <c:forEach var="quiz" items="${requestScope.quizzes}" varStatus="quizLoop">
                    <tr class="quiz-info">
                        <td><c:out value="${quizLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/quiz/${quiz.id}"><c:out value="${quiz.name}"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
