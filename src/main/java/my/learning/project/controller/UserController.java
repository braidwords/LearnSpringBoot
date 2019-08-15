package my.learning.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.learning.project.exception.NotFoundException;
import my.learning.project.schema.Users;
import my.learning.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "User management", tags ="User management")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Get all users", tags = "User management")
    public List<Users> getAllUser() {
        return userService.getAllUser();
    }

    @ResponseBody
    @GetMapping("/{id}")
    @ApiOperation(value = "Get a specific user", tags = "User management")
    public Users getSpecificUser(@PathVariable int id) throws NotFoundException {
        return userService.getSpecificUser(id);
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Add a new user", tags = "User management")
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "Update an existing user", tags = "User management")
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an existing user", tags = "User management")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return String.format("User with ID : {%s} deleted", id);
    }
}
