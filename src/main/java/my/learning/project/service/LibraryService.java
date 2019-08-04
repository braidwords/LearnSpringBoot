package my.learning.project.service;

import my.learning.project.entity.Book;
import my.learning.project.entity.User;
import my.learning.project.repo.BookRepository;
import my.learning.project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public User issueBook(Integer userID, Integer bookID) throws Exception {
        if (userRepository.existsById(userID)) {
            throw new Exception("User doesn't exists");
        }
        if (bookRepository.existsById(bookID)) {
            throw new Exception("Book doesn't exists");
        }

        User user = userRepository.getOne(userID);
        if (user.getNoOfBooksAllowed() < user.getBooks().size()) {
            Book book = bookRepository.getOne(bookID);
            if (book.getNoOfCopies() < book.getUsers().size()) {
                book.getUsers().add(user);
                user.getBooks().add(book);
                userRepository.save(user);
                bookRepository.save(book);
            } else {
                throw new Exception("All copies of the book are issued, try after sometime");
            }
        } else {
            throw new Exception("User reached maximum no of books allowed");
        }
        return user;
    }

    @Override
    public User returnBook(Integer userID, Integer bookID) throws Exception {
        if (userRepository.existsById(userID)) {
            throw new Exception("User doesn't exists");
        }
        if (bookRepository.existsById(bookID)) {
            throw new Exception("Book doesn't exists");
        }
        User user = userRepository.getOne(userID);
        if (user.getBooks().contains(bookRepository.getOne(bookID))) {
            Book book = bookRepository.getOne(bookID);

            user.getBooks().remove(book);
            book.getUsers().remove(user);
            userRepository.save(user);
            bookRepository.save(book);
        } else {
            throw new Exception("User reached maximum no of books allowed");
        }
        return user;
    }

    @Override
    public Boolean isBookAvailable(Integer bookID) {
        return bookRepository.existsById(bookID);
    }
}
