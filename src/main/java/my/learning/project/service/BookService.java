package my.learning.project.service;

import my.learning.project.exception.NotFoundException;
import my.learning.project.repo.BookRepository;
import my.learning.project.repo.UserRepository;
import my.learning.project.schema.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
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

    public Books getSpecificBook(int bookId) throws NotFoundException {
        try {
            return domainToSchemaBook(bookRepository.getOne(bookId));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("User with id : [" + bookId + "] not found", e);
        }
    }

    public Books addBook(Books book) {
        return domainToSchemaBook(bookRepository.save(schemaToDomainBook(book, userRepository, bookRepository)));
    }

    public Books updateBook(Books book) {
        return domainToSchemaBook(bookRepository.save(schemaToDomainBook(book, userRepository, bookRepository)));
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}

