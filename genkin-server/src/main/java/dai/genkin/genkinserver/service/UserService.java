package dai.genkin.genkinserver.service;

import dai.genkin.genkinserver.dao.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ionutciuta24@gmail.com on 18.08.2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(User user) {
        return userRepository.save(user);
    }
}
