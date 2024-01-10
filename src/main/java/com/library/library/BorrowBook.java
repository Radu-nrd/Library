package com.library.library;

import ejb.BooksBean;
import ejb.BorrowBean;
import entities.Book;
import entities.User;
import entities.UserBook;
import entities.UserGroup;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

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

        borrowBean.createUserBook(borrowBean.findUserByUsername(request.getParameter("username")),
                borrowBean.findBookById(id),
                borrowBean.getBorrowedDate());

        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request,response);
    }

}
