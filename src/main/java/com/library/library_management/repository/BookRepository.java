package com.library.library_management.repository;

import java.util.List;
import com.library.library_management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{
    // jpa repository gives us save findById and everything in build for free
    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByActiveTrue();

    List<Book> findByTitleContaining(String keyword);

    List<Book> findByAuthorIgnoreCase(String author);

    List<Book> findByGenreIgnoreCase(String genre);
}
