<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="webutils.HiWeb" %>

<%--
  Created by IntelliJ IDEA.
  User: YanVydra
  Date: 14.05.2017
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of students</title>
</head>
<body>
<div align="center">
    <a href="/index.jsp">return to homepage!</a>
<br>
    <%=HiWeb.getMessage(0,"List of students")%>
<table border="1">
    <tr>
        <td> N </td>
        <td>FIO</td>
        <td>Login</td>
    </tr>
    <c:forEach items="${mystudents}" var="students">
        <tr>
            <td> ${students.id_stud} </td>
            <td><c:out value="${students.sfio}"></c:out></td>
            <td><c:out value="${students.slogin}"></c:out></td>
      </tr>
  </c:forEach>
</table>

    <br>
    <table>
        <form action="/StudRegistration" method="POST">
            <tr>
                <td> </td>
                <td colspan="1">FIO=<input name="sfio" type="text"> </td>
                <td colspan="1">Login=<input name="slogin" type="text"> </td>
                <td colspan="1">Pass=<input name="spass" type="text"> </td>
                <td> <input type="submit" value="Register"> </td>
            </tr>
        </form>
    </table>


</div>

</body>
</html>
