<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student list</title>
        <style>
            .students {
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
        <h1>Student list</h1>
        <hr>
        <div class="students">
            <table cellpadding="1" border="1">
                <tr class="table-header">
                    <th>#</th><th>Full name</th><th>Email</th>
                </tr>
                <c:forEach var="student" items="${requestScope.students}">
                    <tr class="student-info">
                        <td><c:out value="${student.id}"/></td><td><a href="${pageContext.request.contextPath}/student/${student.id}"><c:out value="${student.firstName} ${student.lastName} ${student.patronymic}"/></a></td><td><c:out value="${student.email}"/></td>
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
