package dai.genkin.genkinserver.controller;

import dai.genkin.genkinserver.service.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ionutciuta24@gmail.com on 18.08.2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.register(user);
    }
}
