package com.library.library;

import ejb.BorrowBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig
@WebServlet(name = "BorrowBook", value = "/BorrowBook")
public class BorrowBook {

    @Inject
    BorrowBean borrowBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/BorrowBook.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));

        borrowBean.borrowBook(borrowBean.findUserByUsername(request.getParameter("username")),
                borrowBean.findBookById(id),
                borrowBean.getBorrowedDate());

        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request,response);
    }

}
