package ca.sheridancollege.bhindeak.a4_webservices.repositories;

import ca.sheridancollege.bhindeak.a4_webservices.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}
