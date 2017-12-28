<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topic list</title>
    </head>
    <body>
        <h1>Topic list</h1>
        <hr>
        <table border="1">
            <tr><th>#</th><th>Name</th></tr>
            <c:forEach var="topic" items="${requestScope.topics}">
                <tr><td><c:out value="${topic.id}"/></td><td><c:out value="${topic.name}"/></td></tr>
            </c:forEach>
        </table>
        <hr>
        <a href="${pageContext.request.contextPath}/WEB-INF/view/index.jsp">Main page</a>
    </body>
</html>
