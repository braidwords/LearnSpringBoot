package my.learning.project.controller;

import my.learning.project.entity.Book;

import java.util.List;

public interface BookControllerInterface {

    /**
     * GET request to fetch all books
     * @return list of all Book
     */
    List<Book> getAllBooks();

    /**
     * GET request to fetch specific book
     * @param id ID of the book to be fetched
     * @return requested Book
     */
    Book getSpecificBook(int id);

    /**
     * POST request to add a new Book
     * @param book Details of Book to be added
     * @return Newly created Book
     */
    Book addBook(Book book);

    /**
     * PUT request to update an existing book
     * @param book Book to be updated
     * @return Updated Book
     */
    Book updateBook(Book book);

    /**
     * Delete a specific Book
     * @param id ID of the book to be deleted
     * @return Status message
     */
    String deleteBook(int id);

}
