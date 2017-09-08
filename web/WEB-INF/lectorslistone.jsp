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
    <title>List of lectors</title>
</head>
<body>
<div align="center">
    <h2><a href="/index.jsp">return to homepage!</a></h2>
    <%=HiWeb.getMessage(3,"List of lectors")%>
    <br />
<table border="1">
    <tr>
        <td> Ord </td>
        <td>Last name (FIO)</td>
        <td>Login</td>
    </tr>
    <c:forEach items="${lecs}" var="onelist">
        <tr>
            <td> ${onelist.id_lec} </td>
            <td><c:out value="${onelist.fio}"></c:out></td>
            <td><c:out value="${onelist.llogin}"></c:out></td>
      </tr>
  </c:forEach>
</table>
<br>
    <%=HiWeb.getMessage(3,"Add lectors")%>
 <br>
 <table>
  <form action="/lectorslistone" method="POST">
      <tr>
           <td colspan="1">FIO=<input name="lfio" type="text"> </td>
          <td colspan="1">Login=<input name="llogin" type="text"> </td>
          <td colspan="1">Pass=<input name="lpass" type="text"> </td>
          <td> <input type="submit" value="Register"> </td>
      </tr>
  </form>
</table>
</div>

</body>
</html>
