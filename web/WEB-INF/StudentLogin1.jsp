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
    <title><%=HiWeb.getMessage(1,"student")%></title>
</head>
<body>
<div align="center">
    <h2><a href="/index.jsp">return to homepage!</a></h2>
    <br>
    <h2><%=HiWeb.getMessage(1,"student")%></h2>
    <br />
<table border="1">
    <tr>
        <td>п.п.</td>
        <td>Name of curse</td>
        <td>Name of Lecture</td>
        <td>Mark</td>
    </tr>
    <c:forEach items="${lects}" var="onelist">
        <tr>
            <td><c:out value="${onelist.ord}"></c:out> </td>
            <td><c:out value="${onelist.n_course}"></c:out></td>
            <td><c:out value="${onelist.fio}"></c:out></td>
            <td><c:out value="${onelist.mark}"></c:out></td>
        </tr>
    </c:forEach>
 </table>
    <br />

    <h2><%=HiWeb.getMessage(99,"Add to studing")%></h2>
    <br />
    <table border="1">
        <tr>
            <td>п.п.</td>
            <td>Name of curse</td>
            <td>action</td>
        </tr>
        <c:forEach items="${cours}" var="twolist">
            <tr>
                <form action="/MainLoginm" method="post">
                    <td><c:out value="${twolist.ord}"></c:out> </td>
                    <td><c:out value="${twolist.n_course}"></c:out></td>
                    <td><input name="pass" value="${pass}" type="hidden">
                        <input name="login" value="${login}" type="hidden">
                        <input name="pidcourse" value="${twolist.id_course}" type="hidden">
                        <input name="pidstud" value="${twolist.id_stud}" type="hidden">
                        <input value="Add to plan" type="submit">
                    </td>
                </form>
            </tr>
        </c:forEach>

    </table>

</div>

</body>
</html>
