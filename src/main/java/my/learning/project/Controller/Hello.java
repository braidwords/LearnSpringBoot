package my.learning.project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/welcome")
    public String return_hello()
    {
        return "Hi. Welcome to the Public Library Portal.";
    }
}
