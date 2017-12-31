<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .login {
                width: 600px;
            }
            form {
                width: 100%;
                margin: 1em 0 1em 0;
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
