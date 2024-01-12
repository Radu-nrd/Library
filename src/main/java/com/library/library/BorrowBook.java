package com.library.library;

import ejb.BorrowBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BorrowBook", value = "/BorrowBook")
public class BorrowBook extends HttpServlet {

    @Inject
    BorrowBean borrowBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long bookId = Long.parseLong(request.getParameter("book_id"));
        borrowBean.borrowBook(borrowBean.findUserByUsername(request.getUserPrincipal().getName()),
                borrowBean.findBookById(bookId));

        response.sendRedirect(request.getContextPath()+"/Home");
    }

}
