package com.example.HabibAlizadaU1M5Summative.controller;

import com.example.HabibAlizadaU1M5Summative.service.ServiceLayer;
import com.example.HabibAlizadaU1M5Summative.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookJdbcController {

    @Autowired
    ServiceLayer serviceLayer;
    //BookDao bookDao;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public BookViewModel createBook(@RequestBody BookViewModel bookViewModel){
        return serviceLayer.saveBook(bookViewModel);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public BookViewModel getBook(@PathVariable int id) {
        return serviceLayer.findBook(id);
    }

    @RequestMapping(value = "/bookbyauthor/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<BookViewModel> getBookByAuthor(@PathVariable int id) {
        return serviceLayer.findBookByAuthor(id);
    }

    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<BookViewModel> getAllBooks() {
        return serviceLayer.findAllBooks();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable int id) {
        serviceLayer.removeBook(id);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public BookViewModel updateBookViewModel(@RequestBody BookViewModel bookViewModel, @PathVariable int id) {
        bookViewModel.setId(id);
        return serviceLayer.updateBookViewModel(bookViewModel);
    }

}
