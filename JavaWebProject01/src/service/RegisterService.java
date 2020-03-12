package service;

import dao.Dao;
import utils.DBUtils;

import java.sql.SQLException;


/**
 * @author 24208
 */
public class RegisterService {
    public boolean registerUser(String username,String password) {
        Dao dao = new Dao();
        boolean ifSucceed = true;
        try {
            DBUtils.startAffair();
            dao.register(username,password);
        } catch (SQLException e) {
            //如果失败
            ifSucceed = false;
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
        return ifSucceed;
    }
}
