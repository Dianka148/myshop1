<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category manager</title>
</head>
<body>

<header style="width: 100%; height: 100px; background: gainsboro; margin-top: 0; margin-bottom: 1%; font-family:'Ubuntu Condensed', sans-serif;">
    <h1 style="text-align: center; color: darkred">Панель адміністрування</h1>
    <p style="text-align: center;">
        <a href="#" style="text-decoration: none; color: black;">Керування категоріями </a>
        <b style="margin-left:10px; margin-right: 10px">|</b>
        <a href="#" style="text-decoration: none; color: black;">Керування товаром</a>
    </p>

</header>
<div style="float: left; margin-right: 20%; margin-left: 2%; font-size: 20px;  border: 1px solid cadetblue; padding: 10px">
Створіть нову категорію:
<form action="/add-category" method="get">
    <input type="text" name="categoryName" placeholder="Введіть сюди назву категорії" style="width: 250px">
    <input type="submit" value="Зберегти">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</div>
<div style="float: left; font-size: 20px;  border: 1px solid darkred; padding: 10px">
Видалення категорій:
<c:forEach items="${categories}" var="category">
    <form action="/delete-category-${category.id}" method="get" style="color: #00748f; ">
        ${category.categoryName}
        <input type="submit" value="Видалити">
    </form>
</c:forEach>
</div>
</body>
</html>
