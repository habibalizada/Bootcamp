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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

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
    public void addGetDeleteAuthor() {

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

        Author author1 = authorDao.getAuthor(author.getAuthor_id());

        assertEquals(author1, author);

        authorDao.deleteAuthor(author.getAuthor_id());

        author1 = authorDao.getAuthor(author.getAuthor_id());

        assertNull(author1);

    }

    @Test
    public void updateAuthor() {

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

        author.setFirst_name("Bob");
        author.setLast_name("Doe");
        author.setStreet("1 N State");
        author.setCity("Chicago");
        author.setState("IL");
        author.setPostal_code("60660");
        author.setPhone("773-123-4444");
        author.setEmail("john@gmail.com");

        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthor_id());

        assertEquals(author1, author);
    }

    @Test
    public void addAllAuthor() {

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

        author = new Author();
        author.setFirst_name("Ken");
        author.setLast_name("Brown");
        author.setStreet("1 N State");
        author.setCity("Chicago");
        author.setState("IL");
        author.setPostal_code("60660");
        author.setPhone("773-123-4444");
        author.setEmail("john@gmail.com");

        author = authorDao.addAuthor(author);

        List<Author> authorList = authorDao.getAllAuthor();
        assertEquals(authorList.size(), 2);
    }
}