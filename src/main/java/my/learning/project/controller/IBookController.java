package my.learning.project.controller;

import my.learning.project.schema.Books;
import java.util.List;

public interface IBookController {

    /**
     * GET request to fetch all books
     * @return list of all Book
     */
    List<Books> getAllBooks();

    /**
     * GET request to fetch specific book
     * @param id ID of the book to be fetched
     * @return requested Book
     */
    Books getSpecificBook(int id);

    /**
     * POST request to add a new Book
     * @param book Details of Book to be added
     * @return Newly created Book
     */
    Books addBook(Books book);

    /**
     * PUT request to update an existing book
     * @param book Book to be updated
     * @return Updated Book
     */
    Books updateBook(Books book);

    /**
     * Delete a specific Book
     * @param id ID of the book to be deleted
     * @return Status message
     */
    String deleteBook(int id);

}
