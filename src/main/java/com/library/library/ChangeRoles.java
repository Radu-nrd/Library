package com.library.library;

import datatypes.UserDto;
import ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ChangeRoles", value = "/ChangeRoles")
public class ChangeRoles extends HttpServlet {
    @Inject
    UserBean userBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        UserDto user = userBean.getUserById(userId);
        request.setAttribute("user",user);
        List<String> roles = Arrays.asList("READ_BOOK","WRITE_BOOK","READ_USERS","WRITE_USERS");
        request.setAttribute("userGroups",roles);
        request.getRequestDispatcher("/WEB-INF/pages/changeRoles.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("user_id"));
        String[] userGroups = request.getParameterValues("user_groups");
        userBean.assignGroupsToUser(userId,Arrays.asList(userGroups));
    }
}