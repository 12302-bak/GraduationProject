/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title ServletTest.java
 * @Package: Controller 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月16日 下午1:38:28 
 * @version 1.0.0
 * @since JDK1.8
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className ServletTest
 * @description
 *
 */
public class ServletTest extends HttpServlet{
  /**
	 * 
	 */
  private static final long serialVersionUID = 509538556343466211L;
	//handle post request
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	  
      response.setContentType("text/html");
      response.setCharacterEncoding("gb2312");
      
      PrintWriter out = response.getWriter();
      String name = request.getParameter("USERNAME");

      out.println("Your Name : " + name);

  }
  //destroy
  public void destroy() {}
}
