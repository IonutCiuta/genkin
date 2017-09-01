package dai.genkin.genkinweb.service;

import dai.genkin.genkinweb.repository.CategoryRepository;
import model.Category;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ionutciuta24@gmail.com on 01.09.2017.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findCommonCategories() {
        return categoryRepository.findByOwnerId(null);
    }

    public List<Category> findUserCategories(User user) {
        return categoryRepository.findByOwnerId(user.getId());
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
}
