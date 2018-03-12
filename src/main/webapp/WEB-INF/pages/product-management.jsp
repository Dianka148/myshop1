<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add product page</title>
</head>
<body>

At this page u can add some products to your web-site

<form action="/add-product" method="post" enctype="multipart/form-data">
    <input type="text" name="nameprod" placeholder="введіть назву товару">
    <br>
    <input type="file" name="files" value="Виберіть зображення" multiple accept="image/**">
    <br>
    <input type="number" name="price" value="0">
    <br>
    Товар на знижці?
    <br>
    <input name="isDiscount" type="radio" value="true" onclick="undisable()" > Так
    <input name="isDiscount" type="radio" value="false" onclick="disable()" checked="checked"> Ні
    <script>
        function disable() {
            document.getElementById("discountInput").value = "0";
            document.getElementById("discountInput").disabled = true;
        }

        function undisable() {
            document.getElementById("discountInput").disabled = false;
        }
    </script>
    <br>
    <input disabled id = "discountInput" type = "number" name = "discount" value="0" >
    <br>
    <input type = "text" name="description" placeholder="Введіть опис тут" >
    <br>
    Товар має якусь стрічку?
    <br>
    <input name="isTaged" type="radio" value="true" onclick="undisabled()"> Так
    <input name="isTaged" type="radio" value="false" onclick="disabled()" checked="checked"> Ні
    <script>
        function disabled() {
            // document.getElementById("tab1"). = "";
            document.getElementById("tab1").disabled = true;
        }

        function undisabled() {
            document.getElementById("tab1").disabled = false;
        }
    </script>
    <br>
        <input disabled id ="tab1" type="text" name="tab" placeholder="введість сюди надпис" >

    <br>
    Товар в наявності?
    <br>
    <input name="isInStock" type="radio" value="true" checked="checked"> Так
    <input name="isInStock" type="radio" value="false"> Ні
    <br>
    В товару є варіації?
    <br>
    <input name="isOptionAvailable" type="radio" value="true"> Так
    <input name="isOptionAvailable" type="radio" value="false" checked="checked"> Ні
    <br>
    <input name="options" type="text" placeholder="введіть варіації через кому.">
    <br>
    Товар належить до наступних категорій (якщо не належить до жодної, то не відображається на сайті)
    <br>
    <c:forEach items="${categories}" var="category">
        <input type="radio" name="categories" value="${category.id}"> ${category.categoryName}
    </c:forEach>
    <br>
    <input type="submit" value="Зберегти">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

</form>
<br>
<br>
<br>
<br>
<br>
<c:forEach items="${products}" var="prod">
    <br>
    -------------------------------------------<br>
    НАЗВА:<c:out value=" ${prod.productName}"/>
    <c:forEach items="${prod.photoList}" var="photo">
        <br>
    <img src="${photo.pathToPhoto}" alt="${photo.id}">
        <br>
    </c:forEach>
    ЦІНА ТА ЗНИЖКА: ${prod.price} AND ${prod.discount}
    <br>
    СТРІЧКА: ${prod.tab}
    <br>
    ОПИС: ${prod.description}
    <br>
    <c:forEach items="${prod.productOptions}" var="options">
        <br>
        ОПЦІЯ: ${options.optionName}
        <br>
    </c:forEach>
    <br>
    <form action="/edit-product" method="get">
        <input type="submit" value="Редагувати">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    <form action="/delete-product-${prod.id}" method="post">
        <input type="submit" value="Видалити">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
    -------------------------------------------<br>
</c:forEach>

</body>
</html>
