<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topic list</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .topics {
                width: 600px;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <h1>Topic list</h1>
        <hr>
        <div class="topics">
            <table cellpadding="1" border="1">
                <tr class="table-header">
                    <th>#</th><th>Name</th>
                </tr>
                <c:forEach var="topic" items="${requestScope.topics}" varStatus="topicLoop">
                    <tr class="topic-info">
                        <td><c:out value="${topicLoop.index + 1}"/></td><td><a href="${pageContext.request.contextPath}/topic/${topic.id}"><c:out value="${topic.name}"/></a></td>
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
