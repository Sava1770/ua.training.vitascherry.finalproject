<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student ${requestScope.student.id}</title>
        <style>
            .student {
                width: 600px;
                height: 100%;
            }
            table {
                width: 100%;
                margin: 1em 0 1em 0;
            }
            table td.l {
                font-weight: bold;
            }
            table td {
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
        <h1>Student ${requestScope.student.id}</h1>
        <hr>
        <div class="student">
            <table>
                <tr>
                    <td class="l">Full name:</td><td><c:out value="${requestScope.student.firstName} ${requestScope.student.lastName} ${requestScope.student.patronymic}"/></td>
                </tr>
                <tr>
                    <td class="l">Email:</td><td><c:out value="${requestScope.student.email}"/></td>
                </tr>
            </table>
        </div>
        <hr>
        <div class="main-page-link">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
