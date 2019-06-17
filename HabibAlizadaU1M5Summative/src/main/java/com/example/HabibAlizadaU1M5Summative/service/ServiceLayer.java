package com.example.HabibAlizadaU1M5Summative.service;

import com.example.HabibAlizadaU1M5Summative.dao.AuthorDao;
import com.example.HabibAlizadaU1M5Summative.dao.BookDao;
import com.example.HabibAlizadaU1M5Summative.dao.PublisherDao;
import com.example.HabibAlizadaU1M5Summative.model.Author;
import com.example.HabibAlizadaU1M5Summative.model.Book;
import com.example.HabibAlizadaU1M5Summative.model.Publisher;
import com.example.HabibAlizadaU1M5Summative.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private AuthorDao authorDao;
    private BookDao bookDao;
    private PublisherDao publisherDao;

    @Autowired
    public ServiceLayer(AuthorDao authorDao, BookDao bookDao, PublisherDao publisherDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    //--------------------------------------------------------------------------------------

    @Transactional
    public BookViewModel saveBook(BookViewModel viewModel){
        Book book = new Book();

        book.setBook_id(viewModel.getId());
        book.setIsbn(viewModel.getIsbn());
        book.setTitle(viewModel.getTitle());
        book.setAuthor_id(viewModel.getAuthor().getAuthor_id());
        book.setPublish_date(viewModel.getPublish_date());
        book.setPublisher_id(viewModel.getPublisher().getPublisher_id());
        book.setPrice(viewModel.getPrice());
        book = bookDao.addBook(book);
        viewModel.setId(book.getBook_id());

        return viewModel;
    }

    public BookViewModel findBook(int id){
        Book book = bookDao.getBook(id);
        return buildBookViewModel(book);
    }

    public List<BookViewModel> findBookByAuthor(int id){
        List<Book> bookList = bookDao.getAllBooks();
        List<BookViewModel> bookViewModelList = new ArrayList<>();
        BookViewModel bookViewModel = new BookViewModel();

        for (Book book : bookList){
            if (book.getAuthor_id() == id){
                bookViewModel = buildBookViewModel(book);
                bookViewModelList.add(bookViewModel);
            }
        }
        return bookViewModelList;
    }

    public List<BookViewModel> findAllBooks(){
        List<Book> bookList = bookDao.getAllBooks();
        List<BookViewModel> bookViewModelList = new ArrayList<>();

        for (Book book : bookList){
            BookViewModel bookViewModel = buildBookViewModel(book);
            bookViewModelList.add(bookViewModel);
        }
        return bookViewModelList;
    }

    @Transactional
    public BookViewModel updateBookViewModel(BookViewModel bookViewModel){
        Book book = new Book();
        book.setBook_id(bookViewModel.getId());
        book.setIsbn(bookViewModel.getIsbn());
        book.setPublish_date(bookViewModel.getPublish_date());
        book.setAuthor_id(bookViewModel.getAuthor().getAuthor_id());
        book.setTitle(bookViewModel.getTitle());
        book.setPublisher_id(bookViewModel.getPublisher().getPublisher_id());
        book.setPrice(bookViewModel.getPrice());

        bookDao.updateBook(book);
        return bookViewModel;
    }

    @Transactional
    public void removeBook(int id){
        bookDao.deleteBook(id);
    }

    //--------------------------------------------------------------------------------------

    @Transactional
    public Author saveAuthor(Author author){
        Author author2 = new Author();

        author2.setAuthor_id(author.getAuthor_id());
        author2.setFirst_name(author.getFirst_name());
        author2.setLast_name(author.getLast_name());
        author2.setStreet(author.getStreet());
        author2.setCity(author.getCity());
        author2.setState(author.getState());
        author2.setPostal_code(author.getPostal_code());
        author2.setPhone(author.getPhone());
        author2.setEmail(author.getEmail());

        author2 = authorDao.addAuthor(author);
        author2.setAuthor_id(author.getAuthor_id());

        return author2;
    }

    public Author findAuthor(int id){
        Author author = authorDao.getAuthor(id);
        return author;
    }

    public List<Author> findAllAuthors(){
        List<Author> authorList = authorDao.getAllAuthor();
        return authorList;
    }

    @Transactional
    public Author updateAuthor(Author author){
        Author author2 = new Author();
        author2.setAuthor_id(author.getAuthor_id());
        author2.setFirst_name(author.getFirst_name());
        author2.setLast_name(author.getLast_name());
        author2.setStreet(author.getStreet());
        author2.setCity(author.getCity());
        author2.setState(author.getState());
        author2.setPostal_code(author.getPostal_code());
        author2.setPhone(author.getPhone());
        author2.setEmail(author.getEmail());

        authorDao.updateAuthor(author2);
        return author2;
    }

    @Transactional
    public void removeAuthor(int id){
        authorDao.deleteAuthor(id);
    }

    //--------------------------------------------------------------------------------------

    @Transactional
    public Publisher savePublisher(Publisher publisher){
        Publisher publisher2 = new Publisher();

        publisher2.setPublisher_id(publisher.getPublisher_id());
        publisher2.setName(publisher.getName());
        publisher2.setStreet(publisher.getStreet());
        publisher2.setCity(publisher.getCity());
        publisher2.setState(publisher.getState());
        publisher2.setPostal_code(publisher.getPostal_code());
        publisher2.setPhone(publisher.getPhone());
        publisher2.setEmail(publisher.getEmail());

        publisher2 = publisherDao.addPublisher(publisher);
        publisher2.setPublisher_id(publisher.getPublisher_id());

        return publisher2;
    }

    public Publisher findPublisher(int id){
        Publisher publisher = publisherDao.getPublisher(id);
        return publisher;
    }

    public List<Publisher> findAllPublishers(){
        List<Publisher> publisherList = publisherDao.getAllPublisher();
        return publisherList;
    }

    @Transactional
    public Publisher updatePublisher(Publisher publisher){
        Publisher publisher2 = new Publisher();

        publisher2.setPublisher_id(publisher.getPublisher_id());
        publisher2.setName(publisher.getName());
        publisher2.setStreet(publisher.getStreet());
        publisher2.setCity(publisher.getCity());
        publisher2.setState(publisher.getState());
        publisher2.setPostal_code(publisher.getPostal_code());
        publisher2.setPhone(publisher.getPhone());
        publisher2.setEmail(publisher.getEmail());

        publisherDao.updatePublisher(publisher2);

        return publisher2;
    }

    @Transactional
    public void removePublisher(int id){
        publisherDao.deletePublisher(id);
    }

    //--------------------------------------------------------------------------------------

    private BookViewModel buildBookViewModel(Book book){

        Author author = authorDao.getAuthor(book.getAuthor_id());
        Publisher publisher = publisherDao.getPublisher(book.getPublisher_id());

        BookViewModel bookViewModel = new BookViewModel();

        bookViewModel.setId(book.getBook_id());
        bookViewModel.setIsbn(book.getIsbn());
        bookViewModel.setTitle(book.getTitle());
        bookViewModel.setAuthor(author);
        bookViewModel.setPublish_date(book.getPublish_date());
        bookViewModel.setPublisher(publisher);
        bookViewModel.setPrice(book.getPrice());
        return bookViewModel;
    }


}
