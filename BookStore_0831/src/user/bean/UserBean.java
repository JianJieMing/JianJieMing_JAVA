package user.bean;

/**
 * @author 铭
 * DATE: 18/9/5 下午7:30
 */
public class UserBean {
    private int uid;
    private String username;
    private String password;
    private String email;
    private String state;

    public UserBean() {
    }

    public UserBean(int uid, String username, String password, String email, String state) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
