package my.learning.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.learning.project.exception.BadRequestException;
import my.learning.project.schema.Users;
import my.learning.project.service.LibraryService;
import my.learning.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
@Api(value = "Library management", tags ="Library management")
public class LibraryController implements ILibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Issue or return a book", tags = "Library management")
    public Users issueOrReturnBook(@RequestParam(name = "userid") Integer userID, @RequestParam(name = "bookid") Integer bookID, @RequestParam(name = "type") Character type) throws Exception {
        Users user;
        if (type == 'I') {
            user = libraryService.issueBook(userID, bookID);
        } else if (type == 'R') {
            user = libraryService.returnBook(userID, bookID);
        } else {
            throw new BadRequestException("Only I (Issue) and R (Return) are allowed in the request along with userid and bookid");
        }
        return user;
    }

    @GetMapping("/{bookid}")
    @ApiOperation(value = "Check if book available", tags = "Library management")
    public String isBookAvailable(@PathVariable Integer bookid) throws Exception {
        return libraryService.isBookAvailable(bookid);
    }
}
