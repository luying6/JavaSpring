package main.java.com.spring.dao;

import main.java.com.spring.javabean.Users;

import java.util.List;

/**
 * @author luying
 * @date 2018/11/12
 */
public interface UserDao {
    void save(Users user);
    void delete(Integer id);
    void update(Users users);
    Object getUserById(Integer id);
    int getTotalCount();
    List<Users> getAll();
}
