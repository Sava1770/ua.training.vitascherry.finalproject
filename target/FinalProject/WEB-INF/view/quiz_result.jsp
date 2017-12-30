<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/containsAnswer.tld" prefix="presence" %>
<%@ taglib uri="/WEB-INF/tag/getAnswer.tld" prefix="answers" %>
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
                margin: 1em 0 1em 0;
                width: 100%;
            }
            li {
                margin-bottom: 1em;
            }
            .question-text {
                width: 100%;
                font-weight: bold;
                margin-bottom: 5px;
            }
            .answers {
                padding-left: 1em;
            }
            .right {
                color: #00ff00;
            }
            .wrong {
                color: #ff0000;
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
        <h1><c:out value="Result"/></h1>
        <hr>
        <div class="questions">
            <ul>
                <c:forEach var="question" items="${requestScope.quiz.questions}" varStatus="outer">
                    <li>
                        <div class="question-text">
                            <c:out value="${outer.index + 1}. "/><c:out value="${question.text}"/>
                        </div>
                        <c:forEach var="answer" items="${question.answers}" varStatus="inner">
                            <div class="answers">
                                <div class="answer-text"><c:out value="${inner.index + 1}. "/><c:out value="${answer.text}"/>
                                    <c:if test="${presence:containsAnswer(answers:getAnswers(requestScope.result.questions, outer.index), answer)}">
                                        <c:choose>
                                            <c:when test="${answer.isCorrect == true}">
                                                <span class='right'>&#10004;</span>
                                            </c:when>
                                            <c:when test="${answer.isCorrect == false}">
                                                <span class='wrong'>&#10006;</span>
                                            </c:when>
                                        </c:choose>
                                    </c:if>
                                </div>
                            </div>
                        </c:forEach>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <hr>
        <div class="main-page-link">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
