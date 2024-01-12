<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Book">
    <div class="container">
        <h1>Edit book</h1>
        <form action="EditBook" method="post">
            <input type="hidden" name="book_id" value="${book.bookId}" id="book_id"/>
            <div class="form-group">
                <label for="author">Author:</label>
                <input type="text" class="form-control" id="author" name="author" value="${book.author}">
                <div class="invalid-feedback">Author is required</div>
            </div>

            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" name="title" value="${book.title}">
                <div class="invalid-feedback">Title is required</div>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" name="description" rows="4">${book.description}</textarea>
                <div class="invalid-feedback">Description is required</div>
            </div>

            <div class="form-group">
                <label for="genre">Genre:</label>
                <input type="text" class="form-control" id="genre" name="genre" value="${book.genre}">
                <div class="invalid-feedback">Genre is required</div>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</t:pageTemplate>