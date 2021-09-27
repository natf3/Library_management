package com.example.library.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getFreeBooks(){
        return bookRepository.findAllByBookState(BookState.FREE);
    }

    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
        boolean bookExists = bookRepository.existsById(bookId);

        if(!bookExists){
            throw new IllegalStateException("Book does not exist");
        }
        bookRepository.deleteById(bookId);
    }
}
