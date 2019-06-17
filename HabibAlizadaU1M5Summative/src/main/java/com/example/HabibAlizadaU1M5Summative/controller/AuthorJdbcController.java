package com.example.HabibAlizadaU1M5Summative.controller;

import com.example.HabibAlizadaU1M5Summative.model.Author;
import com.example.HabibAlizadaU1M5Summative.service.ServiceLayer;
import com.example.HabibAlizadaU1M5Summative.viewmodel.BookViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AuthorJdbcController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Author createAuthor(@RequestBody Author author){
        return serviceLayer.saveAuthor(author);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Author getAuthor(@PathVariable int id) {
        return serviceLayer.findAuthor(id);
    }

    @RequestMapping(value = "/allAuthors", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAllAuthors() {
        return serviceLayer.findAllAuthors();
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeAuthor(@PathVariable int id) {
        serviceLayer.removeAuthor(id);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Author updateAuthor(@RequestBody Author author, @PathVariable int id) {
        author.setAuthor_id(id);
        return serviceLayer.updateAuthor(author);
    }


}
