<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test <c:out value="${requestScope.quiz.id}"/></title>
        <style>
            .questions {
                width: 640px;
                height: 100%;
            }
            table.question {
                width: 100%;
                margin: 1em 0 1em 0;
                border: 4px double rgba(15, 13, 14, 0.50);
            }
            table td, table th {
                text-align: left;
            }
            th.question-text {
                width: 100%;
                margin-bottom: 5px;
            }
            tr.answer-body {
                margin-left: 1em;
            }
            td.answer-text {
                width: 96%;
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
        <h1><c:out value="${requestScope.quiz.name}"/></h1>
        <hr>
        <div class="questions">
            <c:forEach var="question" items="${requestScope.quiz.questions}" varStatus="outer">
                <table class="question">
                    <tbody>
                        <tr class="question-body">
                            <th class="question-text"><c:out value="${outer.index + 1}. "/><c:out value="${question.text}"/></th>
                        </tr>
                        <c:forEach var="answer" items="${question.answers}" varStatus="inner">
                            <tr class="answer-body">
                                <td class="answer-text"><c:out value="${inner.index + 1}. "/><c:out value="${answer.text}"/></td><td class="answer-picker"><input type="checkbox"></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:forEach>
        </div>
        <hr>
        <div class="main-page-href">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
