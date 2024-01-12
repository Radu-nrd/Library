package com.library.library;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/Login")
public class LoginController extends HttpServlet {

    //@Inject
    //UserBean userBean;

    @Override
    public void init() {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Username or password incorrect");
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
    }
    @Override
    public void destroy() {
    }
}