<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>add product page</title>
</head>
<body>
    <h1>adding user</h1>
    <form method="get" action="/processedproduct">
      <div>
      <label>name</label>
      <input type="text" name="name">
    </div>
    <div>
          <label>price</label>
          <input type="number" name="price">
    </div>
    <button type="submit">Add product</button>
    </form>
</body>
</html>