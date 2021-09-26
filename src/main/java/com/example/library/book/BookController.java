package com.example.library.book;

import com.example.library.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(path = "/{bookId}")
    public Book getBook(@PathVariable("bookId") Long bookId){
        return bookService.getBooks().stream().filter(book -> bookId.equals(book.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }

    @PostMapping(path = "/add")
    public void addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) { bookService.deleteBook(bookId);}

}
