/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title ReadPro.java
 * @Package: controller.properties 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月25日 下午5:23:35 
 * @version 1.0.0
 * @since JDK1.8
 */
package controller.properties;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import tools.ReadProperties;

/**
 * @className ReadPro
 * @description
 *
 */
public class ReadPro extends HttpServlet {

	/**
	 * 
	 */
  private static final long serialVersionUID = -4156108514338011911L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	 
	  response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式  
	  response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题  
	    
	  PrintWriter out =null ;  
	  out =response.getWriter() ;  
	  
	  Properties pp=ReadProperties.getProperties();
	  Map<String,String> map=new HashMap<String,String>();
	  map.put("url", pp.getProperty("url"));
	  map.put("rule", pp.getProperty("rule"));
	  String jsonStr=JSON.toJSONString(map);
	  out.write(jsonStr);  
	  out.close();  
  }
	//destroy
  public void destroy() {
  	
  }
}
