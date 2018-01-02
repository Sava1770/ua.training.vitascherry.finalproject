<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test <c:out value="${requestScope.quiz.id}"/></title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .questions {
                width: 600px;
                height: 100%;
            }
            .answers {
                padding-left: 1em;
            }
            .question-text {
                width: 100%;
                font-weight: bold;
            }
            .answer-text:after {
                display: block;
                content: "";
                clear: both;
            }
            .picker {
                float: right;
            }
        </style>
    </head>
    <body>
        <h1><c:out value="${requestScope.quiz.name}"/></h1>
        <hr>
        <div class="questions">
            <ul>
                <c:forEach var="question" items="${requestScope.quiz.questions}" varStatus="questionLoop">
                    <li>
                        <div class="question-text">
                            <c:out value="${questionLoop.index + 1}. "/><c:out value="${question.text}"/>
                        </div>
                        <div class="answers">
                            <c:forEach var="answer" items="${question.answers}" varStatus="answerLoop">
                                <div class="answer-text">
                                    <c:out value="${answerLoop.index + 1}. "/><c:out value="${answer.text}"/><input class="picker" type="checkbox">
                                </div>
                            </c:forEach>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </nav>
        </div>
    </body>
</html>
