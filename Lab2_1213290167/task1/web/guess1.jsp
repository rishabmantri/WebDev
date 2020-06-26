<%--
  Created by IntelliJ IDEA.
  User: rishabmantri
  Date: 2/14/19
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color:red"> <% out.print(session.getAttribute("playerguess").toString());%></p>
<p style="color:black"> <% out.print(session.getAttribute("computerGuess").toString());%></p>
<p style="color:black"> <% out.print(session.getAttribute("computerGuessR").toString());%></p>
<%session.invalidate();%>
<form method="GET" action="player-servlet">
    <input type="Submit" value="Continue">
</form>
</body>
</html>
