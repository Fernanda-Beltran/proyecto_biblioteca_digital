package com.biblioteca_digital_fer.biblioteca_digital_fer.Service;

import com.biblioteca_digital_fer.biblioteca_digital_fer.Interface.LibraryInterface;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.BodySearch;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.Book;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.Mensaje;
import com.biblioteca_digital_fer.biblioteca_digital_fer.Models.ResponseLibrary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Slf4j
@Service
@Repository
public class LibraryImplement implements LibraryInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    Responses responses = new Responses();

    public ResponseEntity<ResponseLibrary> getBooks(){
        try {
            String sql = "SELECT nombre, autor, paginas, leido FROM libros";
            List<Book> books = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
            return responses.ResponseSuccessMessage(books);

        } catch (Exception e) {
            return responses.ResponseFailMessage();
        }
    }
    public  ResponseEntity<ResponseLibrary> getSearch(BodySearch bodySearch){
        try {
            String sql = "SELECT nombre, autor, paginas, leido FROM libros WHERE LOWER(nombre) = ? OR LOWER(autor) = ? OR CAST(paginas AS CHAR) = ? OR CAST(leido AS CHAR) = ?";
            List<Book> books = jdbcTemplate.query(sql, new Object[]{bodySearch.getOption(), bodySearch.getOption(), bodySearch.getOption(), bodySearch.getOption()}, new BeanPropertyRowMapper<>(Book.class));
            return responses.ResponseSuccessMessage(books);
        } catch (Exception e){
            return responses.ResponseFailMessage();
        }
    }
    public ResponseEntity<ResponseLibrary> addBook(Book book){
        try {
            String sql = "INSERT INTO libros(nombre, autor, paginas, leido) VALUES (?, ?, ?, ?)";
            int row = jdbcTemplate.update(sql, book.getNombre(), book.getAutor(), book.getPaginas(), book.getLeido());
            return responses.NormalResponse();
        }catch (Exception e){
            return responses.ResponseFailMessage();
        }
    }

    public ResponseEntity<ResponseLibrary> mensajePoncho(){
        Mensaje mensaje = new Mensaje();
        try {
            return responses.paraPoncho();

        }catch (Exception e) {
                return responses.ResponseFailMessage();
        }
    }

}
