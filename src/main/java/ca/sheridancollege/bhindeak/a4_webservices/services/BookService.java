package ca.sheridancollege.bhindeak.a4_webservices.services;

import ca.sheridancollege.bhindeak.a4_webservices.models.Book;
import ca.sheridancollege.bhindeak.a4_webservices.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return bookRepo.findById(id).map(book -> {
            if (book.isEdit()) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthorName(updatedBook.getAuthorName());
                book.setPrice(updatedBook.getPrice());
                book.setQuantity(updatedBook.getQuantity());
                return bookRepo.save(book);
            }
            return null;
        });
    }

    public List<Book> findByTitle(String title) {
        return bookRepo.findByTitleContainingIgnoreCase(title);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }
}
