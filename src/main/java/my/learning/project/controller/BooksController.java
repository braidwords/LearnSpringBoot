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
    @GetMapping("/{id}")
    public Book getSpecificBook(@PathVariable int id) {
        return booksService.getSpecificBook(id);

    }

    @PostMapping
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return booksService.addBook(book);
    }

    @Override
    @PutMapping
    @ResponseBody
    public Book updateBook(@RequestBody Book book) {

        return booksService.updateBook(book);
    }

    @Override
    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable  int id) {

        booksService.deleteBook(id);
        return "Deleted";
    }

}
