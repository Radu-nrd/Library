<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
    <style>
        /* Basic styling for demonstration purposes */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 350px;
            width: 100%;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="submit"] {
            width: 100%;
            margin: 8px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .juma{
            display: flex;
            align-content: center;
            justify-content: space-between;
        }
        .text-center{
            text-align: center;
        }
        .jumaSide{
            width: 45%;
        }
        .juma label{
            display: block;
        }
        .w-100perc{
            width: 100%;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<form class="needs-validation" novalidate method="post" action="CreateAccount">
    <h2>Create Account</h2>
    <div class="juma">
        <div class="jumaSide">
            <label for="firstName" class="text-center w-100perc">First Name:</label>
            <input type="text" id="firstName" name="firstName" required>
            <div class="invalid-feedback">First Name is required</div>
        </div>
        <div class="jumaSide">
            <label for="lastName" class="text-center w-100perc">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>
            <div class="invalid-feedback">Last Name is required</div>
        </div>
    </div>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <div class="invalid-feedback">Username is required</div>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <div class="invalid-feedback">Password is required</div>
    <label for="email">Email Address:</label>
    <input type="email" id="email" name="email" required>
    <div class="invalid-feedback">Email is required</div>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required>
    <div class="invalid-feedback">Address is required</div>
    <input type="submit" value="Create Account">
</form>
<script src="${pageContext.request.contextPath}/form-validation.js"></script>
</body>
</html>
