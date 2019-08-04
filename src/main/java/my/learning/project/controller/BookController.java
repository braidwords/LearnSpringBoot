package my.learning.project.controller;

import my.learning.project.entity.Book;
import my.learning.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController implements IBookController {

    @Autowired
    private BookService booksService;

    @GetMapping
    @ResponseBody
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getSpecificBook(@PathVariable int id) {
        return booksService.getSpecificBook(id);
    }

    @PostMapping
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return booksService.addBook(book);
    }

    @PutMapping
    @ResponseBody
    public Book updateBook(@RequestBody Book book) {
        return booksService.updateBook(book);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id) {
        booksService.deleteBook(id);
        return String.format("Book with ID {%s} is deleted", id);
    }
}