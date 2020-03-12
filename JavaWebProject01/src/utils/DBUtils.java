package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 操作数据库
 */
public class DBUtils {
    private static DataSource ds = new ComboPooledDataSource();
    /**使用ThreadLocal来存储Connection连接*/
    private  static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    /**获取连接池对象*/
    public static DataSource getDataSource() {
        return ds;
    }
    /**获取当前线程连接对象*/
    public static Connection getCurrentConnection() throws SQLException {
        Connection conn = tl.get();
        //如果目前无Connection对象
        if(conn == null) {
            conn = ds.getConnection();
            tl.set(conn);
        }
        return conn;
    }
    /**事务处理*/
    public static void startAffair() throws SQLException {
        Connection conn = getCurrentConnection();
        if(conn != null) {
            conn.setAutoCommit(false);
        }
    }

    public static void rollAffair() throws SQLException {
        Connection conn = getCurrentConnection();
        if(conn != null) {
            conn.rollback();
        }
    }

    public static void endAffair() throws SQLException {
        Connection conn = getCurrentConnection();
        if(conn != null) {
            conn.commit();
            conn.close();
            //移除绑定
            tl.remove();
        }
    }
}
