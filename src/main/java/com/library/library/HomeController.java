package com.library.library;

import java.io.*;

import Utility.Utils;
import datatypes.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/Home")
public class HomeController extends HttpServlet {

    @Override
    public void init() {

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long connectedUserId = (Long) request.getSession().getAttribute("userId");
        if(connectedUserId==null)
            response.sendRedirect(request.getContextPath()+"/Login");
        else{
            request.setAttribute("unMesaj","Salut ai id-ul: " + connectedUserId);
            request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy() {
    }
}