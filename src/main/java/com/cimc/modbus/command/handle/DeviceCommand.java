package com.cimc.modbus.command.handle;

import org.xsocket.connection.INonBlockingConnection;

import com.cimc.modbus.codec.encode.MsgEncoder;
import com.cimc.modbus.command.cache.CommandCache;
import com.cimc.modbus.command.common.ParameterConfigurationBean;
import com.cimc.modbus.command.tool.AssemblyCommandTool;
import com.cimc.modbus.command.tool.EncodeCommand;
import com.cimc.modbus.utils.common.Utilty;
import com.cimc.modbus.utils.log.LogManager;




public class DeviceCommand {
	//private TerminalMsgProcessService msgProcessService=new TerminalMsgProcessService();
	public void sendCacheCommand(String deviceId,INonBlockingConnection nbc){
		//Full_commandPo full_command=new Full_commandPo();
		ParameterConfigurationBean pc_po=null;
		String terminalPhone=deviceId;
		String idAndtypeAndcontent=CommandCache.getInstance().getCommandCache(terminalPhone);
		if(!"".equals(idAndtypeAndcontent.trim())){
			String[] strs=idAndtypeAndcontent.split("=");
			if(1<strs.length && strs.length<=7){
				String id=strs[0];
				String msg_type=strs[1];
				String address=strs[2];
				String start_loct=strs[3];
				String eq_number=strs[4];
				String command_type="";
				String command_content="";
				if(strs.length>5){
					 command_type=strs[5];
					 command_content=strs[6];
				}				
				//System.out.println(id+" - "+msg_type+" - "+start_loct+" - "+end_loct+" - "+command_type+" - "+command_content);
				if(!"".equals(msg_type) && !"".equals(address) && !"".equals(start_loct) && !"".equals(eq_number)){//这是防止非法命令，内容为空是查询命令 PlatformConversionCommand
					String[] l_command_type=command_type.split(",");
					String[] l_command_content=command_content.split(",");
					AssemblyCommandTool assemblyCommandTool=new AssemblyCommandTool();
					pc_po=assemblyCommandTool.HandleAssemblyCommand( msg_type,address, start_loct, eq_number,l_command_content, l_command_type);
				}
				//full_command.setId(id);				
			}
		}
		
		if(pc_po!=null){
			Integer flowId=pushDeviceCommand(deviceId, nbc, pc_po);
			if(flowId!=null){//处理业务
				/*full_command.setFlowid(flowId);
				CommandBll commandBll=new CommandBll();
				commandBll.updateCommandtoframSeq(full_command);*/
			}
		}
	}
	
	private Integer pushDeviceCommand(String deviceId,INonBlockingConnection nbc,ParameterConfigurationBean pc_po){
		Integer flowId=null;
		try { 
			 Utilty util=new  Utilty();
			 //获取组装命令报文
			 EncodeCommand encodeCommand=new EncodeCommand();
			 String commandBody=encodeCommand.HandleEncodeCommand(pc_po);
			 System.out.println("===commandBody:"+commandBody);
			 byte[] body_bt= util.hexStrToByteArray(commandBody);
			 MsgEncoder msgEncoder=new MsgEncoder();
			 byte[] msgHeaderAndBody= msgEncoder.encode4TerminalHandCommandResp( body_bt);			
			 nbc.write(msgHeaderAndBody);
			 
			 // 记录命令报文
			 LogManager.getInstance().PrintSentDeviceLog(deviceId,msgHeaderAndBody);//记录应答报文
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		return flowId;
	}
	
}
