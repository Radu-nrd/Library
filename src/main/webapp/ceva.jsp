<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Home">
    <p>carte cu id: ${idCarte}</p>
    <p>User cu id : ${idUserName}</p>

    <form method="post" action="${pageContext.request.contextPath}/hello-servlet">
        <input type="hidden" value="${idCarte}" name="id_carte" id="id_carte">
        <button type="submit">Borrow</button>
    </form>
</t:pageTemplate>