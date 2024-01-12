<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <div class="homebody">
        <c:forEach var="user" items="${users}">
            <div class="row">
                <div class="col">
                        ${user.userName}
                </div>
                <div class="col">
                        ${user.firstName}
                </div>
                <div class="col">
                        ${user.lastName}
                </div>
                <div class="col">
                        ${user.email}
                </div>
                <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
                    <div class="col">
                        <form method="post" action="editUser">
                            <input type="hidden" name="userId" value="${user.userId}">
                            <button type="submit" class="search-button">Edit Role</button>
                        </form>
                    </div>
                    <div class="col">
                        <form method="post" action="deleteUserServlet" onsubmit="return confirm('Are you sure you want to delete this user?');">
                            <input type="hidden" name="userId" value="${user.userId}">
                            <button type="submit" class="search-button">Delete</button>
                        </form>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </div>
</t:pageTemplate>