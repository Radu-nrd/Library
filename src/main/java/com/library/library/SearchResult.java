package com.library.library;

import datatypes.BookDto;
import ejb.BooksBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_BOOKS"}))
@WebServlet(name = "SearchResult", value = "/SearchResult")
public class SearchResult extends HttpServlet {
    @Inject
    BooksBean booksBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("searchInput");
        List<BookDto> books = booksBean.getBooksDtoAfterSearchKey(searchText);
        request.setAttribute("books",books);
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
