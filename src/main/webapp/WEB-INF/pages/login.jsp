<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logining page</title>
</head>
<body>
<h>Введіть свій логін та пароль</h>
<c:url var="xxx" value="/login"/>
<form action="${xxx}" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="login">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <c:if test="${param.error!=null}">
        <p>Невірний логін або пароль</p>
    </c:if>
    <c:if test="${param.logout!=null}">
        <p>Ви успішно вийшли з сторінки адміністрування сайту</p>
    </c:if>
</form>
</body>
</html>
