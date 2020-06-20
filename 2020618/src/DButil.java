/**
 * @program: 2020618
 * @description
 * 懒汉模式--进化好的
 * @author: mrs.yang
 * @create: 2020 -06 -18 21 :01
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DButil {
    private static volatile DataSource datasourse=null;
    public static Connection getConnection() throws SQLException {
            if(datasourse==null){
                synchronized (DButil.class){
                    if(datasourse==null){
                     MysqlDataSource mysqlDataSource=new MysqlDataSource();
                     mysqlDataSource.setServerName("127.0.0.1");
                     mysqlDataSource.setPort(3306);
                     mysqlDataSource.setUser("root");
                     mysqlDataSource.setPassword("sg7188916");
                     mysqlDataSource.setUseSSL(false);
                     mysqlDataSource.setCharacterEncoding("utf8");
                     datasourse=mysqlDataSource;
                     }
                }
           }
        return (Connection)datasourse.getConnection();
    }
}
