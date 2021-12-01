<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 01/12/2021
  Time: 15.12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged!</title>
</head>
<body>
${sessionScope.user.name}
<br>
${sessionScope.user.email}
<br>
</body>
</html>
