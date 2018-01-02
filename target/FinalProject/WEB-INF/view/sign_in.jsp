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
            .sign-in, .navigation-menu {
                width: 400px;
            }
            table, td, th {
                border: none;
            }
        </style>
    </head>
    <body>
        <h1>Sign In</h1>
        <hr>
        <div class="sign-in">
            <form method="POST" action="${pageContext.request.contextPath}/signin">
                <table>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" placeholder="Enter email" value=""/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="Enter password" value=""/></td>
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
        <div class="navigation-menu">
            <nav>
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </nav>
        </div>
    </body>
</html>
