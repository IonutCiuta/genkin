package dai.genkin.genkinweb;

import dai.genkin.genkinweb.service.EncryptorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * ionutciuta24@gmail.com on 01.09.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptorServiceTest {

    @Autowired
    private EncryptorService encryptorService;

    @Test
    public void testEncryptor() {
        String input = "pass";
        String hash = encryptorService.encrypt(input);
        assertThat(encryptorService.check(input, hash)).isTrue();
    }
}
