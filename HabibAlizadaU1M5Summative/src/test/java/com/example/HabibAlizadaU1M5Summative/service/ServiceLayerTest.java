package com.example.HabibAlizadaU1M5Summative.service;

import com.example.HabibAlizadaU1M5Summative.dao.*;
import com.example.HabibAlizadaU1M5Summative.model.Author;
import com.example.HabibAlizadaU1M5Summative.model.Book;
import com.example.HabibAlizadaU1M5Summative.model.Publisher;
import com.example.HabibAlizadaU1M5Summative.viewmodel.BookViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    AuthorDao authorDao;
    BookDao bookDao;
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        setUpAuthorDaoMock();
        setUpBookDaoMock();
        setUpPublisherDaoMock();

        serviceLayer = new ServiceLayer(authorDao, bookDao, publisherDao);
    }


    @Test
    public void saveBook() {
        BookViewModel bookViewModel = new BookViewModel();

        bookViewModel.setIsbn("BK1234567");
        bookViewModel.setTitle("Life");

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Brooks");
        author.setStreet("1 N State");
        author.setCity("Chicago");
        author.setState("IL");
        author.setPostal_code("60660");
        author.setPhone("773-123-4444");
        author.setEmail("john@gmail.com");
        author = serviceLayer.saveAuthor(author);

        bookViewModel.setAuthor(author);

        bookViewModel.setPublish_date(LocalDate.of(1999, 05, 15));

        Publisher publisher = new Publisher();
        publisher.setName("US Publishing Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("Chicago");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");
        publisher = serviceLayer.savePublisher(publisher);

        bookViewModel.setPublisher(publisher);

        bookViewModel.setPrice(12.99);

        bookViewModel = serviceLayer.saveBook(bookViewModel);

        BookViewModel bookViewModelFromService = serviceLayer.findBook(bookViewModel.getId());

        assertEquals(bookViewModel, bookViewModelFromService);


    }

    private void setUpAuthorDaoMock(){
        authorDao = mock(AuthorDaoJdbcTemplateImpl.class);
        Author author = new Author();
        author.setAuthor_id(10);
        author.setFirst_name("John");
        author.setLast_name("Brooks");
        author.setStreet("1 N State");
        author.setCity("Chicago");
        author.setState("IL");
        author.setPostal_code("60660");
        author.setPhone("773-123-4444");
        author.setEmail("john@gmail.com");

        Author author2 = new Author();
        author2.setFirst_name("John");
        author2.setLast_name("Brooks");
        author2.setStreet("1 N State");
        author2.setCity("Chicago");
        author2.setState("IL");
        author2.setPostal_code("60660");
        author2.setPhone("773-123-4444");
        author2.setEmail("john@gmail.com");

        List<Author> authorList = new ArrayList<>();
        authorList.add(author);

        doReturn(author).when(authorDao).addAuthor(author2);
        doReturn(author).when(authorDao).getAuthor(10);
        doReturn(authorList).when(authorDao).getAllAuthor();
    }

    private void setUpBookDaoMock(){
        bookDao = mock(BookDaoJdbcTemplateImpl.class);
        Book book = new Book();
        book.setPublisher_id(1);
        book.setIsbn("BK12345678");
        book.setPublish_date(LocalDate.of(2010, 1, 5));
        book.setAuthor_id(45);
        book.setTitle("How to skimm your life");
        book.setPublisher_id(10);
        book.setPrice(12.99);

        Book book2 = new Book();
        book2.setPublisher_id(1);
        book2.setIsbn("BK12345678");
        book2.setPublish_date(LocalDate.of(2010, 1, 5));
        book2.setAuthor_id(45);
        book2.setTitle("How to skimm your life");
        book2.setPublisher_id(10);
        book2.setPrice(12.99);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        doReturn(book).when(bookDao).addBook(book2);
        doReturn(book).when(bookDao).getBook(1);
        doReturn(bookList).when(bookDao).getAllBooks();

    }

    private void setUpPublisherDaoMock(){
        publisherDao = mock(PublisherDaoJdbcTemplateImpl.class);
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(10);
        publisher.setName("US Publishing Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("Chicago");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");

        Publisher publisher2 = new Publisher();
        publisher2.setName("US Publishing Co.");
        publisher2.setStreet("1 N State");
        publisher2.setCity("Chicago");
        publisher2.setState("IL");
        publisher2.setPostal_code("60660");
        publisher2.setPhone("773-123-4444");
        publisher2.setEmail("info@uspublishingco.com");

        List<Publisher> publisherList = new ArrayList<>();
        publisherList.add(publisher);

        doReturn(publisher).when(publisherDao).addPublisher(publisher2);
        doReturn(publisher).when(publisherDao).getPublisher(10);
        doReturn(publisherList).when(publisherDao).getAllPublisher();


    }
}
