package com.example.HabibAlizadaU1M5Summative.dao;

import com.example.HabibAlizadaU1M5Summative.model.Author;
import com.example.HabibAlizadaU1M5Summative.model.Book;
import com.example.HabibAlizadaU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.text.DateFormatter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import static javafx.scene.input.KeyCode.T;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        List<Book> bookList = bookDao.getAllBooks();

        for (Book book : bookList){
            bookDao.deleteBook(book.getBook_id());
        }

        List<Author> authorList = authorDao.getAllAuthor();

        for (Author author : authorList){
            authorDao.deleteAuthor(author.getAuthor_id());
        }

        List<Publisher> publisherList = publisherDao.getAllPublisher();

        for (Publisher publisher : publisherList){
            publisherDao.deletePublisher(publisher.getPublisher_id());
        }
    }

    @Test
    public void addGetDeleteBook() {

        Publisher publisher = new Publisher();
        publisher.setName("US Publishing Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("Chicago");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Brooks");
        author.setStreet("1 N State");
        author.setCity("Chicago");
        author.setState("IL");
        author.setPostal_code("60660");
        author.setPhone("773-123-4444");
        author.setEmail("john@gmail.com");
        author = authorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("BK12345678");
        book.setPublish_date(LocalDate.of(2010, 1, 5));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("How to skimm your life");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(12.99);
        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getBook_id());

        assertEquals(book1, book);

        bookDao.deleteBook(book.getBook_id());

        book1 = bookDao.getBook(book.getBook_id());

        assertNull(book1);

    }
}


























