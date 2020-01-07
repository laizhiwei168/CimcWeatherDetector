package com.cimc.modbus.utils.log;

import com.cimc.modbus.thread.pool.LogThreadPool;
import com.cimc.modbus.utils.common.Utilty;



public class LogManager {
	private LogManager(){
    }
    private static LogManager manager = new LogManager();
    
    public static LogManager getInstance(){
        return manager;
    }
    private Utilty util= new Utilty();
    //设备获取报文log
    public void PrintGainDeviceLog(String deviceId,byte[] bt){
    	LogThreadPool.init().execute(new  Runnable() {
			public void run() {
				int length=bt.length;
				String data_str=util.toStringByte(bt,0,length-1);				
				DataLogUtil.getLog_Exception().SaveGainDeviceMessage(deviceId.trim(),data_str);
			}
    	});
    }
    
    //设备log
    public void PrintSentDeviceLog(String deviceid,byte[] bt){
    	LogThreadPool.init().execute(new  Runnable() {
			public void run() {
				String data_str=util.toStringByte(bt,0,bt.length-1);
				DataLogUtil.getLog_Exception().SaveSentDeviceMessage(deviceid.trim(),data_str);
			}
    	});
    }
    
    
    
    // 获取websocket推送过来的命令
    public void PrintGainCommandLog(String data_str){
    	LogThreadPool.init().execute(new  Runnable() {
			public void run() {
				DataLogUtil.getLog_Exception().SaveGainCommand(data_str);
			}
    	});
    }
    
	//推送事件log
	public void PrintPushEventdataLog(String data_str){
    	LogThreadPool.init().execute(new  Runnable() {
			public void run() {
				DataLogUtil.getLog_Exception().SavePushEventdata(data_str);
			}
    	});
    }
	
	//电子围栏下发命令log
	public void PrintFenceEventCommandLog(String data_str){
    	LogThreadPool.init().execute(new  Runnable() {
			public void run() {
				DataLogUtil.getLog_Exception().SaveFenceEventCommanddata(data_str);
			}
    	});
    }
    
}
