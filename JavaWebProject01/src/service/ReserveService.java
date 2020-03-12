package service;

import dao.Dao;
import utils.DBUtils;

import java.sql.SQLException;

/**
 * @author 24208
 */
public class ReserveService {
    public boolean reserve(String kind,String name) {
        Dao dao = new Dao();
        boolean ifSucceed = true;
        try {
            //开启事务
            DBUtils.startAffair();
            dao.reserve(kind,name);
        } catch (SQLException e) {
            //失败则事务回滚
            ifSucceed = false;
            try {
                DBUtils.rollAffair();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                DBUtils.endAffair();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ifSucceed;
    }
}
