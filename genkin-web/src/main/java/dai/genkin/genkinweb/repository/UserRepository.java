package dai.genkin.genkinweb.repository;

import model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * ionutciuta24@gmail.com on 31.08.2017.
 */
public interface UserRepository extends MongoRepository<User, String>{
    public List<User> findByEmail(String email);
}
