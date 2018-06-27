import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

import log.LogF;

/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title ApplicationConfig.java
 * @Package:  
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月20日 下午5:33:52 
 * @version 1.0.0
 * @since JDK1.8
 */

/**
 * @className ApplicationConfig
 * @description
 *
 */
public class ApplicationConfig implements ServerApplicationConfig{
   private static LogF lf=new LogF();
	
  @Override
  public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
  	LogF.printInfo(lf.getLogger(),"scan websocket number", ""+ scan.size());
    //返回（起到过滤的作用，可以在返回前把里面部分类进行过滤）
    return scan;
  }

	
  //实现接口
  @Override
  public Set<ServerEndpointConfig> getEndpointConfigs(
          Set<Class<? extends Endpoint>> arg0) {
      
      return null;
  }

}
