<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="margin: auto" border="1">
    <tr>
        <th>STT</th>
        <th>languages</th>
        <th>page size</th>
        <th>Spams filter</th>
        <th>signature</th>
    </tr>
    <c:forEach var="mail" items="${mailSettingList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${mail.language}</td>
            <td> ${mail.pageSize}</td>
            <td> ${mail.spamFilter}</td>
            <td> ${mail.signature}</td>
    </c:forEach>
    <tr>
        <td><a style="text-decoration: none; font-weight: bold" href="/">update</a></td>
    </tr>
</table>
</body>
</html>