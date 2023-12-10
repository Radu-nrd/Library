package com.library.library;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.setContentType("text/html");
        //request.setAttribute("unMesaj","DaDADA");
        //response.sendRedirect("home.jsp");
        // Hello
        //PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>" + message + "</h1>");
        //out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void destroy() {
    }
}