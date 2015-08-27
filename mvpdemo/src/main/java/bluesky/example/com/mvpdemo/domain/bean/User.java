package bluesky.example.com.mvpdemo.domain.bean;

import java.io.Serializable;

/**
 * Created by Bluesky on 2015/8/27.
 */
public class User implements Serializable {
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }
}
