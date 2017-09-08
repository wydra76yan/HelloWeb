<%@ page import="webutils.HiWeb" %>
<%--
  Created by IntelliJ IDEA.
  User: YanVydra
  Date: 22.03.2017
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title> My page</title>
  </head>
  <body bgcolor="#a9a9a9">
  <div align="center">
    <%=HiWeb.getMessage(0,"Main page, please choise section and login:")%>
    <br />

  <table border="0">
    <tr>
      <td valign="top"  align="center">
        <h2>Form for Login</h2>
        <form action="/MainLoginm" method="post">
          <table><tr>
            <td colspan="0" align="end">
              Write login here <input name="login" type="text" size="20">   <br/>
              password  here <input name="pass" type="password" size="20">   <br/>
            </td>
            <td colspan="0" align="center">
              <input type="submit"  value="Login">
            </td>
          </tr></table>
        </form>
        <br/>
        <br/>
        <br/>
        Register here<br/>
        <br/>
       <a href="/lectorslistone">Full list lectors and registration!</a>
        <br/>
        <br/>
        <a href="/StudRegistration">Full List Students and registration!</a>
      </td>

    </tr>
  </table>

  </div>

  </body>
</html>
