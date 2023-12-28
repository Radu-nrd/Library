package com.library.library;

import java.io.*;

import Utility.Utils;
import datatypes.UserDetails;
import ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/Login")
public class LoginController extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    public void init() {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.logout();
        request.getSession().invalidate();
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = Utils.encryptPassword(request.getParameter("password"));

        UserDetails userDetails = userBean.getUser(username,password);
        if(userDetails!=null){
            request.getSession().setAttribute("userId",userDetails.getUserId());
        }
        else{
            request.setAttribute("infoMsg","Incorrect Username/Password");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        }

        response.sendRedirect(request.getContextPath()+"/Home");
    }
    @Override
    public void destroy() {
    }
}