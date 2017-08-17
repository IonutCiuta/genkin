package dai.genkin.genkinserver.controller;

import dai.genkin.genkinserver.service.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ionutciuta24@gmail.com on 18.08.2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }
}
