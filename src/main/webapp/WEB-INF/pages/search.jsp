<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
Is it u ar looking for?
<c:forEach items="${results}" var="result">
    <br>
    ${result.productName}
    <br>
</c:forEach>
</body>
</html>
