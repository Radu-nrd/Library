package com.library.library;

import datatypes.UserDto;
import ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_USERS"}))
@WebServlet(name = "UserDetails", value = "/UserDetails")
public class UserDetails extends HttpServlet {
    @Inject
    UserBean userBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Long id = Long.parseLong(request.getParameter("id"));
    UserDto user = userBean.getUserById(id);
    request.setAttribute("user",user);
    String userGroups = userBean.formatRoles(user.getUserName());
    request.setAttribute("groups",userGroups);
        request.getRequestDispatcher("/WEB-INF/pages/userDetails.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}