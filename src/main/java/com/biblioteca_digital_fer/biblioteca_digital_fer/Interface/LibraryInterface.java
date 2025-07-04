package com.biblioteca_digital_fer.biblioteca_digital_fer.Interface;

import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.BodySearch;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.Book;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.ResponseLibrary;
import lombok.Data;
import org.springframework.http.ResponseEntity;

public interface LibraryInterface {
    ResponseEntity<ResponseLibrary> getBooks();
    ResponseEntity<ResponseLibrary> getSearch(BodySearch bodySearch);
    ResponseEntity<ResponseLibrary> addBook(Book book);
}
