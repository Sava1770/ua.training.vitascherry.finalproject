<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student ${requestScope.student.id}</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .student {
                width: 400px;
                height: 100%;
            }
            .label-col {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1>Student ${requestScope.student.id}</h1>
        <hr>
        <div class="student">
            <table>
                <tr>
                    <td class="label-col">Full name:</td><td><c:out value="${requestScope.student.firstName} ${requestScope.student.lastName} ${requestScope.student.patronymic}"/></td>
                </tr>
                <tr>
                    <td class="label-col">Email:</td><td><c:out value="${requestScope.student.email}"/></td>
                </tr>
            </table>
        </div>
        <hr>
        <div class="main-page-link">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
