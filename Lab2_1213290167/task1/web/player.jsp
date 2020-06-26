<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.String" %>
<%@ page import="java.util.*" %>

<%--
  Created by IntelliJ IDEA.
  User: rishabmantri
  Date: 2/13/19
  Time: 1:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="POST" action="guess">
    <%
        ArrayList<String> suspectlist = (ArrayList<String>) session.getAttribute("suspectslist");
        ArrayList<String> weaponlist = (ArrayList<String>) session.getAttribute("weaponlist");
        ArrayList<String> roomlist = (ArrayList<String>) session.getAttribute("roomlist");

        for (int i = 0; i < suspectlist.size(); i++)
        {
            out.print(  suspectlist.get(i)+"," );
        }
        out.print("<BR>");
        for (int i = 0; i < roomlist.size(); i++)
        {
            out.print(  roomlist.get(i)+"," );
        }
        out.print("<BR>");
        for (int i = 0; i < weaponlist.size(); i++)
        {
            out.print(  weaponlist.get(i)+"," );
        }
        out.print("<BR>");
    %>
    <select id="suspect" name="suspect">
        <%
            ArrayList<String> playerRooms = (ArrayList<String>) session.getAttribute("playerRoomsList");
            ArrayList<String> playerSuspects = (ArrayList<String>) session.getAttribute("playerSuspectsList");
            ArrayList<String> playerWeapons = (ArrayList<String>) session.getAttribute("playerWeaponsList");

                    for (int i = 0; i < playerSuspects.size(); i++)
{
    out.print("<option value=\"" + playerSuspects.get(i) + "\">" + playerSuspects.get(i) + "</option>");
}%>

                    </select>
    </br>
    <select id="room" name="room">
   <% for (int i = 0; i < playerRooms.size(); i++)
    {
        out.print("<option value=\"" + playerRooms.get(i) + "\">" + playerRooms.get(i) + "</option>");
    }%>
        </select>
    </br>
    <select id="weapon" name="weapon">
    <% for (int i = 0; i < playerWeapons.size(); i++)
    {
        out.print("<option value=\"" + playerWeapons.get(i) + "\">" + playerWeapons.get(i) + "</option>");
    }%>
        </select>
    </br>

    <input type="submit" value="Submit"/>
    </form>

</body>
</html>
