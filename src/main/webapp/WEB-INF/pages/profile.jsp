<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Profile">
    <div class="forTemplate">
    <div class="container mt-4 ">
        <div class="row">
            <div class="col-md-6">
                <h2>User Profile</h2>
                <p><strong>Name:</strong> John Doe</p>
                <p><strong>Username:</strong> johndoe123</p>
                <p><strong>Address:</strong> 123 Main Street, City, Country</p>
                <button id="toggleBorrowTable" class="btn btn-primary">Toggle Borrow History</button>
            </div>
            <div class="col-md-6" id="borrowTable">
                <h2>Borrow History</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Book Title</th>
                        <th scope="col">Author</th>
                        <th scope="col">Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Metamorfoza</td>
                        <td>Franz Kafka</td>
                        <td>2023-01-15</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
</t:pageTemplate>