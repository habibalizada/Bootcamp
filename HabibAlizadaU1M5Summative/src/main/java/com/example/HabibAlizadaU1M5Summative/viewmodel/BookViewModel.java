package com.example.HabibAlizadaU1M5Summative.viewmodel;

import com.example.HabibAlizadaU1M5Summative.model.Author;
import com.example.HabibAlizadaU1M5Summative.model.Publisher;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class BookViewModel {

    private int id;
    private String isbn;
    private String title;
    private Author author;
    private LocalDate publish_date;
    private Publisher publisher;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookViewModel that = (BookViewModel) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author) &&
                Objects.equals(publish_date, that.publish_date) &&
                Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author, publish_date, publisher, price);
    }
}
