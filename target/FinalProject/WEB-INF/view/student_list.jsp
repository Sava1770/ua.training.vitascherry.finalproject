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
            .students table {
                width: 100%;
                border-color: rgba(15, 13, 14, 0.50);
                margin: 1em 0 1em 0;
            }
            table td, table th {
                text-align: left;
            }
            .main-page-href {
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
                    <th>#</th><th>Email</th><th>First name</th><th>Last name</th>
                </tr>
                <c:forEach var="student" items="${requestScope.students}">
                    <tr class="student-info">
                        <td><c:out value="${student.id}"/></td><td><c:out value="${student.email}"/></td><td><c:out value="${student.firstName}"/></td><td><c:out value="${student.lastName}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <hr>
        <div class="main-page-href">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
