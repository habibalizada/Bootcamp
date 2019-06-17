package com.example.HabibAlizadaU1M5Summative.controller;

import com.example.HabibAlizadaU1M5Summative.model.Author;
import com.example.HabibAlizadaU1M5Summative.model.Publisher;
import com.example.HabibAlizadaU1M5Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PublisherJdbcController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Publisher createPublisher(@RequestBody Publisher publisher){
        return serviceLayer.savePublisher(publisher);
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher getPublisher(@PathVariable int id) {
        return serviceLayer.findPublisher(id);
    }

    @RequestMapping(value = "/allPublishers", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        return serviceLayer.findAllPublishers();
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removePublisher(@PathVariable int id) {
        serviceLayer.removePublisher(id);
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public Publisher updatePublisher(@RequestBody Publisher publisher, @PathVariable int id) {
        publisher.setPublisher_id(id);
        return serviceLayer.updatePublisher(publisher);
    }

}
