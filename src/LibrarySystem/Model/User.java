package LibrarySystem.Model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 3778249816731518887L;
    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Auth authorization;

    public User(String username, String pwd, Auth auth) {
        this.username = username;
        this.password = pwd;
        this.authorization = auth;
    }

    public boolean equals(Object ob) {
        if (ob == null) {
            return false;
        }
        if (!(ob instanceof User)) {
            return false;
        }
        User u = (User) ob;
        return this.username.equals(u.username) && this.password.equals(u.password);
    }

}
