package com.cimc.modbus.protocol.user;

import org.xsocket.connection.INonBlockingConnection;

public class UserDeviceBean {

	// 处理设备是否还连接服务
	private boolean isConnect=true; 
	
	// xsocket
	private String xsockeId;
	private INonBlockingConnection xsocke;
	
	
	public boolean isConnect() {
		return isConnect;
	}
	public void setConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}
	public String getXsockeId() {
		return xsockeId;
	}
	public void setXsockeId(String xsockeId) {
		this.xsockeId = xsockeId;
	}
	public INonBlockingConnection getXsocke() {
		return xsocke;
	}
	public void setXsocke(INonBlockingConnection xsocke) {
		this.xsocke = xsocke;
	}
	
}
