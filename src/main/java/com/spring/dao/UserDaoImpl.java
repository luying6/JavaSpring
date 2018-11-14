package main.java.com.spring.dao;

import main.java.com.spring.javabean.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author luying
 * @date 2018/11/12
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    @Override
    public void save(Users user) {
        String sql = "insert into user values (adminName, password, age)";
        jdbcTemplate.update(sql, user.getAdminName(), user.getPassword(), user.getAge());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Users users) {
        String sql = "update user set adminName=?, password = ?, age = ? where id = ?";
        jdbcTemplate.update(sql, users.getAdminName(), users.getPassword(), users.getAge(), users.getId());
    }

    @Override
    public Users getUserById(Integer id) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql, (ResultSet resultSet, int i) -> getUser(resultSet), id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Users> getAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (resultSet, i) -> getUser(resultSet));
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Users getUser(ResultSet resultSet) throws SQLException {
        Users user = new Users();
        user.setId(resultSet.getInt("id"));
        user.setAdminName(resultSet.getString("adminName"));
        user.setPassword(resultSet.getString("password"));
        user.setAge(resultSet.getInt("age"));
        user.setCreatTime(resultSet.getString("creatTime"));
        user.setUpdateTime(resultSet.getString("updateTime"));
        return user;
    }

}
