<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/18/2023
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mail" action="save" method="post">
    <table>
        <h1>Settings</h1>
        <tr>
            <td>Language</td>
            <td><form:select path="language">
                <form:option value="" label="select"/>
                <form:options items="${languageList}"/>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size</td>
            <td><form:select path="pageSize">
                <form:options items="${pageSizeList}"/>
            </form:select></td>
        </tr>
        <tr>
            <td>Spam filter</td>
            <td>
                <form:checkbox value="Enable spam filters" path="spamFilter"/>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">OK</button>
            </td>
        </tr>
    </table>
    <br>
</form:form>
<c:if test="${message!=null}">
    <p style="color: brown"> ${message}</p>
</c:if>
<br>
<a style="text-decoration: none; font-weight: bold" href="result">Show setting</a>
</body>
</html>
