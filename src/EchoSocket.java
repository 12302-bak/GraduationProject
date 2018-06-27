/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title EchoSocket.java
 * @Package:  
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月20日 下午5:36:31 
 * @version 1.0.0
 * @since JDK1.8
 */

/**
 * @className EchoSocket
 * @description
 *
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import log.LogF;

//注解规定了访问的URL
@ServerEndpoint("/echo")
public class EchoSocket {
    /**
     * 客户端有连接的时候就会调用这个方法
     */
	
	  private Process process;
    private static LogF lf=new LogF();
    
    @OnOpen
    public void open(Session session, EndpointConfig config){
        
        LogF.printInfo(lf.getLogger(),"webSocket",session.getId()+"#############");
        try {
       	   /*while(true){
       	  	  session.getBasicRemote().sendText("Apply what one has leared" + "<br>");
       	  	  Thread.sleep(1000);
       	  	 session.getBasicRemote().sendText("this is a  tesst" + "<br>");
       	  	Thread.sleep(1000);
       	   }*/
           // 执行tail -f命令
           //如果非root启动liunux注意权限问题
           //路径改为自己的日志文件路径
           process = Runtime.getRuntime().exec("tail -f D:\\QMHD\\apache-tomcat-8.0.38-windows-x64\\apache-tomcat-8.0.38\\logs\\catalina.txt");
           Thread st=new Thread(new ReadThread(process,session));
           st.start();
             
       } catch (Exception e) {
           // TODO Auto-generated catch block              
      	 LogF.printInfo(lf.getLogger(),"Exception",e.getMessage());
       }
    }
    /**
     * 客户端连接断开就会调用此方法
     */
    @OnClose
    public void close(Session session,CloseReason reason){
    	LogF.printInfo(lf.getLogger(),"webSocket",session.getId() + "连接关闭了");
    }
    
    /**
     * 接收到客户端的信息
     * @param msg
     * @param last
     */
    @OnMessage
    public void message(Session session,boolean last,String msg){
    	LogF.printInfo(lf.getLogger(),"webSocket","客户端说" + msg);
        
    }


     /**
     *错误监听（当没有关闭socket连接就关闭浏览器会异常）
     */
      @OnError
      public void error(Session session, Throwable error){
           String id = session.getId();
           LogF.printInfo(lf.getLogger(),"webSocket","出错的session的id是" + id);
      }
      public EchoSocket(){
      	LogF.printInfo(lf.getLogger(),"webSocket","Socket对象创建");
        //通过对象的创建可以知道不同socket之间的通信不会共享成员变量
    }
}
class ReadThread implements Runnable{
  private Process pro;
  private Session sess;
  BufferedReader reader;
  LogF lf=new LogF();
  
  public ReadThread(Process pro,Session sess){
  	this.pro=pro;
  	this.sess=sess;
  }
  @Override
  public void run() {
  	// 将实时日志通过WebSocket发送给客户端，给每一行添加一个HTML换行
  	String line;
  	StringBuffer stb=new StringBuffer();
  	try {
  		reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
	    while(true) {
	     	if( (line = reader.readLine()) != null){
	     		 stb.append(line + "<br>");
	         
	     	}else{
	     	Thread.sleep(10000);
	     	}
	     	sess.getBasicRemote().sendText(stb.toString());
	     	stb.setLength(0);
	    }
    } catch (Exception e) {
	    
	    e.printStackTrace();
	    LogF.printInfo(lf.getLogger(),"Exception",e.getMessage());
    } 
  }
	
}