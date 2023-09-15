<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/14/2023
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Money</title>
</head>
<body>
<form action="exchange" method="post">
    <h3>Input USD</h3><br>

    <input type="number" value="0" name="usd" placeholder="input USD">
    <input type="submit" value="exchange">
</form>
<h2>VND = ${result}</h2>
</body>
</html>
