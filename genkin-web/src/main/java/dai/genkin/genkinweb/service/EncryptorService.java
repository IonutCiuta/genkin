package dai.genkin.genkinweb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * ionutciuta24@gmail.com on 31.08.2017.
 */
@Component
public class EncryptorService {
    public String encrypt(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt());
    }

    public boolean check(String input, String hash) {
        return BCrypt.checkpw(input, hash);
    }
}
