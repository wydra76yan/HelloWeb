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
    <title><%=HiWeb.getMessage(1,"lector")%></title>
</head>
<body>
<div align="center">
    <h2><a href="/index.jsp">return to homepage!</a></h2>
    <br>
    <h2><%=HiWeb.getMessage(1,"lector")%></h2>
    <br>

    <table border="1">
    <c:forEach items="${lects}" var="onelist">
        <tr>
            <form action="/MainLoginm" method="post">
                <td> <input name="id" value="${onelist.id}" type="text" width="0"> </td>
                <td> <c:out value="${onelist.n_course}"></c:out> </td>
                <td> <c:out value="${onelist.sfio}"></c:out> </td>
                <td> <input name="nmark" value="${onelist.mark}" type="text" width="5"> </td>
                <td> <input name="pass" value="${pass}" type="hidden">
                     <input name="login" value="${login}" type="hidden">
                     <input type="submit" value="Подтвердить"> </td>
            </form>
      </tr>
    </c:forEach>
    </table>
</div>

</body>
</html>
