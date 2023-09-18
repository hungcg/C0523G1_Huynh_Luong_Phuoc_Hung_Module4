<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/15/2023
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sandwich/save">

    <lable>Lettuce</lable>
    <input type="checkbox" name="condiment" value="lettuce">
    <lable>Tomato</lable>
    <input type="checkbox" name="condiment" value="tomato">
    <lable>Mustard</lable>
    <input type="checkbox" name="condiment" value="mustard">
    <lable>Sprouts</lable>
    <input type="checkbox" name="condiment" value="sprouts">
    <br>
    <input type="submit" value="save">
</form>
</body>
</html>
