<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<h2>Menu today we have:</h2>
<c:forEach var="list" items="${condiment}">
   <h3 style="color: cornflowerblue">${list}</h3><br>
</c:forEach>
<br>
<button style="text-decoration: none;color: darkslategrey" href="index.jsp">Back to menu</button>
</form>
</body>
</html>
