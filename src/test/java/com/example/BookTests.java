package com.example;

import datatypes.BookDto;
import ejb.BooksBean;
import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookTests {

    EntityManager emMock;
    BooksBean booksBean;

    @BeforeEach
    public void setup(){
        emMock = Mockito.mock(EntityManager.class);
        booksBean = new BooksBean();
        booksBean.SetEntityManager(emMock);
    }

   @Test
   public void testGetAllBooks(){

       Book book1 = new Book(1L,"Ion Creanga","Harap alb","dadada","Basm");
       Book book2 = new Book(2L,"Mihai Eminescu","Floarea albastra","nununu","poezie");
       List<Book> books = Arrays.asList(book1,book2);

       TypedQuery<Book> typedQuery = Mockito.mock(TypedQuery.class);
       when(typedQuery.getResultList()).thenReturn(books);

       when(emMock.createQuery("SELECT b FROM Book b",Book.class)).thenReturn(typedQuery);

       List<BookDto> trueAllBooks = booksBean.findAllBooks();
       assertEquals(2,trueAllBooks.size());

   }

   @Test
   public void testUpdateBook(){
        Long bookId = 1L;
        //Book book1 = new Book(bookId,"Ion Creanga","Harap alb","dadada","Basm");
        Book book1 = mock(Book.class);
        when(emMock.find(Book.class, bookId)).thenReturn(book1);
        booksBean.updateBook(bookId,"Ion Creanga","Amintiri din copilarie","nununu","ceva");

        verify(book1).setAuthor("Ion Creanga"); //verifica daca a fost executata linia asta
        verify(book1).setTitle("Amintiri din copilarie");
        verify(book1).setDescription("nununu");
        verify(book1).setGenre("ceva");

       //Assertions.assertEquals(1L,book1.getBookID());
   }

   @Test
    public void testFindById(){
       Book book1 = new Book(1L,"Ion Creanga","Harap alb","dadada","Basm");
       when(emMock.find(Book.class, 1L)).thenReturn(book1);
       BookDto bookDto = booksBean.findById(1L);

       assertEquals(1L,bookDto.getBookId());
   }

   @Test
   public void testCreateBook(){

       booksBean.createBook("Ion Creanga","Harap alb","dadada","Basm");
       ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
       verify(emMock).persist(bookCaptor.capture());

       Book book1 = bookCaptor.getValue();

       Assertions.assertEquals("Ion Creanga",book1.getAuthor());
       Assertions.assertEquals("dadada",book1.getDescription());
       Assertions.assertEquals("Harap alb",book1.getTitle());
       Assertions.assertEquals("Basm",book1.getGenre());


   }




}
