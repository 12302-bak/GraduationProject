/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title VerifyNamePwd.java
 * @Package: tools 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月17日 下午2:39:06 
 * @version 1.0.0
 * @since JDK1.8
 */
package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @className VerifyNamePwd
 * @description
 *
 */
public class VerifyNamePwd {
	public static Map<String,String> getName(){
		Map<String,String> mp=new HashMap<String,String>();
		String sql="select * from user";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConnection();
	    st=con.createStatement();
	    rs=st.executeQuery(sql);
	    while(rs.next()){
	    	mp.put(rs.getString("name"), rs.getString("passwd"));
	    }
	  
    } catch (SQLException e) {
	    e.printStackTrace();
    }
		return mp;
	}
}
