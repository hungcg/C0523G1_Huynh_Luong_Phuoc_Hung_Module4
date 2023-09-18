
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<table style="margin: auto">
  <tr>
    <td><h2>Language: ${mail.language}</h2></td>
  </tr>
  <tr>
    <td><h2>Page Size: ${mail.pageSize}</h2></td>
  </tr>
  <tr>
    <td><h2>Spam Filter: ${mail.spamFilter}</h2></td>
  </tr>
  <tr>
    <td><h2>Signature: ${mail.signature}</h2></td>
  </tr>
  <tr>
    <td><a style="text-decoration: none; font-weight: bold" href="/">update</a></td>
  </tr>
</table>

</body>
</html>