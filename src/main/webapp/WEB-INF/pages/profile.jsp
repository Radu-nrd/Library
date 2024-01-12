<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .onMiddle{
        align-items: center;
    }
    .center{
        text-align: center;
        min-width: 300px;
    }

    .userSide{
        display: flex;
        align-items: center;
    }
</style>

<t:pageTemplate pageTitle="Profile">
    <div class="forTemplate">
        <div class="container mt-4 ">
            <div class="row">
                <div class="col-md-6 userSide">
                    <div>
                        <h2 class="center">User Profile</h2>
                        <hr>
                        <p> <strong>First Name: </strong>${user.firstName}</p>
                        <p> <strong>Last Name: </strong>${user.lastName}</p>
                        <p><strong>Username:</strong> ${user.userName}</p>
                        <p><strong>Address:</strong> ${user.address}</p>
                    </div>
                </div>
                <div class="col-md-6" id="borrowTable">
                    <h2>Borrowed Books</h2>
                    <div class="row">
                        <div class="col">
                            Book Photo
                        </div>
                        <div class="col">
                            Book Title
                        </div>
                        <div class="col">
                            Author
                        </div>
                        <div class="col">
                            Date
                        </div>
                        <div class="col">

                        </div>
                    </div>
                    <c:forEach var="borrow" items="${borrows}">
                        <div class="row onMiddle">
                            <div class="col">
                                <img src="${pageContext.request.contextPath}/BookPhotos?id=${borrow.bookId}" width="75px" height="75px"/>
                            </div>
                            <div class="col">
                                    ${borrow.bookTitle}
                            </div>
                            <div class="col">
                                    ${borrow.bookAuthor}
                            </div>
                            <div class="col">
                                    ${borrow.borrowDate}
                            </div>
                            <div class="col">
                                <form action="#" method="get">
                                    <input type="hidden" name="borrow_id" value="${borrow.borrowId}">
                                    <button type="submit" class="btn btn-secondary">Return</button>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>