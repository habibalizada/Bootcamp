package com.example.U1M4SummativeAlizadaHabib.model;

import javax.validation.constraints.NotEmpty;

public class Definition {

    @NotEmpty(message = "Your must supply with a word")
    private String word;
    @NotEmpty(message = "Your must supply with a definition")
    private String definition;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
