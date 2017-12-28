<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student list</title>
    </head>
    <body>
        <h1>Student list</h1>
        <hr>
        <table border="1">
            <tr><th>#</th><th>Email</th><th>First name</th><th>Last name</th></tr>
            <c:forEach var="student" items="${requestScope.students}">
            <tr><td><c:out value="${student.id}"/></td><td><c:out value="${student.email}"/></td><td><c:out value="${student.firstName}"/></td><td><c:out value="${student.lastName}"/></td></tr>
            </c:forEach>
        </table>
        <hr>
        <a href="${pageContext.request.contextPath}/WEB-INF/view/index.jsp">Main page</a>
    </body>
</html>
