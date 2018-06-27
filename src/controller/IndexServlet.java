/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title IndexServlet.java
 * @Package: controller 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月19日 下午5:35:07 
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
 * @className IndexServlet
 * @description
 *
 */
public class IndexServlet extends HttpServlet{

	/**
	 * 
	 */
  private static final long serialVersionUID = 2422685430097614475L;

  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	String userI=(String)request.getSession().getAttribute("userinfo");
  	request.setAttribute("userInfo", userI);  
  	request.getRequestDispatcher("/index.jsp").forward(request, response);
  }
	//destroy
  public void destroy() {
  	
  }
}
