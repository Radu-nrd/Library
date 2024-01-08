package com.library.library;

import datatypes.BookPhotoDto;
import ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;


@WebServlet(name = "BookPhotos", value = "/BookPhotos")
public class BookPhotos extends HttpServlet {
    @Inject
    BooksBean booksBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer bookId = Integer.parseInt(request.getParameter("id"));
        BookPhotoDto photo = booksBean.findPhotoByBookId(bookId);
        if(photo != null){
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFilecontent().length);
            response.getOutputStream().write(photo.getFilecontent());
        } else {
            request.setAttribute("mesaj1","nu-i bn");
            request.setAttribute("mesaj2",bookId);
            request.getRequestDispatcher("ceva.jsp").forward(request,response);
            //response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
