<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
            <%@ include file="/WEB-INF/view/style/main.css"%>

            /* Current file styles */
            .register, .navigation-menu {
                width: 400px;
            }
            table, td, th {
                border: none;
            }
        </style>
    </head>
    <body>
        <h1>Register</h1>
        <hr>
        <div class="register">
            <form method="POST" action="${pageContext.request.contextPath}/register">
                <table>
                    <tr>
                        <td>First name</td>
                        <td><input type="text" name="firstName" placeholder="Enter first name"/></td>
                    </tr>
                    <tr>
                        <td>Last name</td>
                        <td><input type="text" name="lastName" placeholder="Enter last name"/></td>
                    </tr>
                    <tr>
                        <td>Patronymic</td>
                        <td><input type="text" name="patronymic" placeholder="Enter patronymic"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" placeholder="Enter email"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="Enter password"/></td>
                    </tr>
                    <tr>
                        <td>Confirm password</td>
                        <td><input type="password" name="confirm" placeholder="Confirm password"/> </td>
                    </tr>
                    <tr>
                        <td colspan="2">
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
