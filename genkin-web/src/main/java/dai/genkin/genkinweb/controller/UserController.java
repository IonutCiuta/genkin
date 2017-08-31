package dai.genkin.genkinweb.controller;

import dai.genkin.genkinweb.service.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.AuthenticationResult;

/**
 * Ionut Ciuta on 8/29/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public AuthenticationResult register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthenticationResult login(@RequestBody User user) {
        return userService.login(user);
    }
}
