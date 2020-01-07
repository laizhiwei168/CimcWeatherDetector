package com.cimc.modbus.manager.subscribe.factory;

import com.cimc.modbus.manager.subscribe.notify.ISubscribeNotify;
import com.cimc.modbus.manager.subscribe.notify.impl.InformationSubscribeNotify;



public class SubscribeFactory {

	public  void pushDataToPlatform(String phoneNumber ,int MsgId, Object objectNode){
		ISubscribeNotify subscribeNotifyResource;
		switch (MsgId) {
		/*case 0X0001://处理设备注册方法
			subscribeNotifyResource=new CommandConfigSubscribeNotify();
			subscribeNotifyResource.HandleSubscribeNotify(objectNode);
			break;*/
		case 0X60://处理设备位置信息插入方法
			subscribeNotifyResource=new InformationSubscribeNotify();
			subscribeNotifyResource.HandleSubscribeNotify(phoneNumber,objectNode);
			break;
		case 0X52://设备命令控制
			/*subscribeNotifyResource=new CommandEquipmentSubscribeNotify();
			subscribeNotifyResource.HandleSubscribeNotify(objectNode);*/
			break;
		default:
			break;
		}
	}
}
