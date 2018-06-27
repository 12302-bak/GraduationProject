/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title LogoutServlet.java
 * @Package: controller 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月19日 下午9:02:44 
 * @version 1.0.0
 * @since JDK1.8
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @className LogoutServlet
 * @description
 *
 */
public class LogoutServlet extends HttpServlet{
	/**
	 * 
	 */
  private static final long serialVersionUID = -9078626262892394062L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	HttpSession hs=request.getSession();
  	hs.invalidate();
  	request.getRequestDispatcher("/login").forward(request, response);
  }
}
