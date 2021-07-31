package com.Jesus.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Jesus.show.models.Book;
import com.Jesus.show.services.BookService;

@Controller
@RequestMapping("")
public class BookController {
	private final BookService bookService;
	
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    
    @RequestMapping("/books/{id}")
    public String findBookByIndex(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "showbook.jsp";
    }
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @DeleteMapping
    public void deleteBook(@PathVariable("id") Long id) {
    	this.bookService.deleteBook(id);
    }
    
    @PutMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        if (book != null){
            model.addAttribute("book", book);
            return "editBook.jsp";
        }
        else{
            return "redirect:/books";
        }
    }
    
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editBook.jsp";
        }
        	this.bookService.createBook(book);
            return "redirect:/books";
    }
}