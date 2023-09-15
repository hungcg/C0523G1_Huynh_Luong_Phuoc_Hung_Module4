<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/1/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        h1,h2{
            text-align: center;
        }
    </style>
    <h1>Calculator</h1>
</head>
<body>
<form action="/calculator/calculate" method="post" style="text-align: center">
    <input required type="number" name="number1">
    <input required type="number" name="number2">
    <hr style="width: 50%;">
    <br>
    <input type="submit" name="calculate" value="+">
    <input type="submit" name="calculate" value="-">
    <input type="submit" name="calculate" value="*">
    <input type="submit" name="calculate" value="/">
</form>

<c:if test="${result!=null}">
    <h2>${result}</h2>
</c:if>
<c:if test="${result=null}">
    <h2>${error}</h2>
</c:if>
</body>
</html>