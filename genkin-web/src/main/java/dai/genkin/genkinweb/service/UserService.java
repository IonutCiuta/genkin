package dai.genkin.genkinweb.service;

import dai.genkin.genkinweb.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import model.User;
import model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.AuthenticationResult;
import security.Permissions;

/**
 * ionutciuta24@gmail.com on 31.08.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptorService encryptorService;

    public AuthenticationResult register(User user) {
        AuthenticationResult auth;

        if(isUnique(user)) {
            user.setPassword(encryptorService.encrypt(user.getPassword()));
            auth = AuthenticationResult.forUser(userRepository.save(setupUser(user)));
        } else {
            auth = AuthenticationResult.withError(AuthenticationResult.Error.USED_EMAIL);
        }

        return auth;
    }

    public AuthenticationResult login(User user) {
        AuthenticationResult auth;

        List<User> users = userRepository.findByEmail(user.getEmail());
        if(users.isEmpty()) {
            auth = AuthenticationResult.withError(AuthenticationResult.Error.INVALID_EMAIL);
        } else {
            if(encryptorService.check(user.getPassword(), users.get(0).getPassword())) {
                auth = AuthenticationResult.forUser(users.get(0));
            } else {
                auth = AuthenticationResult.withError(AuthenticationResult.Error.INVALID_PASS);
            }
        }

        return auth;
    }

    public void logout(User user) {
        user = userRepository.findByAccessToken(user.getAccessToken());
        user.setAccessToken(null);
        userRepository.save(user);
    }

    public User load(String token) {
        return userRepository.findByAccessToken(token);
    }

    private User setupDefaultUser(User user) {
        return new User.Builder(user)
                .withPermissions(Permissions.DEFAULT)
                .withAccessToken(generateAccessToken())
                .build();
    }

    private User setupPowerUser(User user) {
        return new User.Builder(user)
                .withPermissions(Permissions.WEEKLY_OVERVIEW)
                .withAccessToken(generateAccessToken())
                .build();
    }
    
    private User setupGoldUser(User user) {
        return new User.Builder(user)
                .withPermissions(Permissions.DAILY_OVERVIEW, Permissions.ADD_CATEGORY)
                .withAccessToken(generateAccessToken())
                .build();
    }

    private String generateAccessToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private boolean isUnique(User user) {
        return userRepository.findByEmail(user.getEmail()).isEmpty();
    }

    private User setupUser(User user) {
        if(UserType.DEFAULT.equals(user.getUserType()))
            return setupDefaultUser(user);

        if(UserType.POWER.equals(user.getUserType()))
            return setupPowerUser(user);

        if(UserType.GOLD.equals(user.getUserType()))
            return setupGoldUser(user);

        throw new UnsupportedOperationException("Uknown user type: " + user.getUserType());
    }
}
