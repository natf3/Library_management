package com.example.library.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(path = "free")
    public List<Book> getFreeBooks() {
        return bookService.getFreeBooks();
    }

    @GetMapping(path = "{bookId}")
    public Book getBook(@PathVariable("bookId") Long bookId){
        return bookService.getBooks().stream().filter(book -> bookId.equals(book.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }

    @PostMapping(path = "add")
    public void addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) { bookService.deleteBook(bookId);}

}
