package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookBDD = new Book("Behavior Driven Design", "987", "Arolla Edition");
        Book bookTDD = new Book("Crafters", "654", "Square Edition");

        System.out.println("Id : " + bookBDD.getId());
        System.out.println("Id : " + bookTDD.getId());

        Book savedBDD = bookRepository.save(bookBDD);
        Book savedTDD = bookRepository.save(bookTDD);

        System.out.println("Id : " + savedBDD.getId());
        System.out.println("Id : " + savedTDD.getId());

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id : " + book.getId());
            System.out.println("Book Title : " + book.getTitle());
        });
    }
}
