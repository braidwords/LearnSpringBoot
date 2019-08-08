package my.learning.project.controller;

import my.learning.project.schema.Books;
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
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Books getSpecificBook(@PathVariable int id) {
        return booksService.getSpecificBook(id);
    }

    @PostMapping
    @ResponseBody
    public Books addBook(@RequestBody Books book) {
        return booksService.addBook(book);
    }

    @PutMapping
    @ResponseBody
    public Books updateBook(@RequestBody Books book) {
        return booksService.updateBook(book);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id) {
        booksService.deleteBook(id);
        return String.format("Book with ID {%s} is deleted", id);
    }
}