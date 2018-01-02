<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student list</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .students {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1>Student list</h1>
        <hr>
        <div class="students">
            <table cellpadding="1" border="1">
                <tr class="table-header">
                    <th>#</th><th>Full name</th><th>Email</th>
                </tr>
                <c:forEach var="student" items="${requestScope.students}" varStatus="studentLoop">
                    <tr class="student-info">
                        <td><c:out value="${studentLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/student/${student.id}"><c:out value="${student.firstName} ${student.lastName} ${student.patronymic}"/></a></td><td><c:out value="${student.email}"/></td>
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
