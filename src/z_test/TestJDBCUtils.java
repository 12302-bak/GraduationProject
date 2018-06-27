/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title testJDBCUtils.java
 * @Package: test 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月17日 下午3:03:30 
 * @version 1.0.0
 * @since JDK1.8
 */
package z_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import log.LogF;
import tools.JDBCUtil;

/**
 * @className testJDBCUtils
 * @description
 *
 */
public class TestJDBCUtils {
	private static LogF lf=new LogF();
	public static void main(String[] args) {
		Connection conn=JDBCUtil.getConnection();  
    LogF.printInfo(lf.getLogger(),"conn", conn.toString());
    try {  
        PreparedStatement stmt=conn.prepareStatement("select * from user");  
        ResultSet re=stmt.executeQuery();  
        while(re.next()){  
            String name=re.getString(2);  
            LogF.printInfo(lf.getLogger(),"name:",name);
              
        }  
          
          
    } catch (SQLException e) {  
        LogF.printDebug(lf.getLogger(), "SqlException", e.getMessage());
    }  
  }
}
