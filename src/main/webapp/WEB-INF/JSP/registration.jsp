<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Registration page</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Registration page</h1>

<p>
    <c:if test="${error == true}">
        <b class="error"></b>
    </c:if>
</p>
<form:form method="post" action="/registration" commandName="userForm" >
    <table>
        <tbody>
        <tr>
            <td>FirstName:</td>
            <td><form:input path="firstname" type="text" name="firstname" id="firstname" size="30" maxlength="40"  /></td>
            <td><form:errors path="firstname" cssClass="error"/></td>
        </tr>
        <tr>
            <td>LastName:</td>
            <td><form:input path="lastname" type="text" name="lastname" id="lastname" size="30" maxlength="40"  /></td>
            <td><form:errors path="lastname" cssClass="error"/></td>
        </tr>
        <tr>
             <td>Username:</td>
             <td><form:input path="username" type="text" name="username" id="username" size="30" maxlength="80" /></td>
             <td><form:errors path="username" cssClass="error"/></td>
        </tr>
        <tr>
             <td>Password:</td>
             <td><form:input path="password" type="password" name="password" id="password" size="30" maxlength="32" /></td>
             <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Register" /></td>
        </tr>
        </tbody>
    </table>
</form:form>

</body>
</html>
