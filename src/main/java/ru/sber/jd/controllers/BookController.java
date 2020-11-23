package ru.sber.jd.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import ru.sber.jd.dto.BookDto;
import ru.sber.jd.services.BookServices;

import javax.servlet.*;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.websocket.Session;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookServices bookServices;
   // private ServletContext servletContext;
    @PostMapping
    public BookDto save (@RequestBody BookDto bookDto) {
        return bookServices.save(bookDto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<BookDto> findAll() {
        return bookServices.getAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping ("/{id}")
    public BookDto findById(@PathVariable Integer id) {
        return bookServices.getById(id);
    }


//    @ResponseBody
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/images/{id}")
//    public Resource getBookImage(@PathVariable Integer id) {
//
//        String url = "/WEB_INF/images/" + Integer.toString(id) + ".jpg";
//        return new ServletContextResource(servletContext, url);
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        bookServices.deleteById(id);
    }

//    public String hello(){
//        return  "hello";
//    }
}
