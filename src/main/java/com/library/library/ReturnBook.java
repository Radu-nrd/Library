package com.library.library;

import ejb.BorrowBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ReturnBook", value = "/ReturnBook")
public class ReturnBook extends HttpServlet {
    @Inject
    BorrowBean borrowBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long borrowId= Long.parseLong(request.getParameter("borrow_id"));
        borrowBean.returnBook(borrowId);
        response.sendRedirect(request.getContextPath()+"/Profile");


    }
}