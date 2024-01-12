package com.library.library;

import datatypes.BookDto;
import ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookData", value = "/BookData")
public class BookData extends HttpServlet {
    @Inject
    BooksBean booksBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId= Long.parseLong(request.getParameter("id"));
        BookDto book= booksBean.findById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/WEB-INF/pages/bookDetails.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}