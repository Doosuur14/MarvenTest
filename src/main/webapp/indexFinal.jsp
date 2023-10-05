<%--
  Created by IntelliJ IDEA.
  User: doosuur
  Date: 05.10.2023
  Time: 6:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.itis.User" %>
<%@ page import="java.util.List" %>
<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect("Login.jsp");
    }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Database Title</title>
</head>
<body>
<table id="database">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Phone Number</th>
    </tr>
    <%
        List<User> usersList = (List<User>) request.getAttribute("usersList");
        if (usersList != null && !usersList.isEmpty()) {
            for (User user : usersList) {
    %>
    <tr>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getPassword() %></td>
        <td><%= user.getMobile() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">No users found.</td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
