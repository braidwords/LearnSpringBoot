package my.learning.project.service;

import my.learning.project.entity.Book;
import my.learning.project.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    public BookRepository bookRepository;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }


    public Book getSpecificBook(int i)
    {
        return bookRepository.getOne(i);
    }

    public Book updateBook(Book book)
    {
        return bookRepository.save(book);
    }

    public String deleteBook(int id)
    {
        bookRepository.deleteById(id);
        return"Book deleted";
    }
}

