package com.cimc.modbus.command.handle;

import java.io.IOException;

import com.cimc.modbus.command.cache.CommandCache;
import com.cimc.modbus.command.common.HttpCommandPo;
import com.cimc.modbus.protocol.user.DeviceUserManager;
import com.cimc.modbus.protocol.user.UserDeviceBean;
import com.cimc.modbus.utils.common.StringUtils;
import com.cimc.modbus.utils.serializer.FastJsonSerializer;



public class HandleCloudCommand {
	private FastJsonSerializer  fastJsonSerializer=new FastJsonSerializer();
	public String DecodeCloudCommand(String str){
		//LogManager.getInstance().PrintGetHttpCommandLog(str);// 打印数据信息
		if(str!=null && !"".equals(str) && StringUtils.isJSONValid2(str)){			
	        HttpCommandPo httpCommandPo= fastJsonSerializer.toObject(str, HttpCommandPo.class);
	        if(httpCommandPo!=null){
	        	System.out.println("========HandleCloudCommand处理=========");
	            String equipmet_id=httpCommandPo.getEquipmet_id();
	            String type=httpCommandPo.getType();
	            String address=httpCommandPo.getAddress();	            
	            String start_loct=httpCommandPo.getStart_loct();
	            String eq_number=httpCommandPo.getEq_number();	        	
	            String command_type=httpCommandPo.getCommand_type();
	            String command_content=httpCommandPo.getCommand_content();
	           // System.out.println(equipmet_id.trim()+"   type:"+ type.trim()+"    start_loct:"+start_loct.trim()+"    end_loct:"+end_loct.trim()+"    command_type:"+command_type.trim()+"    command_content:"+ command_content.trim());
	            if(!StringUtils.strIsNullOrEmpty(equipmet_id)&& !StringUtils.strIsNullOrEmpty(type)&& !StringUtils.strIsNullOrEmpty(address)&& !StringUtils.strIsNullOrEmpty(start_loct)&& !StringUtils.strIsNullOrEmpty(eq_number)){        	
	            	String id="";
	        		String idAndtypeAndcontent=id+"="+type+"="+address+"="+start_loct+"="+eq_number+"="+command_type+"="+command_content;
	        		System.out.println(equipmet_id+"=========="+idAndtypeAndcontent);
	        		CommandCache.getInstance().addCommandCache(equipmet_id, idAndtypeAndcontent);
	        		
	        		// 判断设备连接是否成功
	        		DeviceUserManager deviceUserManager=DeviceUserManager.getInstance();
	        		UserDeviceBean olduserDeviceBean=deviceUserManager.getUserDeviceBean(equipmet_id);
	        		if(olduserDeviceBean!=null && olduserDeviceBean.isConnect()){
	        			DeviceCommand deviceCommand=new DeviceCommand();
			    		deviceCommand.sendCacheCommand(equipmet_id, olduserDeviceBean.getXsocke());
	        		}	        		
	            }
	        } 
        }
		return "ok";
	}
}
