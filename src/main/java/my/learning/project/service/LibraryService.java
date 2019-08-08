package my.learning.project.service;

import my.learning.project.domain.Book;
import my.learning.project.domain.User;
import my.learning.project.exception.BadRequestException;
import my.learning.project.exception.NotFoundException;
import my.learning.project.repo.BookRepository;
import my.learning.project.repo.UserRepository;
import my.learning.project.schema.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static my.learning.project.utils.UserUtils.domainToSchemaUser;

@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public Users issueBook(Integer userID, Integer bookID) throws Exception {
        if (!userRepository.existsById(userID)) {
            throw new NotFoundException("User with id [" + userID + "] doesn't exists");
        }
        if (!bookRepository.existsById(bookID)) {
            throw new NotFoundException("Book with id [" + bookID + "] doesn't exists");
        }

        User user = userRepository.getOne(userID);
        if (user.getNoOfBooksAllowed() > user.getBooks().size()) {
            Book book = bookRepository.getOne(bookID);
            if (book.getNoOfCopies() > book.getUsers().size()) {
                user.getBooks().add(book);
                userRepository.save(user);
                book.getUsers().add(user);
                bookRepository.save(book);
            } else {
                throw new BadRequestException("All copies of the book are issued, try after sometime");
            }
        } else {
            throw new BadRequestException("User reached maximum no of books allowed");
        }
        return domainToSchemaUser(user);
    }

    @Override
    public Users returnBook(Integer userID, Integer bookID) throws Exception {
        if (!userRepository.existsById(userID)) {
            throw new NotFoundException("User with id [" + userID + "] doesn't exists");
        }
        if (!bookRepository.existsById(bookID)) {
            throw new NotFoundException("Book with id [" + bookID + "] doesn't exists");
        }
        User user = userRepository.getOne(userID);
        if (user.getBooks().contains(bookRepository.getOne(bookID))) {
            Book book = bookRepository.getOne(bookID);

            user.getBooks().remove(book);
            userRepository.save(user);
            book.getUsers().remove(user);
            bookRepository.save(book);
        } else {
            throw new BadRequestException("Book not issued to : " + user.getName() + " [" + user.getId() + "]");
        }
        return domainToSchemaUser(user);
    }

    @Override
    public String isBookAvailable(Integer bookID) throws Exception {
        if (!bookRepository.existsById(bookID)) {
            throw new NotFoundException("Book with id [" + bookID + "] not found in Library");
        }
        Book book = bookRepository.getOne(bookID);
        if (book.getNoOfCopies() > book.getUsers().size()) {
            return "No of copies available : " + (book.getNoOfCopies() - book.getUsers().size());
        } else {
            return "All copies are issued, try after sometime";
        }
    }
}
