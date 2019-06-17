package com.example.HabibAlizadaU1M5Summative.dao;

import com.example.HabibAlizadaU1M5Summative.model.Author;
import com.example.HabibAlizadaU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher addPublisher(Publisher publisher);
    Publisher getPublisher(int id);
    List<Publisher> getAllPublisher();
    void updatePublisher(Publisher publisher);
    void deletePublisher(int id);
}
