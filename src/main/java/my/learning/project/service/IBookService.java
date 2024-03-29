package my.learning.project.service;

import my.learning.project.exception.NotFoundException;
import my.learning.project.schema.Books;

import java.util.List;

public interface IBookService {

    List<Books> getAllBooks();

    Books addBook(Books book);

    Books getSpecificBook(int i) throws NotFoundException;

    Books updateBook(Books book);

    void deleteBook(int id);

}
