package my.learning.project.utils;

import my.learning.project.domain.Book;
import my.learning.project.domain.User;
import my.learning.project.repo.UserRepository;
import my.learning.project.schema.Books;
import my.learning.project.schema.Users;

import java.util.ArrayList;
import java.util.List;

public class BookUtils {

    /*Book (Domain) <-> Books (Schema) */

    public static Books domainToSchemaBook(Book book) {
        Books books = new Books();
        books.setId(book.getId());
        books.setName(book.getName());
        books.setNoOfCopies(book.getNoOfCopies());
        for (User user : book.getUsers()) {
            books.getUsers().add(user.getId());
        }
        return books;
    }

    public static List<Books> domainToSchemaBookList(List<Book> books) {
        List<Books> booksList = new ArrayList<>();
        for (Book book : books) {
            booksList.add(domainToSchemaBook(book));
        }
        return booksList;
    }

    public static Book schemaToDomainBook(Books bookDomain, UserRepository userRepository) {
        Book bookSchema = new Book();
        bookSchema.setId(bookDomain.getId());
        bookSchema.setName(bookDomain.getName());
        bookSchema.setNoOfCopies(bookDomain.getNoOfCopies());
        for (Integer userId : bookDomain.getUsers()) {
            bookSchema.getUsers().add(userRepository.getOne(userId));
        }
        return bookSchema;
    }
}
