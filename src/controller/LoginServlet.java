/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title LoginServlet.java
 * @Package: controller 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月16日 下午2:19:16 
 * @version 1.0.0
 * @since JDK1.8
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className LoginServlet
 * @description
 *
 */
public class LoginServlet extends HttpServlet{
	 /**
	 * 
	 */
  private static final long serialVersionUID = 7518504298513100011L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
  }
	//destroy
  public void destroy() {
  	
  }
}
