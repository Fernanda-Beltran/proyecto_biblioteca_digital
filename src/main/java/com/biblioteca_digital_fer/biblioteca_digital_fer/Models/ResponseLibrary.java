package com.biblioteca_digital_fer.biblioteca_digital_fer.Models;

import lombok.Data;

import java.util.List;

@Data
public class ResponseLibrary {
    private List<Book> books;
    private String result;
    private String message;
}
