package com.example.library.loan;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getLoans(){
         return loanService.getLoans();
    }

    @PostMapping("{bookId}")
    public void loanBook(@PathVariable("bookId") Long bookId){
        loanService.loanBook(bookId);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteLoan(@PathVariable("bookId") Long bookId){
        loanService.deleteLoan(bookId);
    }

}
