package com.cimc.modbus.app.start;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cimc.modbus.bean.common.ConstantBean;
import com.cimc.modbus.command.socket.XSocketCommadServer;
import com.cimc.modbus.socket.tcp.XSocketServer;


public class AppStart {

	public static void main(String[] args) {
		/**启动Xsocket服务通讯*/
		Integer PORT = null;
		String XSOCKET_PORT=ConstantBean.constantMap.get("XSOCKET_PORT");
		if(XSOCKET_PORT!=null&&!"".equals(XSOCKET_PORT)){
			 PORT=Integer.parseInt(XSOCKET_PORT);
			//PORT=78;
		}
		XSocketServer projectServer = new XSocketServer(PORT);
	    projectServer.start();
	    
	    
	    /**开启命令接收socket服务端*/
		/*ExecutorService Quartz_exc= Executors.newSingleThreadExecutor();
		try {
		  Quartz_exc.execute(new Runnable() {
			@Override
			public void run() {
				XSocketCommadServer projectServer = new XSocketCommadServer(7002);
			    projectServer.start();
			}
		  });
		} catch (Exception e) {
		}finally{
		    Quartz_exc.shutdown();
		}*/
	}
}
