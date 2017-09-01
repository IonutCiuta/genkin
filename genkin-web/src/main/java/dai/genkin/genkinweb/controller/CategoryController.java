package dai.genkin.genkinweb.controller;

import dai.genkin.genkinweb.service.CategoryService;
import dai.genkin.genkinweb.service.UserService;
import java.util.List;
import model.Category;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        if(user != null) {
            category.setOwnerId(user.getId());
            return categoryService.addCategory(category);
        } else {
            throw new UnsupportedOperationException("Unknown user: " + accessToken);
        }
    }

    @GetMapping("/all")
    public List<Category> getAllCategories(@RequestHeader("Authorization") String accessToken) {
        User user = userService.load(accessToken);

        if(user != null) {
            List<Category> categories = categoryService.findCommonCategories();
            categories.addAll(categoryService.findUserCategories(user));
            return categories;
        } else {
            throw new UnsupportedOperationException("Unknown user: " + accessToken);
        }
    }
}
