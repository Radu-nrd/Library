<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .onMiddle{
        height: 90vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<t:pageTemplate>
    <div class="container mt-4 onMiddle">
        <div class="row">
            <div class="col-md-6">
                <img src="${pageContext.request.contextPath}/BookPhotos?id=${book.bookId}" class="img-fluid" alt="Book Image">
            </div>
            <div class="col-md-6">
                <h2>${book.title}</h2>
                <p><strong>Author:</strong>${book.author}</p>
                <p><strong>Description:</strong>${book.description}</p>
                <p><strong>Genre:</strong>${book.genre}</p>
               <div class="btn-group">
                   <form method="post" action="${pageContext.request.contextPath}/BorrowBook">
                       <input type="hidden" value="${book.bookId}" name="book_id">
                       <button type="submit" class="btn btn-outline-primary">Borrow</button>
                   </form>
                   <br>
                   <form method="post" action="DeleteBook">
                       <input type="hidden" value="${book.bookId}" name="book_id">
                       <button type="submit" class="btn btn-outline-primary">Delete</button>
                   </form>
                   <br>
                   <div>
                       <button type="submit" class="btn btn-outline-primary" onclick="redirectToPage('${pageContext.request.contextPath}/EditBook?id=${book.bookId}')">Edit Book</button>
                   </div>
               </div>
            </div>
        </div>
    </div>
</t:pageTemplate>
<script>
    function redirectToPage(page){
        window.location.href = page;
    }
</script>