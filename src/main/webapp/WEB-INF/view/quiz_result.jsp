<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/answer_tag_lib.tld" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test <c:out value="${requestScope.quiz.id}"/></title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .questions, .navigation-menu {
                width: 600px;
                height: 100%;
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
        </style>
    </head>
    <body>
        <h1><c:out value="${requestScope.quiz.name}"/> result</h1>
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
                                    <div class="answer-text"><c:out value="${answerLoop.index + 1}. "/><c:out value="${answer.text}"/>
                                        <c:if test="${fn:containsAnswer(fn:getAnswers(requestScope.result.questions, questionLoop.index), answer)}">
                                            <c:choose>
                                                <c:when test="${answer.isCorrect}">
                                                    <span class="right">&#10004;</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="wrong">&#10006;</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
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
                <a href="${pageContext.request.contextPath}/">Home</a>
            </nav>
        </div>
    </body>
</html>
