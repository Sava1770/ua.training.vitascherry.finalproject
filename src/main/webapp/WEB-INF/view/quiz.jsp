<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test <c:out value="${requestScope.quiz.id}"/></title>
    </head>
    <body>
        <h1><c:out value="${requestScope.quiz.name}"/></h1>
        <hr>
        <ul>
            <li>
                <c:forEach var="question" items="${requestScope.quiz.questions}" varStatus="outer">
                    <c:out value="${outer.index}. "/><c:out value="${question.text}"/>
                    <ul>
                        <li>
                            <c:forEach var="answer" items="${question.answers}" varStatus="inner">
                                <c:out value="${inner.index}."/><c:out value="${answer.text}"/><input id="checkBox" type="checkbox">
                            </c:forEach>
                        </li>
                    </ul>
                </c:forEach>
            </li>
        </ul>
        <hr>
        <a href="${pageContext.request.contextPath}/WEB-INF/view/index.jsp">Main page</a>
    </body>
</html>
