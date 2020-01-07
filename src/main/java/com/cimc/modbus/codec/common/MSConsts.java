package com.cimc.modbus.codec.common;

public class MSConsts {
	
	// 标识位
    public static final int pkg_identifier = 0x1501;
    public static final int pkg_identifier2 = 0x0060;
    
    // 协议
    public static final int msg_cimc_protocol_handshake = 0x2222;	
    public static final int msg_cimc_protocol_modbus = 0x0000;	
    
    // 终端通用应答 
 	public static final int msg_cimc_terminal_Information_req = 0x60;
 	//public static final int msg_cimc_terminal_Status_req = 0x01;
 	public static final int msg_cimc_terminal_Command_req = 0x10;
 	
 	//public static final int msg_cimc_terminal_Information_error_req = 0x83;
 	//public static final int msg_cimc_terminal_Status_error_req = 0x81;
 	//public static final int msg_cimc_terminal_Command_error_req = 0x90;
 	
 	
 	/**================*/ 	
    // 平台通用应答
 	public static final int cmd_cimnc_common_resp = 0x0001;

}
