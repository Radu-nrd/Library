package com.library.library;

import ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteBook", value = "/DeleteBook")
public class DeleteBook extends HttpServlet {
    @Inject
    BooksBean booksBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId= Long.parseLong(request.getParameter("book_id"));
        booksBean.deleteBookById(bookId);
        response.sendRedirect(request.getContextPath()+"/Home");

    }
}