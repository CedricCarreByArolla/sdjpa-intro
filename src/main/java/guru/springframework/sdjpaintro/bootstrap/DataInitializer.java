package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookBDD = new Book("Behavior Driven Design", "987", "Arolla Edition");
        Book savedBDD = bookRepository.save(bookBDD);

        Book bookTDD = new Book("Crafters", "654", "Square Edition");
        Book savedTDD = bookRepository.save(bookTDD);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id : " + book.getId());
            System.out.println("Book Title : " + book.getTitle());
        });
    }
}
