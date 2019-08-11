package my.learning.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.learning.project.exception.NotFoundException;
import my.learning.project.schema.Books;
import my.learning.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value = "Book management", tags ="Book management")
public class BookController implements IBookController {

    @Autowired
    private BookService booksService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Get all available books", tags = "Book management")
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a specific book", tags = "Book management")
    public Books getSpecificBook(@PathVariable int id) throws NotFoundException {
        return booksService.getSpecificBook(id);
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Add a new book", tags = "Book management")
    public Books addBook(@RequestBody Books book) {
        return booksService.addBook(book);
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "Update an existing book", tags = "Book management")
    public Books updateBook(@RequestBody Books book) {
        return booksService.updateBook(book);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete a specific book", tags = "Book management")
    public String deleteBook(@PathVariable int id) {
        booksService.deleteBook(id);
        return String.format("Book with ID {%s} is deleted", id);
    }
}