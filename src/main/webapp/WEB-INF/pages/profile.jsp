<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>

    .center{
        text-align: center;
        min-width: 300px;
    }

    .divCentre{
        margin: 0 auto;
    }

    .onMiddle{
        align-items: center;
    }
    .divFlex{
        display: flex;
        justify-content: center;
    }
</style>

<t:pageTemplate pageTitle="Profile">
    <div class="col-md-6 divCentre">
        <h2 class="center">User Profile</h2>
        <hr>
        <div class="divFlex onMiddle">
            <div>
                <p> <strong>First Name: </strong>${user.firstName}</p>
                <p> <strong>Last Name: </strong>${user.lastName}</p>
                <p><strong>Username:</strong> ${user.userName}</p>
                <p><strong>Address:</strong> ${user.address}</p>
            </div>
        </div>
        <div>
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
                        <form action="ReturnBook" method="post">
                            <input type="hidden" name="borrow_id" value="${borrow.borrowId}">
                            <button type="submit" class="btn btn-secondary">Return</button>
                        </form>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </div>
        </div>
    </div>
</t:pageTemplate>