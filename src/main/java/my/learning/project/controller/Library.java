package my.learning.project.controller;

import my.learning.project.entity.User;
import my.learning.project.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class Library implements ILibrary {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public User issueBook(@RequestParam(name = "userid") Integer userID, @RequestParam(name = "bookid") Integer bookID) throws Exception {
        return libraryService.issueBook(userID, bookID);
    }

    //@GetMapping
    public User returnBook(@RequestParam(name = "userid") Integer userID, @RequestParam(name = "bookid") Integer bookID) throws Exception {
        return libraryService.returnBook(userID, bookID);
    }

    @GetMapping("/{bookid}")
    public Boolean isBookAvailable(@PathVariable Integer bookID) {
        return libraryService.isBookAvailable(bookID);
    }
}
