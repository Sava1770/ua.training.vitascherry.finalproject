<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .login {
                width: 400px;
            }
        </style>
    </head>
    <body>
        <h1>Login</h1>
        <hr>
        <div class="login">
            <form method="POST" action="${pageContext.request.contextPath}/welcome">
                <table border="0">
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" placeholder="Enter email" value="${requestScope.user.email}"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="Enter password" value="${requestScope.user.password}"/></td>
                    </tr>
                    <tr>
                        <td>Remember me</td>
                        <td><input type="checkbox" checked="checked" name="remember" value="yes"/> </td>
                    </tr>
                    <tr>
                        <td colspan ="2">
                            <input type="submit" value="Submit"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <hr>
        <div class="main-page-link">
            <a href="${pageContext.request.contextPath}/">Main page</a>
        </div>
    </body>
</html>
