/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title JDBCUtil.java
 * @Package: tools 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月17日 下午3:01:04 
 * @version 1.0.0
 * @since JDK1.8
 */
package tools;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @className JDBCUtil
 * @description
 *
 */
public class JDBCUtil {

  private static DataSource dataSource=null;  
  static{  
      dataSource=new ComboPooledDataSource("mysql");  
  }  
    
  /** 
   * 获取数据库连接 
   * @return 
   */  
  public static Connection getConnection(){  
      Connection conn=null;  
      try {  
           conn=dataSource.getConnection();  
      } catch (SQLException e) {  
          e.printStackTrace();  
      }  
      return conn;  
  }  

    
  /** 
   * 关闭数据库连接 
   * @param conn 
   */  
  public static void closeConn(Connection conn){  
      try {  
          if(conn!=null && conn.isClosed()){  
              conn.close();  
          }  
      } catch (SQLException e) {  
          e.printStackTrace();  
      }  
  }  
}  
