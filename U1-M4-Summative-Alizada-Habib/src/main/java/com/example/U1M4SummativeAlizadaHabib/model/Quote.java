package com.example.U1M4SummativeAlizadaHabib.model;

import javax.validation.constraints.NotEmpty;

public class Quote {

    @NotEmpty(message = "Your must supply with a quote")
    private String quote;
    @NotEmpty(message = "Your must supply with a author name")
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
