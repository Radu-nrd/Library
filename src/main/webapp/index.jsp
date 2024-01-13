<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome to the Library</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    .container {
      text-align: center;
    }

    h1 {
      color: #333;
    }

    button {
      padding: 10px 20px;
      font-size: 16px;
      background-color: #3498db;
      color: #fff;
      border: none;
      cursor: pointer;
      border-radius: 5px;
    }

    button:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Welcome to the Library</h1>
  <button onclick="redirectToPage('${pageContext.request.contextPath}/Login')">Login</button>
  <c:if test="${pageContext.request.isUserInRole('READ_BOOKS')}">
    <button onclick="redirectToPage('${pageContext.request.contextPath}/Home')">Home</button>
  </c:if>
</div>
</body>
<script>
  function redirectToPage(page){
    window.location.href = page;
  }
</script>
</html>

