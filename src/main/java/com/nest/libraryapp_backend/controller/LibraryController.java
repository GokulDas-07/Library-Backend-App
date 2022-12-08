package com.nest.libraryapp_backend.controller;

import com.nest.libraryapp_backend.dao.BooksDao;
import com.nest.libraryapp_backend.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BooksDao dao;

    @GetMapping("/")
    public String HomePage()
    {
        return "Welcome to library home page";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/entry",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> BookEntry(@RequestBody Books b)
    {
        HashMap<String,String> map=new HashMap<>();
        dao.save(b);
        map.put("status","success");
        return map;
    }

    @CrossOrigin("*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Books> searchBooks(@RequestBody Books b)
    {
        String title=b.getTitle();
        System.out.println(title);
        return dao.searchBooks(title);
    }
    @CrossOrigin("*")
    @GetMapping("/view")
    public List<Books> viewBooks()
    {
        return (List<Books>) dao.findAll();
    }
    @CrossOrigin("*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> deleteBook(@RequestBody Books b)
    {
        HashMap<String ,String> map =new HashMap<>();
        String bid=String.valueOf(b.getId());
        System.out.println(bid);
        dao.deleteBook(b.getId());
        map.put("status","success");
        return map;
    }
}
