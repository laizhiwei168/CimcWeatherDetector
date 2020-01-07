package com.cimc.modbus.protocol.user;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.xsocket.connection.INonBlockingConnection;

import com.cimc.modbus.command.handle.DeviceCommand;

public class DeviceUserController {
	private DeviceUserController(){
    }
    private static DeviceUserController manager = new DeviceUserController();
    
    public static DeviceUserController getInstance(){
        return manager;
    }
    
    ExecutorService device_xsocket_exc= Executors.newSingleThreadExecutor();
	public void handleDeviceController(String deviceId,INonBlockingConnection nbc){
		device_xsocket_exc.execute(new  Runnable() {
			public void run() {
				int results=DeviceUserManager.getInstance().addDeviceUser(deviceId, nbc);
		    	// 过滤掉位置报文后，执行命令下发
		    	if(results>0){
		    		DeviceCommand deviceCommand=new DeviceCommand();
		    		deviceCommand.sendCacheCommand(deviceId, nbc);
		    	}		    	
			}
		});
	}
	
	public String getdeviceId(String xsockeId){
		return DeviceUserManager.getInstance().getdeviceId(xsockeId);
	}
}
