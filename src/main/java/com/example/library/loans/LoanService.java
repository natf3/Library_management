package com.example.library.loans;

import com.example.library.book.Book;
import com.example.library.book.BookRepository;
import com.example.library.book.BookState;
import com.example.library.securingweb.SecurityController;
import com.example.library.user.User;
import com.example.library.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    private final SecurityController securityController;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository, SecurityController securityController) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.securityController = securityController;
    }

    public List<Loan> getLoans(){
        User user = securityController.getCurrentUser();
        List<Loan> loansList = loanRepository.findLoansByUser(user);

        return loansList;
    }

    public void deleteLoan(Long bookId) {
        User user = securityController.getCurrentUser();
        Loan foundLoan = loanRepository.findLoanByBookId(bookId);
        Book book = bookRepository.findBookById(bookId);
        int loanLimit = user.getLoanLimit();

        loanRepository.deleteById(foundLoan.getId());
        user.setLoanLimit(loanLimit - 1);
        userRepository.save(user);
        book.setBookState(BookState.FREE);
        bookRepository.save(book);
    }

    public void loanBook(Long bookId) {
        User user = securityController.getCurrentUser();
        Book book = bookRepository.findBookById(bookId);
        int loanLimit = user.getLoanLimit();

        if (book.getBookState().equals(BookState.TAKEN) || loanLimit == 5){
            throw new IllegalStateException("Problem with loaning");
        }
        Loan loanBook = new Loan(user, book);
        loanRepository.save(loanBook);
        user.setLoanLimit(loanLimit + 1);
        userRepository.save(user);
        book.setBookState(BookState.TAKEN);
        bookRepository.save(book);
    }
}
