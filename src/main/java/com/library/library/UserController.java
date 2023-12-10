package com.library.library;

import datatypes.UserDetails;
import ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userController", value = "/User")
public class UserController extends HttpServlet {

    @Inject
    UserBean userBean;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //UserDetails userDetails = userBean.getUser();
        //request.setAttribute("unMesaj","username: " + userDetails.getUserName());
        //request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}
