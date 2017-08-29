package security;

import java.util.ArrayList;
import java.util.List;

/**
 * Ionut Ciuta on 8/29/2017.
 */
public class AuthenticationResult {
    private String accessToken;
    private List<String> permissions;

    public AuthenticationResult() {
        this.permissions = new ArrayList<String>();
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
}
