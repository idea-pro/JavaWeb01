package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 24208
 */
public class Dao {
    /**
     * 注册方法
     */
    public void register(String username, String password) throws SQLException {
        System.out.println(username);
        QueryRunner queryRunner = new QueryRunner();
        Connection conn = DBUtils.getCurrentConnection();
        String sql = "insert into user values (?,?)";
        queryRunner.update(conn, sql, username, password);
    }

    /**
     * 登录方法
     */
    public User login(String username, String password) throws SQLException {

        Connection conn = DBUtils.getCurrentConnection();
        String sql = "select * from user where username=? and password=?";
        QueryRunner queryRunner = new QueryRunner();
        BeanHandler<User> userBeanHandler = new BeanHandler<>(User.class);
        User user = queryRunner.query(conn, sql, userBeanHandler, username, password);
        return user;
    }

    /**
     * 预约方法
     */
    public void reserve(String kind,String name) throws SQLException {
        Connection conn = DBUtils.getCurrentConnection();
        String sql = "insert into reserve values(?,?)";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(conn,sql,kind,name);
    }
}
