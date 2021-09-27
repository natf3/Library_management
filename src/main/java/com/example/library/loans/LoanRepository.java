package com.example.library.loans;

import com.example.library.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

        List<Loan> findLoansByUser(User user);

        Loan findLoanByBookId(Long bookId);

}
