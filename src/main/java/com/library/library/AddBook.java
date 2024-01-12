package com.library.library;

import ejb.BooksBean;
import entities.BookPhoto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.IOException;


@MultipartConfig
@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBook extends HttpServlet {

    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String genre = request.getParameter("genre");
        //byte[] photo = request.getParameter("photo").getBytes();

        Part filePart = request.getPart("photo");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        booksBean.createBook(author,title,description,genre);

        Long bookId = booksBean.getBookId(author,title,description,genre);

        booksBean.addPhotoToBook(bookId,fileName,fileType,fileContent);

        response.sendRedirect(request.getContextPath()+"/Home");
    }

}