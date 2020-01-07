package com.cimc.modbus.codec.encode;

import java.io.IOException;

import com.cimc.modbus.codec.data.PackageData;
import com.cimc.modbus.utils.common.Utilty;


public class MsgEncoder {
	private Utilty utilty=new Utilty();
	
	// 回复通用应答
	public byte[] encode4TerminalHandshakeResp(PackageData packageData,byte[] additionalContent) throws IOException{
		int length=additionalContent.length;
		byte[] msgHeaderAndBody=utilty.concatAll(
				utilty.int2Bytes(packageData.getIdentifier(),2),
				utilty.int2Bytes(packageData.getProtocol(),2),
				utilty.int2Bytes(length,2),
				additionalContent);		
		return msgHeaderAndBody;
	}
	
	public byte[] encode4TerminalHandCommandResp(byte[] additionalContent) throws IOException{
		int length=additionalContent.length;
		byte[] msgHeaderAndBody=utilty.concatAll(
				new byte[]{0x15,0x01,0x00,0x00},
				utilty.int2Bytes(length,2),
				additionalContent);		
		return msgHeaderAndBody;
	}
	
	public byte[] encode4TerminalHandCommonResp() throws IOException{
		byte[] msgHeaderAndBody=new byte[]{0x15,0x01,0x00,0x00,0x00, 0x02 ,0x01, 0x60};				
		return msgHeaderAndBody;
	}
	
	/**
	 byte[] body=utilty.concatAll(utilty.int2Bytes(packageData.getFlowId(),2),utilty.int2Bytes(packageData.getMessageID(),2),new byte[]{0x00});
		byte[] headerAndBody= encodMsg(packageData,MSConsts.cmd_cimc_register_resp,body);
		//System.out.println(utilty.toStringByte(headerAndBody, 0, headerAndBody.length-1) );
		byte[] crc_bys= utilty.int2Bytes(utilty.CRC16IBM(headerAndBody,headerAndBody.length),2);
		byte[] msgHeaderAndBody=utilty.concatAll(headerAndBody, crc_bys);
		return msgHeaderAndBody;
	 */
}
