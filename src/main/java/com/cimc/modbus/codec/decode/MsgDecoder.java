package com.cimc.modbus.codec.decode;

import com.cimc.modbus.codec.common.MSConsts;
import com.cimc.modbus.codec.data.PackageData;
import com.cimc.modbus.utils.common.Utilty;


public class MsgDecoder {
	private Utilty utilty=new Utilty();
	public PackageData bytes2PackageData(byte[] data) {
		// 识别报文标识
		if(MSConsts.pkg_identifier != utilty.bytes2Int(data, 0, 2) &&  MSConsts.pkg_identifier2 != utilty.bytes2Int(data, 0, 2)){
			return null;
		}
		
		PackageData packageData=null;
	   	try{
	   		packageData=new PackageData();
			packageData.setIdentifier(utilty.bytes2Int(data, 0, 2));
			packageData.setProtocol(utilty.bytes2Int(data, 2, 2));
			packageData.setMsgBodyLength(utilty.bytes2Int(data, 4, 2));
			if(0x2222==packageData.getProtocol()){
				// 处理握手报文
				String deviceId=utilty.convertHexToString(utilty.toStringByte(data,6,5+packageData.getMsgBodyLength()));
				packageData.setDeviceId(deviceId);
			}else if(0==packageData.getProtocol()){
				//  处理modbus报文
				packageData.setElement(data[6] & 0xff);
				packageData.setMessageID(data[7] & 0xff);
				byte[] tmp = new byte[utilty.bytes2Int(data, 4, 2)];
				System.arraycopy(data, 6, tmp, 0, tmp.length);
				packageData.setMsgBodyBytes(tmp);	
			}
					
	   	} catch(Exception e){
	   		System.out.println(" == == 无法识别设备的设备号位数  或 设备内容长度有误  == == ");
	   	}
		return packageData;
	}
}
