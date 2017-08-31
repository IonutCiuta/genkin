package dai.genkin.genkinweb;

import http.RequestBuilder;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import security.AuthenticationResult;

/**
 * ionutciuta24@gmail.com on 31.08.2017.
 */
@Service
public class UserService {
    @Value("${genkin.server.url}")
    private String genkinServerUrl;

    @Autowired
    private RestTemplate restTemplate;

    public AuthenticationResult register(User user) {
        String url = UriComponentsBuilder
                .fromHttpUrl(genkinServerUrl)
                .pathSegment("user/register")
                .build().toUriString();

        return RequestBuilder
                .prepareCall(url)
                .withPostMethod()
                .withBody(user)
                .makeCall(restTemplate, AuthenticationResult.class)
                .getBody();
    }

    public AuthenticationResult login(User user) {
        String url = UriComponentsBuilder
                .fromHttpUrl(genkinServerUrl)
                .pathSegment("user/login")
                .build().toUriString();

        return RequestBuilder
                .prepareCall(url)
                .withPostMethod()
                .withBody(user)
                .makeCall(restTemplate, AuthenticationResult.class)
                .getBody();
    }
}
