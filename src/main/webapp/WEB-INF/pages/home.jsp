<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Home">
    <div class="homebody">
        <c:if test="${pageContext.request.isUserInRole('smecher')}">
            <a class="search-button" href="${pageContext.request.contextPath}/Users">Users</a>
            <div>Te cheama ${nume}</div>
        </c:if>

        <table>
            <thead>
            <tr>
                <th>Book Cover</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Genre</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr class="clickable-row table-row" onclick="redirectToPage('${pageContext.request.contextPath}/BookDetails?id=1)')">
                    <td><img src="" alt="Book 1" class="book-image"></td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
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