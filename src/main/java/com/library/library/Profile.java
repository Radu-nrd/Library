package com.library.library;

import datatypes.BookBorrowDto;
import datatypes.UserDto;
import ejb.BorrowBean;
import ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Profile", value = "/Profile")
public class Profile extends HttpServlet {
    @Inject
    BorrowBean borrowBean;

    @Inject
    UserBean userBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getUserPrincipal().getName();
        UserDto user = userBean.findUserDataByUsername(username);
        List<BookBorrowDto> books = borrowBean.findAllBooksByStatusFromUser(username,"borrowed");
        request.setAttribute("user",user);
        request.setAttribute("borrows",books);
        request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}