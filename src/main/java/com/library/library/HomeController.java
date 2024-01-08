package com.library.library;

import java.io.*;
import java.util.List;

import Utility.Utils;
import datatypes.BookDto;
import datatypes.UserDetails;
import ejb.BooksBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/Home")
public class HomeController extends HttpServlet {

    @Inject
    BooksBean booksBean;

    @Override
    public void init() {

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<BookDto> books = booksBean.findAllBooks();

        //request.setAttribute("nume",request.getUserPrincipal().getName());
        request.setAttribute("books",books);
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy() {
    }
}