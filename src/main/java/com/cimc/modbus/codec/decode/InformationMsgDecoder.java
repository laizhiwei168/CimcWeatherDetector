package com.cimc.modbus.codec.decode;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.cimc.modbus.codec.data.InformationPackageData;
import com.cimc.modbus.codec.data.PackageData;
import com.cimc.modbus.codec.data.StatusIdentifierData;
import com.cimc.modbus.utils.common.Utilty;


public class InformationMsgDecoder {

	private Utilty utilty=new Utilty();
	public InformationPackageData toInformationfoUploadMsg(PackageData packageData) {
		InformationPackageData data=new InformationPackageData(packageData);
		
		byte[] body_bt=packageData.getMsgBodyBytes();
		
		boolean is_has=true; 
		int situation=3;
		 int contentionLength_index=3+4;
		int contentionLength=packageData.getMsgBodyLength();
		byte messageid=body_bt[3];
		 while (is_has) {
			 switch (messageid) {
			 case (byte) 0x01:
					BigDecimal b_01 =(BigDecimal) handlNumber(body_bt, situation);
			    	data.setTemperature(b_01.doubleValue());
					//System.out.println("温度:"+b_01);
					break;
			 case (byte) 0x02:
					BigDecimal b_02 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setHumidity(b_02.doubleValue());
					//System.out.println("湿度:"+b_02);
					break;
			 case (byte) 0x03:
					 BigDecimal b_03 =(BigDecimal) handlNumber(body_bt, situation);			         
					 if(data.getIlluminance()!=null){
						 data.setIlluminance(data.getIlluminance()+b_03.doubleValue());
					 }else{
						 data.setIlluminance(b_03.doubleValue());
					 }
					//System.out.println("照度:"+data.getIlluminance());
					break;
			 case (byte) 0x04:
					BigDecimal b_04 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setSoilTemperature(b_04.doubleValue());
					//System.out.println("土壤温度:"+b_04);
					break;
			 case (byte) 0x05:
					BigDecimal b_05 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setSoliWater(b_05.doubleValue());
					//System.out.println("土壤水分:"+b_05);
					break;
			 case (byte) 0x06:
					BigDecimal b_06 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setAirPressure(b_06.doubleValue());
					//System.out.println("大气压力（kPa）:"+b_06);
					break;
			 case (byte) 0x07:
					BigDecimal b_07 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setLiquidLevel(b_07.doubleValue());
					//System.out.println("压力/液位:"+b_07);
					break;
			 case (byte) 0x08:
					BigDecimal b_08 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setFlow(b_08.doubleValue());
					//System.out.println("流量:"+b_08);
					break;
			 case (byte) 0x09:
					BigDecimal b_09 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setUltrasonic(b_09.doubleValue());
					//System.out.println("超声波:"+b_09);
					break;
			 case (byte) 0x0a:
					BigDecimal b_0a =(BigDecimal) handlNumber(body_bt, situation);
			 data.setRadar(b_0a.doubleValue());
					//System.out.println("雷达:"+b_0a);
					break;
			 case (byte) 0x0b:
					BigDecimal b_0b =(BigDecimal) handlNumber(body_bt, situation);
			 data.setSingleInterface(b_0b.doubleValue());
					//System.out.println("单界面:"+b_0b);
					break;
			 case (byte) 0x0c:
					BigDecimal b_0c =(BigDecimal) handlNumber(body_bt, situation);
			 data.setBiface(b_0c.doubleValue());
					//System.out.println("双界面:"+b_0c);
					break;
			 case (byte) 0x0d:
					BigDecimal b_0d =(BigDecimal) handlNumber(body_bt, situation);
			 data.setFlooding(b_0d.doubleValue());
					//System.out.println("浸水:"+b_0d);
					break;
			 case (byte) 0x0e:
					BigDecimal b_0e =(BigDecimal) handlNumber(body_bt, situation);
			 data.setSmokeDetector(b_0e.doubleValue());
					//System.out.println("感烟器:"+b_0e);
					break;
			 case (byte) 0x0f:
					BigDecimal b_0f =(BigDecimal) handlNumber(body_bt, situation);
			 data.setOpenFireDetector(b_0f.doubleValue());
					//System.out.println("明火探测器:"+b_0f);
					break;
			 case (byte) 0x10:
					BigDecimal b_10 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setInfraredDetector(b_10.doubleValue());
					//System.out.println("红外探测器:"+b_10);
					break;
			 case (byte) 0x11:
					BigDecimal b_11 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setFrequencyLevelSwitch(b_11.doubleValue());
					//System.out.println("射频物位开关:"+b_11);
					break;
			 case (byte) 0x12:
					BigDecimal b_12 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setFloatSwitch(b_12.doubleValue());
					//System.out.println("浮球开关:"+b_12);
					break;
			 case (byte) 0x13:
					BigDecimal b_13 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setTuningLevelSwitch(b_13.doubleValue());
					//System.out.println("音叉物位开关:"+b_13);
					break;
			 case (byte) 0x14:
					BigDecimal b_14 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setCO2(b_14.doubleValue());
					//System.out.println("CO2:"+b_14);
					break;
			 case (byte) 0x15:
					BigDecimal b_15 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setDust(b_15.doubleValue());
					//System.out.println("粉尘:"+b_15);
					break;
			 case (byte) 0x16:
					BigDecimal b_16 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setAirQualityGrade(b_16.doubleValue());
					//System.out.println("空气质量等级:"+b_16);
					break;
			 case (byte) 0x17:
					BigDecimal b_17 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setCO(b_17.doubleValue());
					//System.out.println("CO:"+b_17);
					break;
			 case (byte) 0x18:
					BigDecimal b_18 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setH2(b_18.doubleValue());
					//System.out.println("H2:"+b_18);
					break;
			 case (byte) 0x19:
					BigDecimal b_19 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setH2S(b_19.doubleValue());
					//System.out.println("H2S:"+b_19);
					break;
			 case (byte) 0x1a:
					BigDecimal b_1a=(BigDecimal) handlNumber(body_bt, situation);
			 data.setO2(b_1a.doubleValue());
					//System.out.println("O2:"+b_1a);
					break;
			 case (byte) 0x1b:
					BigDecimal b_1b =(BigDecimal) handlNumber(body_bt, situation);
			 data.setSO2(b_1b.doubleValue());
					//System.out.println("SO2:"+b_1b);
					break;
			 case (byte) 0x1c:
					BigDecimal b_1c =(BigDecimal) handlNumber(body_bt, situation);
			 data.setCL2(b_1c.doubleValue());
					//System.out.println("CL2:"+b_1c);
					break;
			 case (byte) 0x1d:
					BigDecimal b_1d =(BigDecimal) handlNumber(body_bt, situation);
			 data.setNH3(b_1d.doubleValue());
					//System.out.println("NH3:"+b_1d);
					break;
			 case (byte) 0x1e:
					BigDecimal b_1e =(BigDecimal) handlNumber(body_bt, situation);
			 data.setCH3OH(b_1e.doubleValue());
					//System.out.println("CH3OH:"+b_1e);
					break;
			 case (byte) 0x1f:
					BigDecimal b_1f =(BigDecimal) handlNumber(body_bt, situation);
			 data.setCH3CH2OH(b_1f.doubleValue());
					//System.out.println("CH3CH2OH:"+b_1f);
					break;
			 case (byte) 0x20:
					BigDecimal b_20 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setCH4(b_20.doubleValue());
					//System.out.println("CH4:"+b_20);
					break;
			 case (byte) 0x21:
					BigDecimal b_21 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setDewPoint(b_21.doubleValue());
					//System.out.println("露点:"+b_21);
					break;
			 case (byte) 0x22:
					BigDecimal b_22 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setFloodAlarmStatus(b_22.doubleValue());
					//System.out.println("水浸报警状态:"+b_22);
					break;
			 case (byte) 0x23:
					BigDecimal b_23 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setFloodAlarmData(b_23.doubleValue());
					//System.out.println("水浸报警数据:"+b_23);
					break;
			 case (byte) 0x24:
					BigDecimal b_24 =(BigDecimal) handlNumber(body_bt, situation);
			 
					System.out.println(":"+b_24);
					break;
			 case (byte) 0x25:
					BigDecimal b_25 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setTemperature1(b_25.doubleValue());
					//System.out.println("温度 1:"+b_25);
					break;
			 case (byte) 0x26:
					BigDecimal b_26 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setTemperature2(b_26.doubleValue());
					//System.out.println("温度 2:"+b_26);
					break;
			 case (byte) 0x27:
					BigDecimal b_27 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setTemperature3(b_27.doubleValue());
					//System.out.println("温度 3:"+b_27);
					break;
			 case (byte) 0x28:
					BigDecimal b_28 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setTemperature4(b_28.doubleValue());
					//System.out.println("温度 4:"+b_28);
					break;
			 case (byte) 0x29:
					BigDecimal b_29 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setTemperature5(b_29.doubleValue());
					//System.out.println("温度 5:"+b_29);
					break;
			 case (byte) 0x2a:
					BigDecimal b_2a =(BigDecimal) handlNumber(body_bt, situation);
			 data.setTemperature6(b_2a.doubleValue());
					//System.out.println("温度 6:"+b_2a);
					break;
			 case (byte) 0x2b:
					BigDecimal b_2b =(BigDecimal) handlNumber(body_bt, situation);
			 data.setHumidity1(b_2b.doubleValue());
					//System.out.println("湿度 1:"+b_2b);
					break;
			 case (byte) 0x2c:
					BigDecimal b_2c =(BigDecimal) handlNumber(body_bt, situation);
			 data.setHumidity2(b_2c.doubleValue());
					//System.out.println("湿度 2:"+b_2c);
					break;
			 case (byte) 0x2d:
					BigDecimal b_2d=(BigDecimal) handlNumber(body_bt, situation);
			 
					System.out.println(":"+b_2d);
					break;
			 case (byte) 0x2e:
					BigDecimal b_2e =(BigDecimal) handlNumber(body_bt, situation);
			 
					System.out.println(":"+b_2e);
					break;
			 case (byte) 0x2f:
					BigDecimal b_2f =(BigDecimal) handlNumber(body_bt, situation);
			 
					System.out.println(":"+b_2f);
					break;
					
			 case (byte) 0x30:
					BigDecimal b_30 =(BigDecimal) handlNumber(body_bt, situation);
			 //System.out.println("风速:"+b_30);
			 data.setWindSpeed(b_30.doubleValue());
					
					break;
			 case (byte) 0x31:
					BigDecimal b_31 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setWindDirection(b_31.doubleValue());
					//System.out.println("风向:"+b_31);
					break;
			 case (byte) 0x32:
					BigDecimal b_32 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setRainfall(b_32.doubleValue());
					//System.out.println("雨量:"+b_32);
					break;
			 case (byte) 0x33:
					BigDecimal b_33 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setPH(b_33.doubleValue());
					//System.out.println("PH 值（0.00~14.00）:"+b_33);
					break;
					
			 case (byte) 0x40:
					BigDecimal b_40 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setEC(b_40.doubleValue());
					//System.out.println("EC 值（dS/m）:"+b_40);
					break;
					
			 case (byte) 0x42:
					BigDecimal b_42 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setSandyMoisture(b_42.doubleValue());
					//System.out.println("沙土水分（%）:"+b_42);
					break;
			 case (byte) 0x43:
					BigDecimal b_43 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setClayMoisture(b_43.doubleValue());
					//System.out.println("黏土水分（%）:"+b_43);
					break;
					
			 case (byte) 0x50:
					BigDecimal b_50 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setPM1(b_50.doubleValue());
					//System.out.println("PM1.0（ug/m3）:"+b_50);
					break;
			 case (byte) 0x51:
					BigDecimal b_51 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setPM2(b_51.doubleValue());
					//System.out.println("PM2.5（ug/m3）:"+b_51);
					break;
			 case (byte) 0x52:
					BigDecimal b_52 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setPM10(b_52.doubleValue());
					//.out.println("PM10（ug/m3）:"+b_52);
					break;
			 
			 case (byte) 0x80:
					BigDecimal b_80 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setLiquidLevelPa(b_80.doubleValue());
					//System.out.println("压力液位 Pa:"+b_80);
					break;
			 case (byte) 0x81:
					BigDecimal b_81 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setLiquidLevelkPa(b_81.doubleValue());
					//System.out.println("压力液位 kPa:"+b_81);
					break;
			 case (byte) 0x82:
					BigDecimal b_82 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setLiquidLevelMPa(b_82.doubleValue());
					//System.out.println("压力液位 MPa:"+b_82);
					break;
			 case (byte) 0x83:
					BigDecimal b_83 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setLiquidLevelBar(b_83.doubleValue());
					//System.out.println("压力液位 Bar:"+b_83);
					break;
			 case (byte) 0x84:
					BigDecimal b_84 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setLiquidLevelm(b_84.doubleValue());
					//System.out.println("压力液位 m:"+b_84);
					break;
			 case (byte) 0x85:
					BigDecimal b_85 =(BigDecimal) handlNumber(body_bt, situation);
			 //data.set
					//System.out.println("压力液位（预留）:"+b_85);
					break;
			 case (byte) 0x86:
					BigDecimal b_86 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setOilTemperature(b_86.doubleValue());
					//System.out.println("油液温度℃:"+b_86);
					break;
			 case (byte) 0x87:
					BigDecimal b_87 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setMailboxLevel(b_87.doubleValue());
					//System.out.println("邮箱液位 mm:"+b_87);
					break;
			 case (byte) 0x88:
					BigDecimal b_88 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setSystemPressure(b_88.doubleValue());
					//System.out.println("系统压力 Mpa:"+b_88);
					break;
			 case (byte) 0x89:
					BigDecimal b_89 =(BigDecimal) handlNumber(body_bt, situation);
			 data.setNoRodpressure(b_89.doubleValue());
					//System.out.println("无杆腔压力 Mpa:"+b_89);
					break;
			 case (byte) 0x8a:
					BigDecimal b_8a =(BigDecimal) handlNumber(body_bt, situation);
			 data.setRodpressure(b_8a.doubleValue());
					//System.out.println("有杆腔压力 Mpa:"+b_8a);
					break;
					
			 case (byte) 0xa1:
				 Boolean b_a1 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch1(b_a1);
					//System.out.println("开关量 1（输出）:"+b_a1);
					break;
			 case (byte) 0xa2:
				 Boolean b_a2 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch2(b_a2);
					//System.out.println("开关量 2（输出）:"+b_a2);
					break;
			 case (byte) 0xa3:
				 Boolean b_a3 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch3(b_a3);
					//System.out.println("开关量 3（输出）:"+b_a3);
					break;
			 case (byte) 0xa4:
				 Boolean b_a4 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch4(b_a4);
					//System.out.println("开关量 4（输出）:"+b_a4);
					break;
			 case (byte) 0xa5:
				 Boolean b_a5 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch5(b_a5);
					//System.out.println("开关量 5（输出）:"+b_a5);
					break;
			 case (byte) 0xa6:
				 Boolean b_a6 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch6(b_a6);
					//System.out.println("开关量 6（输出）:"+b_a6);
					break;
			 case (byte) 0xa7:
				 Boolean b_a7 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch7(b_a7);
					//System.out.println("开关量 7（输出）:"+b_a7);
					break;
			 case (byte) 0xa8:
				 Boolean b_a8 =(Boolean) handlNumber(body_bt, situation);
			 data.setOutputSwitch8(b_a8);
					//System.out.println("开关量 8（输出）:"+b_a8);
					break;
			 
			 case (byte) 0xb0:
				 	Boolean  b =(Boolean) handlNumber(body_bt, situation);
			 		System.out.println(":"+b);
			 		break;
			case (byte) 0xb1:
					Boolean  b1 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch1(b1);
					//System.out.println("开关量 1（输入）:"+b1);
					break;
			case (byte) 0xb2:
					Boolean  b2 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch2(b2);
					//System.out.println("开关量 2（输入）:"+b2);
					break;
			case (byte) 0xb3:
					Boolean  b3 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch3(b3);
					//System.out.println("开关量 3（输入）:"+b3);
					break;
			case (byte) 0xb4:
					Boolean  b4 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch4(b4);
					//System.out.println("开关量 4（输入）:"+b4);
					break;
			case (byte) 0xb5:
					Boolean  b5 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch5(b5);
					//System.out.println("开关量 5（输入）:"+b5);
					break;
			case (byte) 0xb6:
					Boolean  b6 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch6(b6);
					//System.out.println("开关量 6（输入）:"+b6);
					break;
			case (byte) 0xb7:
					Boolean  b7 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch7(b7);
					//System.out.println("开关量 7（输入）:"+b7);
					break;
			case (byte) 0xb8:
					Boolean  b8 =(Boolean) handlNumber(body_bt, situation);
			data.setInputSwitch8(b8);
					//System.out.println("开关量 8（输入）:"+b8);
					break;
			 
				case (byte) 0xc0:
					BigDecimal c0 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA1(c0.doubleValue());
					//System.out.println("模拟量1 （mA）:"+c0);
					break;
				case (byte) 0xc1:
					BigDecimal c1 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA2(c1.doubleValue());
				//System.out.println("模拟量 2（mA）:"+c1);
					break;
				case (byte) 0xc2:
					BigDecimal c2 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA3(c2.doubleValue());
				//System.out.println("模拟量 3（mA）:"+c2);
					break;
				case (byte) 0xc3:
					BigDecimal c3 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA4(c3.doubleValue());
				//System.out.println("模拟量 4（mA）:"+c3);
					break;
				case (byte) 0xc4:
					BigDecimal c4 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA5(c4.doubleValue());
					//System.out.println("模拟量 5（mA）:"+c4);
					break;
				case (byte) 0xc5:
					BigDecimal c5 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA6(c5.doubleValue());
					//System.out.println("模拟量 6（mA）:"+c5);
					break;
				case (byte) 0xc6:
					BigDecimal c6 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA7(c6.doubleValue());
					//System.out.println("模拟量 7（mA）:"+c6);
					break;
				case (byte) 0xc7:
					BigDecimal c7 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogA8(c7.doubleValue());
					//System.out.println("模拟量 8（mA）:"+c7);
					break;
				case (byte) 0xc8:
					BigDecimal c8 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV1(c8.doubleValue());
					//System.out.println("模拟量 1（v）:"+c8);
					break;
				case (byte) 0xc9:
					BigDecimal c9 =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV2(c9.doubleValue());
					//System.out.println("模拟量 2（v）:"+c9);
					break;
				case (byte) 0xca:
					BigDecimal ca =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV3(ca.doubleValue());
					//System.out.println("模拟量 3（v）:"+ca);
					break;
				case (byte) 0xcb:
					BigDecimal cb =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV4(cb.doubleValue());
					//System.out.println("模拟量 4（v）:"+cb);
					break;
				case (byte) 0xcc:
					BigDecimal cc =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV5(cc.doubleValue());
					//System.out.println("模拟量 5（v）:"+cc);
					break;
				case (byte) 0xcd:
					BigDecimal cd =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV6(cd.doubleValue());
					//System.out.println("模拟量 6（v）:"+cd);
					break;
				case (byte) 0xce:
					BigDecimal ce =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV7(ce.doubleValue());
					//System.out.println("模拟量 7（v）:"+ce);
					break;
				case (byte) 0xcf:
					BigDecimal cf =(BigDecimal) handlNumber(body_bt, situation);
				data.setAnalogV8(cf.doubleValue());
					//System.out.println("模拟量 8（v）:"+cf);
					break;
					
				case (byte) 0xf3:
					//BigDecimal f3 =(BigDecimal) handlNumber(body_bt, situation);
					System.out.println("年:"+(body_bt[situation+2]&0xff));
				    System.out.println("月:"+(body_bt[situation+3]&0xff));
				    data.setYears((body_bt[situation+2]&0xff)+"");
				    data.setMonth((body_bt[situation+3]&0xff)+"");
					break;
					
				case (byte) 0xf4:
					//BigDecimal f4 =(BigDecimal) handlNumber(body_bt, situation);
					System.out.println("日:"+body_bt[situation+2]);
			        System.out.println("时:"+(body_bt[situation+3]&0xff));
			        data.setDay((body_bt[situation+2]&0xff)+"");
			        data.setHours((body_bt[situation+3]&0xff)+"");
			  	 
					break;
					
				case (byte) 0xf5:
					//BigDecimal f5 =(BigDecimal) handlNumber(body_bt, situation);
					System.out.println("分:"+(body_bt[situation+2]&0xff));
					System.out.println("秒:"+(body_bt[situation+3]&0xff));
					data.setMinutes((body_bt[situation+2]&0xff)+"");
					data.setSeconds((body_bt[situation+3]&0xff)+"");
					break;
				
				default:
					break;
			 }			 
			 situation=situation+4;
			 if(contentionLength_index>=contentionLength){
	            	is_has=false;
	            	//return;
	            }else{
	            	//System.out.println("situation:"+situation+"  messageid:"+(messageid& 0xff)+" contentionLength_index:"+contentionLength_index);
	            	messageid=body_bt[situation];	            
	                contentionLength_index=contentionLength_index+4;
	            }
		 }
		
		return data;
	}
	
	private Object handlNumber(byte[] body_bt, int situation){
		Object value=null;
		StatusIdentifierData si=statusidentifier(body_bt[situation+1]);
		Integer vl=utilty.bytes2Int(body_bt,situation+2,2);
		if(0xff==(body_bt[situation+2]&0xff)){
			vl=utilty.bytes2IntAddFFFF(vl);
		}
		
		if(si.isValueByte()){
			// 处理判断值			
			if(0xffff==vl){
				value=true;
			}else{
				value=false;
			}
		}else{
			if(0xffff!=vl){
				int decimals =si.getDecimals()==0?1:si.getDecimals()==1?10:si.getDecimals()==2?100:si.getDecimals()==3?1000:1;				
				BigDecimal d = new BigDecimal(vl+""); 
				BigDecimal r = new BigDecimal(decimals+"");
				BigDecimal b_v = d.divide(r,2,BigDecimal.ROUND_HALF_UP).setScale(2,RoundingMode.HALF_EVEN);
				
				/**有无符号，标志是如果值是负数，如果为有符号，则负数保留；否则去掉*/
				if(si.isSymbolByte()){
					// 有符号
					/*BigDecimal f = new BigDecimal("-1");
					value=b_v.multiply(f);*/					
					value=b_v;
				}else{
					// 无符号
					/*value=b_v;*/
					if(b_v.doubleValue()<0){
						BigDecimal f = new BigDecimal("-1");
						value=b_v.multiply(f);
					}else{
						if(si.isLenghtByte()&&si.isHighByte()&&b_v.doubleValue()!=0){							
							int LenghtByte=0xffff;
							BigDecimal b_LenghtByte = new BigDecimal(LenghtByte+"");							
							value=b_v.add(b_LenghtByte);
						}else{
							value=b_v;
						}						
					}
				}
			}			
		}
		
		return value;
	}
	
	
	private StatusIdentifierData statusidentifier(byte b){
		StringBuffer strbf=new StringBuffer();
		String statusInformation=Integer.toBinaryString(b&0xff);
		if(statusInformation.length()<8) {//解析状态信息
    		for(int i=0;i<8-statusInformation.length();i++) {
    			strbf.append("0");
    		}
    		strbf.append(statusInformation);
    	 }else {
    		strbf.append(statusInformation);
    	 }
		int bf_length=strbf.length();
		String pstway=strbf.substring(bf_length-3, bf_length); 
 		StatusIdentifierData statusIdentifierData=new StatusIdentifierData(); 		
 		statusIdentifierData.setDecimals(Integer.valueOf(pstway,2));//小数点位置
 		statusIdentifierData.setHighByte("1".equals(strbf.substring(bf_length-5, bf_length-4)));// 四字节数字节标识 0:低2字节  1:高2字节
 		statusIdentifierData.setLenghtByte("1".equals(strbf.substring(bf_length-6, bf_length-5)));// 长整型数值标识  0:双字节 1:四字节
 		statusIdentifierData.setValueByte("1".equals(strbf.substring(bf_length-7, bf_length-6)));// 数值类型  0:数值 1:开关量 
 		statusIdentifierData.setSymbolByte("1".equals(strbf.substring(bf_length-8, bf_length-7)));// 符号数  0:无符号  1:有符号 		
 		return statusIdentifierData;
	}
}
