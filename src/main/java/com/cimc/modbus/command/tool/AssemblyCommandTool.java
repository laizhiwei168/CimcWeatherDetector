package com.cimc.modbus.command.tool;

import com.cimc.modbus.command.common.ParameterConfigurationBean;



public class AssemblyCommandTool {
	public ParameterConfigurationBean  HandleAssemblyCommand(String msg_type,String address,String start_loct,String eq_number,String[] l_command_content,String[] l_command_type){
		ParameterConfigurationBean pc_po =new ParameterConfigurationBean();
		pc_po.setMsg_type(msg_type);
		pc_po.setAddress(address);
		pc_po.setStart_loct(start_loct);
		pc_po.setEq_number(eq_number);
		
		int commandNumber=l_command_type.length;
		int commandContent=l_command_content.length;
		if(commandNumber>0){
		  for(int i=0;i<commandNumber;i++){
			  String type=l_command_type[i];
			  String content="";
			  if(commandContent>0){//处理查询命令
				  content=l_command_content[i];
			  }
			  AssemblyCommand(content, type.toUpperCase(), pc_po);
		  }
		}
		
		return pc_po;
	}
	
	private void AssemblyCommand(String command_content,String command_type,ParameterConfigurationBean pc_po){
		switch (command_type) {
		
		case "A1":
			//
			pc_po.setA1(command_content);
			break;
		case "A2":
			//
			pc_po.setA2(command_content);
			break;
		case "A3":
			//
			pc_po.setA3(command_content);
			break;
		case "A4":
			//
			pc_po.setA4(command_content);
			break;
		case "A5":
			//
			pc_po.setA5(command_content);
			break;
		case "A6":
			//
			pc_po.setA6(command_content);
			break;
		case "A7":
			//
			pc_po.setA7(command_content);
			break;
		case "A8":
			//
			pc_po.setA8(command_content);
			break;
		
		case "B1":
			//
			pc_po.setB1(command_content);
			break;
			
		case "B2":
			//			
			pc_po.setB2(command_content);
			break;
		case "B3":
			//
			pc_po.setB3(command_content);
			break;
		case "B4":
			//
			pc_po.setB4(command_content);
			break;
		case "B5":
			//
			pc_po.setB5(command_content);
			break;
		case "B6":
			//
			pc_po.setB6(command_content);
			break;
		
		}
	}
}
