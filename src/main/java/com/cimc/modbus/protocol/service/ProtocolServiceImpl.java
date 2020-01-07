package com.cimc.modbus.protocol.service;

import java.io.IOException;

import org.xsocket.connection.INonBlockingConnection;

import com.cimc.modbus.codec.common.MSConsts;
import com.cimc.modbus.codec.data.InformationPackageData;
import com.cimc.modbus.codec.data.PackageData;
import com.cimc.modbus.codec.decode.InformationMsgDecoder;
import com.cimc.modbus.codec.decode.MsgDecoder;
import com.cimc.modbus.codec.encode.MsgEncoder;
import com.cimc.modbus.manager.subscribe.factory.SubscribeFactory;
import com.cimc.modbus.protocol.user.DeviceUserController;
import com.cimc.modbus.thread.pool.SubscribePool;
import com.cimc.modbus.utils.log.LogManager;

/**
 * 协议中枢控制层
 * 
 * @author lzw
 *
 */
public class ProtocolServiceImpl {

	public Object dealWithData(final byte[] bt,INonBlockingConnection nbc) {
		byte[] re_msg_by=null;
		DeviceUserController deviceUserC= DeviceUserController.getInstance();
		// 解析报文结构
		MsgDecoder msgDecoder=new MsgDecoder();
		PackageData packageData=msgDecoder.bytes2PackageData(bt);		
		//System.out.println(packageData);
		
		// 过滤掉非法报文
		String deviceId=null;
		if(packageData==null){
			LogManager.getInstance().PrintGainDeviceLog("deivce",bt);//打印log
			return null;
		}else{// 处理设备记录和设备号获取
			//记录设备上传报文
			deviceId=packageData.getDeviceId();
			if(deviceId!=null){				
				LogManager.getInstance().PrintGainDeviceLog(deviceId,bt);
				deviceUserC.handleDeviceController(deviceId, nbc);// 调用用户管理
			}else{
				deviceId= deviceUserC.getdeviceId(nbc.getId());
				if(deviceId!=null){
					LogManager.getInstance().PrintGainDeviceLog(deviceId,bt);
				}
			}
		}
		System.out.println("deviceId:"+deviceId);
		
		if(MSConsts.msg_cimc_protocol_handshake==packageData.getProtocol()){
			// 处理握手协议
			try {
				MsgEncoder msgEncoder=new MsgEncoder();
				re_msg_by=msgEncoder.encode4TerminalHandshakeResp(packageData,new byte[]{(byte) 0x80});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(MSConsts.msg_cimc_protocol_modbus==packageData.getProtocol()){			
			// 信息报文
		   if (MSConsts.msg_cimc_terminal_Information_req == packageData.getMessageID()) {
				try {					
					InformationMsgDecoder informationMsgDecoder =new InformationMsgDecoder();
					InformationPackageData data=informationMsgDecoder.toInformationfoUploadMsg(packageData);
					HandldSubscribeData(deviceId,packageData.getMessageID(), data);
					MsgEncoder msgEncoder=new MsgEncoder();
					re_msg_by=msgEncoder.encode4TerminalHandCommonResp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 命令报文
			else if (MSConsts.msg_cimc_terminal_Command_req == packageData.getMessageID()) {
				try {
									
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		        
		return re_msg_by;
	}
	
	/**处理业务数据并操作数据库*/
	public void HandldSubscribeData(String phoneNumber,int MsgId,Object objectNode){
		if(phoneNumber!=null && !"".equals(phoneNumber)){
        SubscribePool.init().execute(new  Runnable() {
 			public void run() {
 				SubscribeFactory subscribeFactory=new SubscribeFactory();
 				subscribeFactory.pushDataToPlatform(phoneNumber,MsgId,objectNode);
 			}
 		});
		}
	}
}
