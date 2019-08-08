package my.learning.project.service;

import my.learning.project.repo.BookRepository;
import my.learning.project.repo.UserRepository;
import my.learning.project.schema.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static my.learning.project.utils.BookUtils.*;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Books> getAllBooks() {
        return domainToSchemaBookList(bookRepository.findAll());
    }

    public Books getSpecificBook(int bookId) {
        return domainToSchemaBook(bookRepository.getOne(bookId));
    }

    public Books addBook(Books book) {
        return domainToSchemaBook(bookRepository.save(schemaToDomainBook(book, userRepository)));
    }

    public Books updateBook(Books book) {
        return domainToSchemaBook(bookRepository.save(schemaToDomainBook(book, userRepository)));
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}

