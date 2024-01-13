<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="User Details">
    <div class="container-fluid">
        <div>
            <h2 class="center">User Profile</h2>
            <hr>
            <p> <strong>First Name: </strong>${user.firstName}</p>
            <p> <strong>Last Name: </strong>${user.lastName}</p>
            <p><strong>Username:</strong> ${user.userName}</p>
            <p><strong>Address:</strong> ${user.address}</p>
            <p><strong>Groups:</strong> ${groups}</p>
            <br>
            <div class="btn-group">
                <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
                    <a class="btn btn-outline-primary mx-1" href="${pageContext.request.contextPath}/ChangeRoles?id=${user.userId}">Change roles</a>
                    <form action="DeleteUser" method="POST">
                        <input type="hidden" value="${user.userId}" name="user_id">
                        <button class="btn btn-outline-primary mx-1" type="submit">Delete</button>
                    </form>
                </c:if>
            </div>
        </div>
    </div>

</t:pageTemplate>