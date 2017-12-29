<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student's progress list</title>
        <style>
            .progresses {
                width: 720px;
                height: 100%;
            }
            table {
                width: 100%;
                border-color: rgba(15, 13, 14, 0.50);
                margin: 1em 0 1em 0;
            }
            table td, table th {
                text-align: left;
            }
            .main-page-link {
                margin-top: 1em;
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
        <h1>Student's progress list</h1>
        <hr>
        <div class="progresses">
            <table cellpadding="1" border="1">
                <tr class="table-header">
                    <th>#</th><th>Student</th><th>Quiz</th><th>Questions</th><th>Correct</th>
                </tr>
                <c:forEach var="studentProgress" items="${requestScope.progresses}" varStatus="loop">
                    <tr class="progress-info">
                        <td><c:out value="${loop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/student/${studentProgress.student.id}"><c:out value="${studentProgress.student.firstName} ${studentProgress.student.lastName} ${studentProgress.student.patronymic}"/></a></td><td><a href="${pageContext.request.contextPath}/quiz/${studentProgress.quiz.id}"><c:out value="${studentProgress.quiz.name}"/></a></td><td><c:out value="${studentProgress.questionCount}"/></td><td><c:out value="${studentProgress.correctCount}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <hr>
        <div class="main-page-link">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
