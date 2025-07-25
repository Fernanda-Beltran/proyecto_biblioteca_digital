package com.biblioteca_digital_fer.biblioteca_digital_fer.Controller;

import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.BodySearch;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.Book;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.Mensaje;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.ResponseLibrary;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Service.LibraryImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fer")

public class LibraryController {
    @Autowired
    LibraryImplement libraryImplement;

    @GetMapping(value = "/library")
    public ResponseEntity<ResponseLibrary> getBook(){
        return libraryImplement.getBooks();
    }

    @PostMapping(value = "/search")
    public  ResponseEntity<ResponseLibrary> getSearch(@RequestBody BodySearch bodySearch){
        return libraryImplement.getSearch(bodySearch);
    }

    @PostMapping(value = "/newBook")
    public ResponseEntity<ResponseLibrary> addBook(@RequestBody Book book){
        return libraryImplement.addBook(book);
    }

    @GetMapping(value = "/poncho")
    public ResponseEntity<ResponseLibrary> mensajePoncho(){
        return libraryImplement.mensajePoncho();
    }

}
