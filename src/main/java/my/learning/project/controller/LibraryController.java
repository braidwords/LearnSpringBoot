package my.learning.project.controller;

import my.learning.project.domain.User;
import my.learning.project.schema.Users;
import my.learning.project.service.LibraryService;
import my.learning.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController implements ILibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public Users issueOrReturnBook(@RequestParam(name = "userid") Integer userID, @RequestParam(name = "bookid") Integer bookID, @RequestParam(name = "type") Character type) throws Exception {
        User user;
        if (type == 'I') {
            user= libraryService.issueBook(userID, bookID);
        } else if (type == 'R') {
            user= libraryService.returnBook(userID, bookID);
        } else {
            throw new Exception("Only I (Issue) and R (Return) are allowed in the request along with userid and bookid");
        }
        return userService.getSpecificUser(userID);
    }

    @GetMapping("/{bookid}")
    public String isBookAvailable(@PathVariable Integer bookID) throws Exception {
        return libraryService.isBookAvailable(bookID);
    }
}
