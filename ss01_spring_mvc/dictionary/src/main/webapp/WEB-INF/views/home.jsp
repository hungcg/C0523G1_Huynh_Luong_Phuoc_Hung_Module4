<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/14/2023
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng từ điển</title>
</head>
<body>
<form method="post" action="home">
    <input type="text" name = "english">
    <input type="submit" value="translate">
</form>
<h1>${vietnamese!=null?vietnamese:message}</h1>

</body>
</html>
