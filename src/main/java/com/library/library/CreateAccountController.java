package com.library.library;

import java.io.*;

import ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "createAccount", value = "/CreateAccount")
public class CreateAccountController extends HttpServlet {
    @Inject
    UserBean userBean;


    @Override
    public void init() {

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/pages/createacc.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");

        userBean.createUser(username,password,firstName,lastName,address,email);
        response.sendRedirect(request.getContextPath()+"/Login");
    }
    @Override
    public void destroy() {
    }
}
