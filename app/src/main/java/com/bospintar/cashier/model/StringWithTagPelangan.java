package com.bospintar.cashier.model;

public class StringWithTagPelangan {
    public String string;
    public Object tag;
    public StringWithTagPelangan(String stringPart, Object tagPart) {
        string = stringPart;
        tag = tagPart;
    }
    @Override
    public String toString() {
        return string;
    }
}
