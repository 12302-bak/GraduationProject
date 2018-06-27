/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title VerifyIsLoginFilter.java
 * @Package: tools 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月16日 下午2:46:02 
 * @version 1.0.0
 * @since JDK1.8
 */
package tools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import log.LogF;

/**
 * @className VerifyIsLoginFilter
 * @description
 *
 */
@WebServlet("/VerifyIsLoginFilter")
public class VerifyIsLoginFilter implements Filter{
	LogF lf=new LogF();
	HttpSession session =null;
	
  @Override
  public void destroy() {
	  session.invalidate();
  }

	
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
  	
  	//String url=request.getServletContext().getRealPath("/");
	  //System.out.println(url);
  	HttpServletRequest req = (HttpServletRequest) request;  
    session = req.getSession();  
    // 如果session不为空，则可以浏览其他页面  
    //这里判断目录，后缀名，当然也可以写在web.xml中，用url-pattern进行拦截映射  
    String url=req.getServletPath();
    String js=(String) url.substring(url.length()-3, url.length());
    LogF.printInfo(lf.getLogger(),"log", url);
    if(url.contains(".css") ||js.contains(".js") || url.contains(".png")|| url.contains(".jpg")
    		|| "/login".equals(url) ||"/AjaxVerify".equals(url)|| "/echo".equals(url)){
    	chain.doFilter(request, response);
    }else{
    	if (session.getAttribute("userinfo")!=null && !"".equals((String)session.getAttribute("userinfo"))) {
    		chain.doFilter(request, response);
      }else{
      	 session.invalidate();  
         response.setContentType("text/html;charset=utf-8");  
         PrintWriter out = response.getWriter();  
         out.println("<script language='javascript' type='text/javascript'>");  
         out.println("alert('Session失效!请重新登录!');window.location.href='" + req.getContextPath() + "/login'");  
         out.println("</script>"); 
      }
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
    // 获取初始化参数  获取参数然后初始化
    String site = config.getInitParameter("name");
    // 输出初始化参数
    LogF.printInfo(lf.getLogger(),"name:", site);
    
  }

}
