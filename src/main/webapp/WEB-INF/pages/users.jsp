<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
   <div class="homebody">
       <table>
           <thead>
           <tr>
               <th>User Name</th>
               <th>First Name</th>
               <th>Last Name</th>
               <th>Email</th>
           </tr>
           </thead>
           <tbody>
           <c:forEach var="user" items="${users}">
               <tr class="clickable-row table-row" onclick="redirectToPage('${pageContext.request.contextPath}/UserDetails?id=${user.userId}')">
                   <td>${user.userName}</td>
                   <td>${user.firstName}</td>
                   <td>${user.lastName}</td>
                   <td>${user.email}</td>

               </tr>
           </c:forEach>

           </tbody>
       </table>
   </div>
</t:pageTemplate>
<script>
    function redirectToPage(page){
        window.location.href = page;
    }
</script>