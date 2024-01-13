<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Change Roles">
  <div class="container-fluid">
    <form method="post" action="ChangeRoles">
      <h3>Change Roles</h3>
      <hr class="mb-4">
      <input type="hidden" value="${user.userId}" name="user_id">

      <p><strong>Username:</strong>${user.userName}</p>
      <p>Id: ${user.userId}</p>
      <div class="col-md-6">
        <label for="user_groups">Groups</label>
        <select class="custom-select d-block w-100" name="user_groups" id="user_groups"  multiple>
          <c:forEach var="userGroup" items="${userGroups}" varStatus="status">
            <option value="${userGroup}">${userGroup}</option>
          </c:forEach>
        </select>
      </div>
      <br>

      <button type="submit" class="btn btn-outline-primary">Save</button>
    </form>
  </div>
</t:pageTemplate>