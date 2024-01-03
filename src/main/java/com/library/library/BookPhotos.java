package com.library.library;

import java.io.*;

import datatypes.BookPhotoDto;
import ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "BookPhotos", value = "/BookPhotos")
public class BookPhotos extends HttpServlet {
    /*
    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServlet request, HttpServletResponse response) throws IOException, ServletException {
        Integer bookId = Integer.parseInt(request.getParameter("id"));
        BookPhotoDto photo = booksBean.findPhotoByBookId(bookId);
        if(photo != null){
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFilecontent().length);
            response.getOutputStream().write(photo.getFilecontent());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    */
}
