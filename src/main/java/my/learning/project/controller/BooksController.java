package my.learning.project.controller;

import my.learning.project.entity.Book;
import my.learning.project.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController implements BookControllerInterface {

    @Autowired
    private BooksService booksService;

    @GetMapping
    @ResponseBody
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @Override
    public Book getSpecificBook(int id) {
        return null;
    }

    @PostMapping
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return booksService.addBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public String deleteBook(int id) {
        return null;
    }

}
