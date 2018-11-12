package main.java.com.spring.javabean;

/**
 * @author luying
 * @date 2018/11/12
 */
public class UserInfo {
    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String userInfo(){
        String ui = user.getName()+"的身高"+user.getHeight()+"cm";
        return ui;
    }
}
