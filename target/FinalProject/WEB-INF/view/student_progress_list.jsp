<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student's progress list</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .progresses, .navigation-menu {
                width: 700px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1>Student's progress list</h1>
        <hr>
        <div class="progresses">
            <table>
                <tr class="table-header">
                    <th>#</th><th>Student</th><th>Quiz</th><th>Questions</th><th>Correct</th>
                </tr>
                <c:forEach var="studentProgress" items="${requestScope.progresses}" varStatus="progressLoop">
                    <tr class="progress-info">
                        <td><c:out value="${progressLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/student/${studentProgress.student.id}"><c:out value="${studentProgress.student.firstName} ${studentProgress.student.lastName} ${studentProgress.student.patronymic}"/></a></td><td><a href="${pageContext.request.contextPath}/result/${studentProgress.student.id}/${studentProgress.quiz.id}"><c:out value="${studentProgress.quiz.name}"/></a></td><td><c:out value="${studentProgress.questionCount}"/></td><td><c:out value="${studentProgress.correctCount}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </nav>
        </div>
    </body>
</html>
