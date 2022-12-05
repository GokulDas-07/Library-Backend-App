package com.nest.libraryapp_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @GetMapping("/")
    public String HomePage()
    {
        return "Welcome to library home page";
    }

    @PostMapping("/entry")
    public String BookEntry()
    {
        return "Book entry page";
    }

    @PostMapping("/search")
    public String BookSearch()
    {
        return "Book search page";
    }

    @GetMapping("/view")
    public String BooksView()
    {
        return "Books view page";
    }
}
