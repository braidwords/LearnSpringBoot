package my.learning.project.controller;

import my.learning.project.schema.Users;
import my.learning.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public List<Users> getAllUser() {
        return userService.getAllUser();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Users getSpecificUser(int id) {
        return userService.getSpecificUser(id);
    }

    @PostMapping
    @ResponseBody
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PutMapping
    @ResponseBody
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteUser(int id) {
        userService.deleteUser(id);
        return String.format("User with ID : {%s} deleted", id);
    }
}
