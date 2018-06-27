/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title LogF.java
 * @Package: log 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月21日 下午4:13:46 
 * @version 1.0.0
 * @since JDK1.8
 */
package log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @className LogF
 * @description
 *
 */
public class LogF {
	 Log logger=null;
	
	public LogF(){
		logger =  LogFactory.getLog("myLog");
		
		
	}
	public static void printWran(Log logger,String className, String strWran) {
		logger.warn("["+className+"]"+strWran);
	}

	public static void printInfo(Log logger,String className, String strInfo) {
		logger.info("["+className+"]"+strInfo);
	}

	public static void printError(Log logger,String className,String strError) {
		logger.error("["+className+"]"+strError);
	}

	public static void printDebug(Log logger,String className, String strDebug) {
		logger.debug("["+className+"]"+strDebug);
	}
	
	
	
	//Getter && Setter
	public Log getLogger() {
		return logger;
	}
	public void setLogger(Log logger) {
		this.logger = logger;
	}

}

