package my.learning.project.controller;

import my.learning.project.entity.User;
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
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public User getSpecificUser(int id) {
        return userService.getSpecificUser(id);
    }

    @PostMapping
    @ResponseBody
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @PutMapping
    @ResponseBody
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public String deleteUser(int id) {
        userService.deleteUser(id);
        return String.format("User with ID : {%s} deleted", id);
    }
}
