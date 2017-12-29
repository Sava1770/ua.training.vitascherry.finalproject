<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topic list</title>
        <style>
            .quizzes {
                width: 640px;
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
        <h1>Quiz list</h1>
        <hr>
        <div class="quizzes">
            <table cellpadding="1" border="1">
                <tr class="table-header">
                    <th>#</th><th>Name</th>
                </tr>
                <c:forEach var="quiz" items="${requestScope.quizzes}">
                    <tr class="quiz-info">
                        <td><c:out value="${quiz.id}"/></td><td><a href="${pageContext.request.contextPath}/quiz/${quiz.id}"><c:out value="${quiz.name}"/></a></td>
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
