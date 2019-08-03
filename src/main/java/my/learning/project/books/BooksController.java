package my.learning.project.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    @ResponseBody
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

/*    @GetMapping("/{bookID}")
    public Book getSpecificBook(@PathVariable("bookID") int bookID) {
        return booksService.get_book(bookID);
    }

    @GetMapping("/{book_name}")
    public Book get_id(@PathVariable("book_name") String name) {
        return (booksService.get_id(name));
    }*/

    @PostMapping
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return booksService.add_book(book);
    }

/*    @PutMapping
    public void update_book(@RequestBody Book book) {
        booksService.update_book(book);
    }

    @DeleteMapping("/{book}")
    public void delete_book(@PathVariable("book") String name) {
        booksService.delete_book(name);
    }*/
}
