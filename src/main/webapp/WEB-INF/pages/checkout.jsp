<%--
  Created by IntelliJ IDEA.
  User: Діма
  Date: 09.03.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>

<form action="/send-bill" method="post">
    <input type="number" name="id"> Ід продукта
    <input type="text" name="email" placeholder="type ur mail">
    <input type="submit" value="Checkout">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>



</body>
</html>
