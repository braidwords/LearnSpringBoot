package my.learning.project.service;

import my.learning.project.entity.Book;
import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();

    Book addBook(Book book);

    Book getSpecificBook(int i);

    Book updateBook(Book book);

    void deleteBook(int id);

}
