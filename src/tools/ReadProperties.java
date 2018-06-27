/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title ReadProperties.java
 * @Package: tools 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月25日 下午5:07:07 
 * @version 1.0.0
 * @since JDK1.8
 */
package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @className ReadProperties
 * @description
 *
 */
public class ReadProperties {
	public static Properties getProperties(){  
    InputStream inputStream = ReadProperties.class.getClassLoader().getResourceAsStream("rule.properties");   
    Properties properties = new Properties();  
    try{  
        properties.load(inputStream);  
    }catch (IOException ioE){  
        ioE.printStackTrace();  
    }finally{  
        try {
	        inputStream.close();
        } catch (IOException e) {
	        e.printStackTrace();
        }  
    }  
    return properties;
 }  

  public static Boolean updatePro(String path,String key,String value){  
       
  	ReadProperties.getProperties().setProperty(key, value);
		return false;     
      
  }    
	public static void main(String[] args) {
	   Properties pt=ReadProperties.getProperties();
	   System.out.println("name:"+pt.getProperty("url"));  
  }
}
