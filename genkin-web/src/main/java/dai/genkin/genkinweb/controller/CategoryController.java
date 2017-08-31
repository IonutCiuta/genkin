package dai.genkin.genkinweb.controller;

import dai.genkin.genkinweb.service.CategoryService;
import dai.genkin.genkinweb.service.UserService;
import model.Category;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ionutciuta24@gmail.com on 01.09.2017.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category, @RequestHeader("Authorization") String accessToken) {
        User user = userService.load(accessToken);

        //TODO
        if(user != null) {
            category.setOwnerId(user.getId());

        }

        return null;
    }
}
