<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student ${requestScope.studentId} progress</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <style>
        .progresses, .navigation-menu {
            width: 600px;
            height: 100%;
        }
    </style>
</head>
<body>
<h1>Student ${requestScope.studentId} progress</h1>
<hr>
<div class="progresses">
    <table>
        <tr class="table-header">
            <th>#</th><th>Quiz</th><th>Questions</th><th>Correct</th>
        </tr>
        <c:forEach var="progress" items="${requestScope.progresses}" varStatus="progressLoop">
            <tr class="progress-info">
                <td><c:out value="${progressLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/result/${progress.student.id}/${progress.quiz.id}"><c:out value="${progress.quiz.name}"/></a></td><td><c:out value="${progress.questionCount}"/></td><td><c:out value="${progress.correctCount}"/></td>
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
