<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/config/answer_tag_lib.tld" prefix="fn" %>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<fmt:setBundle basename="/i18n/quiz_result" var="bundle" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${bundle}" key="title" /> <c:out value="${requestScope.quiz.id}"/></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <style>
            .questions {
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
        <h1><c:out value="${requestScope.quiz.name}"/> <fmt:message bundle="${bundle}" key="result" /></h1>
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
                                        <c:if test="${fn:containsAnswer(fn:getAnswersOrEmpty(requestScope.result.questions, questionLoop.index), answer)}">
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
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${bundle}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
