<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image-repository</title>
</head>
<body>
here is a storage of local images
<form action="/add-image" method="post" enctype="multipart/form-data">
    <input type="file" name="image" placeholder="img" multiple accept="image/*" >
    <input type="submit" value="Завантажити фото">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<c:forEach items="${images}" var="image">
    <form action="/delete-${image.id}" method="post">
    <img src="${image.pathToImg}" alt="${image.id}">
    <input type="submit" value="Видалити зображення">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    </form>
</c:forEach>

</body>
</html>
