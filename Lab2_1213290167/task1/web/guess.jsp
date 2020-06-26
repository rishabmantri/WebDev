<%--
  Created by IntelliJ IDEA.
  User: rishabmantri
  Date: 2/13/19
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess</title>
</head>
<body>
<p style="color:red"> <% out.print(session.getAttribute("playerguess").toString());%></p>
<p style="color:black"> <% out.print(session.getAttribute("computerGuess").toString());%></p>
<p style="color:black"> <% out.print(session.getAttribute("computerGuessR").toString());%></p>
<form method="GET" action="player-servlet">
<input type="Submit" value="Continue">
</form>
</body>
</html>
