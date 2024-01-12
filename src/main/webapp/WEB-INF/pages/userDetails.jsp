<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="User Details">
    <div class="container-fluid">
        <div>
            <input type="hidden" value="${user.userId}">
            <h2 class="center">User Profile</h2>
            <hr>
            <p> <strong>First Name: </strong>${user.firstName}</p>
            <p> <strong>Last Name: </strong>${user.lastName}</p>
            <p><strong>Username:</strong> ${user.userName}</p>
            <p><strong>Address:</strong> ${user.address}</p>
            <p><strong>Groups:</strong> ${groups}</p>
            <br>
            <div class="btn-group">
                <form>
                    <a class="btn btn-primary btn-sm btn-block" href="changeRoles.jsp">Change roles</a>
                </form>
                <form action="DeleteUser" method="POST">
                    <input type="hidden" value="${user.userId}" name="user_id">
                    <button class="btn btn-primary btn-sm btn-block" type="submit">Delete</button>
                </form>
            </div>
        </div>
    </div>

</t:pageTemplate>