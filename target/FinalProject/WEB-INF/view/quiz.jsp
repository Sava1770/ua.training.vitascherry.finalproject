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
            ul {
                list-style-type: none;
                width: 100%;
                margin: 1em 0 1em 0;
            }
            .answers {
                width: 100%;
                margin-bottom: 1em;
            }
            .question-text {
                width: 100%;
                font-weight: bold;
            }
            .answer-text {
                padding-left: 1em;
            }
            .answer-text:after {
                display: block;
                content: "";
                clear: both;
            }
            .picker {
                float: right;
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
        <h1><c:out value="${requestScope.quiz.name}"/></h1>
        <hr>
        <div class="questions">
            <ul>
                <c:forEach var="question" items="${requestScope.quiz.questions}" varStatus="outer">
                    <li class="question-text">
                        <c:out value="${outer.index + 1}. "/><c:out value="${question.text}"/>
                    </li>
                    <div class="answers">
                        <c:forEach var="answer" items="${question.answers}" varStatus="inner">
                            <li class="answer-text">
                                <c:out value="${inner.index + 1}. "/><c:out value="${answer.text}"/><input class="picker" type="checkbox">
                            </li>
                        </c:forEach>
                    </div>
                </c:forEach>
            </ul>
        </div>
        <hr>
        <div class="main-page-link">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
