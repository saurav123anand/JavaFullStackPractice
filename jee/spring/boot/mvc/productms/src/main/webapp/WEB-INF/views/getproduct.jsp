<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>get user page</title>
</head>
<body>
    <h1>this is getUser page</h1>
     <form method="get" action="/productdetails">
         <div>
          <label>id</label>
          <input type="number" name="id">
        </div>
        <button type="submit">find product</button>
     </form>
</body>
</html>