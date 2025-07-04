package com.biblioteca_digital_fer.biblioteca_digital_fer.Service;

import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.Book;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.ResponseLibrary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Responses {
    ResponseLibrary response = new ResponseLibrary();
    public ResponseEntity<ResponseLibrary> ResponseSuccessMessage(List<Book> books){
        response.setBooks(books);
        response.setResult("200");
        response.setMessage("Success");
        return  ResponseEntity.ok(response);
    }
    public ResponseEntity<ResponseLibrary> ResponseFailMessage(){
        response.setResult("500");
        response.setMessage("Error showing information");
        response.setBooks(null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public ResponseEntity<ResponseLibrary> NormalResponse(){
        response.setBooks(null);
        response.setResult("200");
        response.setMessage("Success");
        return  ResponseEntity.ok(response);
    }

}
