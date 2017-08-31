package security;

import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Ionut Ciuta on 8/29/2017.
 */
public class AuthenticationResult {
    private String accessToken;
    private List<String> permissions;
    private String error;

    private AuthenticationResult() {}

    public static AuthenticationResult forUser(User user) {
        AuthenticationResult authenticationResult = new AuthenticationResult();
        authenticationResult.setAccessToken(user.getAccessToken());
        authenticationResult.setPermissions(user.getPermissions());
        return authenticationResult;
    }

    public static AuthenticationResult withError(String error) {
        AuthenticationResult authenticationResult = new AuthenticationResult();
        authenticationResult.setError(error);
        return authenticationResult;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    private void addPermission(String permission) {
        this.permissions.add(permission);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static class Error {
        public static final String USED_EMAIL = "used_email";
        public static final String INVALID_EMAIL = "invalid_email";
        public static final String INVALID_PASS = "invalid_pass";
    }
}
