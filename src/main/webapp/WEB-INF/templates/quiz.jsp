<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/i18n.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${particular}" key="quiz.title" /> <c:out value="${requestScope.quiz.id}"/></title>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <script src="/static/js/jquery-3.2.1.min.js"></script>
        <script src="/static/js/quiz.js"></script>
        <style>
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
            <form method="POST" action="${pageContext.request.contextPath}/result/${sessionScope.user.id}/${requestScope.quiz.id}" autocomplete="off" onsubmit="return validate();">
                <ul>
                    <c:forEach var="question" items="${requestScope.quiz.questions}" varStatus="questionLoop">
                        <li>
                            <div class="question-text">
                                <c:out value="${questionLoop.index + 1}. "/><c:out value="${question.text}"/>
                            </div>
                            <div class="answers">
                                <c:forEach var="answer" items="${question.answers}" varStatus="answerLoop">
                                    <div class="answer-text">
                                        <c:out value="${answerLoop.index + 1}. "/><c:out value="${answer.text}"/><input class="picker" type="checkbox" name="${question.id} ${answer.id}">
                                    </div>
                                </c:forEach>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <input type="submit" value="Submit"/>
            </form>
        </div>
        <hr>
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/"><fmt:message bundle="${common}" key="home" /></a>
            </nav>
        </div>
    </body>
</html>
