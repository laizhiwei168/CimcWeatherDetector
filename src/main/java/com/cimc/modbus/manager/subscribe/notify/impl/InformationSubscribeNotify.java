package com.cimc.modbus.manager.subscribe.notify.impl;


import java.util.List;
import java.util.Map;

import com.cimc.modbus.codec.data.InformationPackageData;
import com.cimc.modbus.manager.bll.TaDataBll;
import com.cimc.modbus.manager.po.EquipmetDataPo;
import com.cimc.modbus.manager.subscribe.notify.ISubscribeNotify;
import com.cimc.modbus.utils.common.DateUtils;


public class InformationSubscribeNotify implements ISubscribeNotify {

	@Override
	public void HandleSubscribeNotify(String EQUIPMENT_ID, Object deviceData) {
		System.out.println("=======================");
		InformationPackageData data=(InformationPackageData) deviceData;
		TaDataBll taDataBll =new TaDataBll();
		EquipmetDataPo po=new EquipmetDataPo();
		
		List<Map<String, Object>> ls_Equipment =taDataBll.selectEquipmentById(EQUIPMENT_ID);
		if(ls_Equipment.size()<=0){
			return;
		}
		po.setPk_equipment(ls_Equipment.get(0).get("pk_equipment").toString());
	 	po.setTemperature(data.getTemperature());;//  '温度',
	    po.setHumidity(data.getHumidity()); ;// '湿度',
	    po.setIlluminance(data.getIlluminance());;//  '照度',
	    po.setSoilTemperature(data.getSoilTemperature());;//  '土壤温度',
	    po.setSoliWater(data.getSoliWater());;//  '土壤水分',
	    po.setAirPressure(data.getAirPressure());;//  '大气压力',
	    po.setLiquidLevel(data.getLiquidLevel());;//  '液位',
	    po.setFlow(data.getFlow()); ;// '流量',
	    po.setUltrasonic(data.getUltrasonic()); ;// '超声波',
	    po.setRadar(data.getRadar());;//  '雷达',
	    po.setSingleInterface(data.getSingleInterface());;//  '单界面',
	    po.setBiface(data.getBiface());;//  '双界面',
	    po.setFlooding(data.getFlooding());;//  '浸水',
	    po.setSmokeDetector(data.getSmokeDetector());;//  '感烟器',
	    po.setOpenFireDetector(data.getOpenFireDetector());;//  '明火探测器',
	    po.setInfraredDetector(data.getInfraredDetector()); ;// '红外探测器',
	    po.setFrequencyLevelSwitch(data.getFrequencyLevelSwitch()); ;// '射频物位开关',
	    po.setFloatSwitch(data.getFloatSwitch()); ;// '浮球开关',
	    po.setTuningLevelSwitch(data.getTuningLevelSwitch()); ;// '音叉物位开关',
	    po.setCO2(data.getCO2()); ;//
	    po.setDust(data.getDust()); ;// '粉尘',
	    po.setAirQualityGrade(data.getAirQualityGrade());;//  '空气质量等级',
	    po.setCO(data.getCO());;//
	    po.setH2(data.getH2()); ;//
	    po.setH2S(data.getH2S()); ;//
	    po.setO2(data.getO2()); ;//
	    po.setSO2(data.getSO2()); ;//
	    po.setCL2(data.getCL2()); ;//
	    po.setNH3(data.getNH3()); ;//
	    po.setCH3OH(data.getCH3OH()); ;//
	    po.setCH3CH2OH(data.getCH3CH2OH()); ;//
	    po.setCH4(data.getCH4()); ;//
	    po.setDewPoint(data.getDewPoint()); ;// '露点',
	    po.setFloodAlarmStatus(data.getFloodAlarmStatus()); ;// '水浸报警状态',
	    po.setFloodAlarmData(data.getFloodAlarmData()); ;// '水浸报警数据',
	    po.setTemperature1(data.getTemperature1());;//
	    po.setTemperature2(data.getTemperature2()); ;//
	    po.setTemperature3(data.getTemperature3()); ;//
	    po.setTemperature4(data.getTemperature4()); ;//
	    po.setTemperature5(data.getTemperature5()); ;//
	    po.setTemperature6(data.getTemperature6());;//
	    po.setHumidity1(data.getHumidity1()); ;//
	    po.setHumidity2(data.getHumidity2()); ;//
	    po.setWindSpeed(data.getWindSpeed()); ;// '风速',
	    po.setWindDirection(data.getWindDirection()); ;// '风向',
	    po.setRainfall(data.getRainfall()); ;// '雨量',
	    po.setPH(data.getPH());;//
	    po.setEC(data.getEC()); ;//
	    po.setSandyMoisture(data.getSandyMoisture()); ;// '沙土水分',
	    po.setClayMoisture(data.getClayMoisture()); ;// '黏土水分',
	    po.setPM1(data.getPM1());;// 'PM1.0',
	    po.setPM2(data.getPM2()); ;// 'PM2.5',
	    po.setPM10(data.getPM10()); ;//
	    po.setLiquidLevelPa(data.getLiquidLevelPa()); ;//
	    po.setLiquidLevelkPa(data.getLiquidLevelkPa()); ;//
	    po.setLiquidLevelMPa(data.getLiquidLevelMPa()); ;//
	    po.setLiquidLevelBar(data.getLiquidLevelBar()); ;//
	    po.setLiquidLevelm(data.getLiquidLevelm());;//
	    po.setOilTemperature(data.getOilTemperature()); ;// '油液温度',
	    po.setMailboxLevel(data.getMailboxLevel()); ;// '邮箱液位',
	    po.setSystemPressure(data.getSystemPressure()); ;// '系统压力',
	    po.setNoRodpressure(data.getNoRodpressure()); ;// '无杆腔压力',
	    po.setRodpressure(data.getRodpressure()); ;// '有杆腔压力Mpa',
	    
	   po.setOutputSwitch1(data.getOutputSwitch1()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setOutputSwitch2(data.getOutputSwitch2()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setOutputSwitch3(data.getOutputSwitch3()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setOutputSwitch4(data.getOutputSwitch4()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setOutputSwitch5(data.getOutputSwitch5()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setOutputSwitch6(data.getOutputSwitch6()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setOutputSwitch7(data.getOutputSwitch7()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setOutputSwitch8(data.getOutputSwitch8()==null?null:data.getOutputSwitch1()==true?1:0);;// 
	   po.setInputSwitch1(data.getInputSwitch1()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setInputSwitch2(data.getInputSwitch2()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setInputSwitch3(data.getInputSwitch3()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setInputSwitch4(data.getInputSwitch4()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setInputSwitch5(data.getInputSwitch5()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setInputSwitch6(data.getInputSwitch6()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setInputSwitch7(data.getInputSwitch7()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   po.setInputSwitch8(data.getInputSwitch8()==null?null:data.getOutputSwitch1()==true?1:0); ;//
	   
	   
	    po.setAnalogA1(data.getAnalogA1()); ;//
	    po.setAnalogA2(data.getAnalogA2());;// 
	    po.setAnalogA3(data.getAnalogA3());;// 
	    po.setAnalogA4(data.getAnalogA4());;// 
	    po.setAnalogA5(data.getAnalogA5());;// 
	    po.setAnalogA6(data.getAnalogA6());;// 
	    po.setAnalogA7(data.getAnalogA7());;// 
	    po.setAnalogA8(data.getAnalogA8());;// 
	    po.setAnalogV1(data.getAnalogV1());;// 
	    po.setAnalogV2(data.getAnalogV2());;// 
	    po.setAnalogV3(data.getAnalogV3()); ;//
	    po.setAnalogV4(data.getAnalogV4());;// 
	    po.setAnalogV5(data.getAnalogV5());;// 
	    po.setAnalogV6(data.getAnalogV6());;// 
	    po.setAnalogV7(data.getAnalogV7()); ;//
	    po.setAnalogV8(data.getAnalogV8()); ;//
	  
	    String  years=data.getYears();
	    String month=data.getMonth();
	    String day=data.getDay();
	    String hours=data.getHours();
	    String minutes=data.getMinutes();
	    String seconds=data.getSeconds();
	    po.setDataTime(DateUtils.getDoDayTime());
	    System.out.println(years+"-"+month+"-"+day+"  "+hours+":"+minutes+":"+seconds);
	    
	    taDataBll.addInfoTaDataNew(po);
	}

}
