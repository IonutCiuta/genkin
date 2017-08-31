package dai.genkin.genkinweb.repository;

import model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * ionutciuta24@gmail.com on 01.09.2017.
 */
public interface CategoryRepository extends MongoRepository<Category, String> {
    public List<Category> findByOwnerId(String ownerId);
}
