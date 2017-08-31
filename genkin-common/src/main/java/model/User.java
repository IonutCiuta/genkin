package model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ionutciuta24@gmail.com on 18.08.2017.
 */
public class User {
    @Id
    private String id;
    private String email;
    private String username;
    private String password;
    private String userType;
    private String accessToken;
    private List<String> permissions = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public static class Builder {
        private User user;

        private Builder() {}

        public Builder(User user) {
            this.user = user;
        }

        public Builder withPermissions(String... permissions) {
            user.setPermissions(Arrays.asList(permissions));
            return this;
        }

        public Builder withAccessToken(String accessToken) {
            user.setAccessToken(accessToken);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
