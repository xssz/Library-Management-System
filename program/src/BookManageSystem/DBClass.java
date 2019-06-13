
package BookManageSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBClass 
{
    static private Connection con;    //声明
    public static Connection getConnection() throws Exception
    {
        if(con==null)
        {
           Class.forName("com.mysql.jdbc.Driver");  //加载指定类
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","niit1234");
              
        }
            return con;
    }
}
