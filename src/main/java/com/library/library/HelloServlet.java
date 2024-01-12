package com.library.library;

import java.io.*;

import ejb.BorrowBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@DeclareRoles({"READ_USERS","WRITE_USERS","READ_BOOKS","WRITE_BOOKS"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_BOOKS"}))
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Inject
    BorrowBean borrowBean;

    public void init() {
        message = "Hello World!";
    }


@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));
        Long idUserName = borrowBean.findUserByUsername(request.getUserPrincipal().getName()).getUserID();

        request.setAttribute("idCarte",id);
        request.setAttribute("idUserName",idUserName);
        request.getRequestDispatcher("ceva.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}