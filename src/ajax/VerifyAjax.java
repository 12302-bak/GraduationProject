/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title VerifyAjax.java
 * @Package: ajax 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月17日 下午7:31:40 
 * @version 1.0.0
 * @since JDK1.8
 */
package ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.VerifyNamePwd;

/**
 * @className VerifyAjax
 * @description
 *
 */
public class VerifyAjax extends HttpServlet{

  /**
	 * 
	 */
  private static final long serialVersionUID = 4792861782903283924L;



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		response.setCharacterEncoding("utf-8"); 

		
		String name = request.getParameter("name");
		String pwd =request.getParameter("pwd");
		
		String str="false";
    
    Map<String,String> map=VerifyNamePwd.getName();
 		for(Map.Entry<String,String> entry:map.entrySet()){  
 			if(name!=null && pwd !=null){
 				if(name.equals(entry.getKey())){
 					if(pwd.equals(entry.getValue())){
 						  str="true"; 
							HttpSession session=request.getSession(true);  
					    session.setMaxInactiveInterval(1800);
 						  request.getSession().setAttribute("userinfo",entry.getKey());
 					}   
 				}
 			}
 		}
	  //写入到前台               
 		response.getWriter().write(str);
  }
  
  
  //destroy
  public void destroy() {}
}
