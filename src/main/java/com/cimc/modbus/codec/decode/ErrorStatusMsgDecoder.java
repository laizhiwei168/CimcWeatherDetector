package com.cimc.modbus.codec.decode;

import com.cimc.modbus.codec.data.PackageData;
import com.cimc.modbus.utils.common.Utilty;

public class ErrorStatusMsgDecoder {
	
private Utilty utilty=new Utilty();
	
	public void toStatusfoUploadMsg(PackageData packageData) {
		byte[] body_bt=packageData.getMsgBodyBytes();
		//System.out.println(utilty.toStringByte(body_bt, 0, body_bt.length-1));
		int address =utilty.bytes2Int(body_bt, 0, 1);
		int msg_type =utilty.bytes2Int(body_bt, 1, 1);
		int error =utilty.bytes2Int(body_bt, 2, 1);
		System.out.print("address:"+address+"   msg_type:读取圈数状态   ");
		switch (error) {
		case 1:				
			System.out.println("error：功能码错误");
			break;
		case 2:				
			System.out.println("error：起始地址错误");
			break;
		case 3:				
			System.out.println("error：寄存器数量错误");
			break;
		case 4:				
			System.out.println("error：从站设备故障（如设备不在线）");
			break;
		case 5:				
			System.out.println("error：协议标识符错误");
			break;
		case 6:				
			System.out.println("error：请求包长度错误");
			break;
	 }
	}
}
