package com.example.library.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
        return args -> {
            Book book1 = new Book ("Mały Książe", "Antoine de Saint-Exupéry", "Dla młodzieży", BookState.FREE);
            Book book2 = new Book ("Władca Pierścieni", "J.R.R. Tolkien", "Fantasy", BookState.FREE);
            Book book3 = new Book ("I Nie Było Już Nikogo", "Agatha Christie", "Kryminał", BookState.FREE);
            Book book4 = new Book ("Piękny umysł", "Sylvia Nasar", "Biografia", BookState.FREE);
            Book book5 = new Book ("Jfeiwj w ewjodpew", "Emma Dillard", "Science-fiction", BookState.FREE);
            Book book6 = new Book ("ggfhghhdghw", "vrhioh fjiwpfw", "Dla młodzieży", BookState.FREE);

            bookRepository.saveAll(List.of(book1, book2, book3, book4, book5, book6));
        };
    }
}
