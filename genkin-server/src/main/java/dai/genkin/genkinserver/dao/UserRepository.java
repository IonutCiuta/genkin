package dai.genkin.genkinserver.dao;

import model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ionutciuta24@gmail.com on 18.08.2017.
 */
public interface UserRepository extends MongoRepository<User, String>{
}
