package com.example.myapplication.models;

import java.io.Serializable;

public class Data implements Serializable {
    String text;

    public Data(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
