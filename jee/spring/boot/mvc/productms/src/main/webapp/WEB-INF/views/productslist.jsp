<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>products list page</title>
</head>
<body>
    <h1>All products</h1>
    <c:forEach items="${products}" var="product">
    <div>
       <c:out value="${product.id}"/>
       <c:out value="${product.name}"/>
       <c:out value="${product.price}"/>
    </div>
    </c:forEach>
</body>
</html>