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
public class PublisherDaoTest {

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
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("US Publishing Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("Chicago");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getPublisher_id());

        publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertNull(publisher1);
    }

    @Test
    public void getAllPublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("US Publishing Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("Chicago");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("Norht Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("New York");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");
        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> publisherDaoList = publisherDao.getAllPublisher();

        assertEquals(publisherDaoList.size(), 2);
    }

    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("US Publishing Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("Chicago");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");
        publisherDao.addPublisher(publisher);

        publisher.setName("New Norht Co.");
        publisher.setStreet("1 N State");
        publisher.setCity("Denver");
        publisher.setState("IL");
        publisher.setPostal_code("60660");
        publisher.setPhone("773-123-4444");
        publisher.setEmail("info@uspublishingco.com");
        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher1, publisher);
    }
}
