package com.library.library_management.service;

import com.library.library_management.entity.Book;
import com.library.library_management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    // add book
    public Book addBook(Book book){
        book.setAvailableCopies(book.getAvailableCopies());
        return bookRepository.save(book);
    }
    // get all book can also be used -->>  return bookRepository.findByActiveTrue;
    public List<Book> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .filter(book-> book.isActive())
                .collect(Collectors.toList());
    }
    //get book by id
    public Optional<Book> getBooksById(Long id){
        return bookRepository.findById(id);
    }
    //search by author
    public List<Book> getBooksByAuthor(String author){
        return bookRepository.findByAuthorIgnoreCase(author);
    }
    // by genre
    public List<Book> getBooksByGenre(String genre){
        return bookRepository.findByGenreIgnoreCase(genre);
    }
    // delete book
    public void deleteBook(Long id){
        bookRepository.findById(id).ifPresent(book->{book.setActive(false); bookRepository.save(book);});
    }
    //update book
    public Book updateBook(Long id, Book book){
        return bookRepository.findById(id).map(exBook->{
            exBook.setTitle(book.getTitle());
            exBook.setAuthor(book.getAuthor());
            exBook.setGenre(book.getGenre());
            exBook.setPrice(book.getPrice());
            exBook.setTotalCopies(book.getTotalCopies());
            exBook.setActive(true);
            return bookRepository.save(exBook);
        })
                .orElseThrow(()-> new RuntimeException("Book not found with id"));
    }
}
