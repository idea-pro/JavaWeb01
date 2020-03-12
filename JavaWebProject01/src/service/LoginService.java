package service;

import dao.Dao;
import domain.User;
import utils.DBUtils;

import java.sql.SQLException;

/**
 * @author 24208
 */
public class LoginService {
    public User login(String username,String password) {
        Dao dao = new Dao();
        User user = null;
        try {
            DBUtils.startAffair();
            user = dao.login(username,password);
        } catch (SQLException e) {
            try {
                DBUtils.rollAffair();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DBUtils.endAffair();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
