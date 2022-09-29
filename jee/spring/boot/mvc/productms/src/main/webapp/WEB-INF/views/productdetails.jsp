<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product profile</title>
</head>
<body>
    <h1>Product Profile</h1>
    <c:out value="${product.id}"/>
    <c:out value="${product.name}"/>
    <c:out value="${product.price}"/>
</body>
</html>