package com.cimc.modbus.manager.dal;

import java.util.List;
import java.util.Map;

import com.cimc.modbus.manager.common.DBBean;
import com.cimc.modbus.manager.db.DBHandleHelper;
import com.cimc.modbus.manager.po.EquipmetDataPo;


public class TaDataDal {

	private DBHandleHelper DbHelper=new DBHandleHelper();
	
	public List<Map<String, Object>> selectEquipmentById(String EQUIPMENT_ID){	
		String SQLString ="SELECT a.*,b.imeiNo FROM ta_equipment a LEFT JOIN ta_device b  on a.pk_device=b.pk_device where b.imeiNo='"+EQUIPMENT_ID+"' and a.enablestate=1";
		List<Map<String, Object>> ls_taTank= DbHelper.Query(DBBean.mysqldata,SQLString);		
		return ls_taTank;
	}
	
	// 查询最新数据信息表
	public List<Map<String, Object>> selectTaDataByID(String pk_equipmet){
		String SQLString ="SELECT *  FROM ta_equipmet_data_new WHERE pk_equipment='"+pk_equipmet+"'";
		List<Map<String, Object>> ls_taData= DbHelper.Query(DBBean.mysqldata,SQLString);
		return ls_taData;
	}
	
	/**
	 * 插入最新表数据
	 * @param po
	 * @return
	 */
	public int AddTaDataNew(EquipmetDataPo po){
		StringBuilder sql=new StringBuilder("insert into ta_equipmet_data_new (");
		if(po.getPk_equipment()!=null && !"".equals(po.getPk_equipment())){sql.append("pk_equipment");}
		if(po.getDataTime()!=null &&! "".equals(po.getDataTime())){sql.append(",dataTime");}
		if(po.getTemperature()!=null){sql.append(",temperature");}
		if(po.getHumidity()!=null){sql.append(",humidity");}
		if(po.getIlluminance()!=null){sql.append(",illuminance");}
		if(po.getSoilTemperature()!=null){sql.append(",soilTemperature");}
		if(po.getSoliWater()!=null){sql.append(",soliWater");}
		if(po.getAirPressure()!=null){sql.append(",airPressure");}
		if(po.getLiquidLevel()!=null){sql.append(",liquidLevel");}
		if(po.getFlow()!=null){sql.append(",flow");}
		if(po.getUltrasonic()!=null){sql.append(",ultrasonic");}
		if(po.getRadar()!=null){sql.append(",radar");}
		if(po.getSingleInterface()!=null){sql.append(",singleInterface");}
		if(po.getBiface()!=null){sql.append(",biface");}
		if(po.getFlooding()!=null){sql.append(",flooding");}
		if(po.getSmokeDetector()!=null){sql.append(",SmokeDetector");}
		if(po.getOpenFireDetector()!=null){sql.append(",OpenFireDetector");}
		if(po.getInfraredDetector()!=null){sql.append(",infraredDetector");}
		if(po.getFrequencyLevelSwitch()!=null){sql.append(",frequencyLevelSwitch");}
		if(po.getFloatSwitch()!=null){sql.append(",floatSwitch");}
		if(po.getTuningLevelSwitch()!=null){sql.append(",tuningLevelSwitch");}
		if(po.getCO2()!=null){sql.append(",CO2");}
		if(po.getDust()!=null){sql.append(",dust");}
		if(po.getAirQualityGrade()!=null){sql.append(",airQualityGrade");}
		if(po.getCO()!=null){sql.append(",CO");}
		if(po.getH2()!=null){sql.append(",H2");}
		if(po.getH2S()!=null){sql.append(",H2S");}
		if(po.getO2()!=null){sql.append(",O2");}
		if(po.getSO2()!=null){sql.append(",SO2");}
		if(po.getCL2()!=null){sql.append(",CL2");}
		if(po.getNH3()!=null){sql.append(",NH3");}
		if(po.getCH3OH()!=null){sql.append(",CH3OH");}
		if(po.getCH3CH2OH()!=null){sql.append(",CH3CH2OH");}
		if(po.getCH4()!=null){sql.append(",CH4");}
		if(po.getDewPoint()!=null){sql.append(",dewPoint");}
		if(po.getFloodAlarmStatus()!=null){sql.append(",floodAlarmStatus");}
		if(po.getFloodAlarmData()!=null){sql.append(",floodAlarmData");}
		if(po.getTemperature1()!=null){sql.append(",temperature1");}
		if(po.getTemperature2()!=null){sql.append(",temperature2");}
		if(po.getTemperature3()!=null){sql.append(",temperature3");}
		if(po.getTemperature4()!=null){sql.append(",temperature4");}
		if(po.getTemperature5()!=null){sql.append(",temperature5");}
		if(po.getTemperature6()!=null){sql.append(",temperature6");}
		if(po.getHumidity1()!=null){sql.append(",humidity1");}
		if(po.getHumidity2()!=null){sql.append(",humidity2");}
		if(po.getWindSpeed()!=null){sql.append(",windSpeed");}
		if(po.getWindDirection()!=null){sql.append(",windDirection");}
		if(po.getRainfall()!=null){sql.append(",rainfall");}
		if(po.getPH()!=null){sql.append(",PH");}
		if(po.getEC()!=null){sql.append(",EC");}
		if(po.getSandyMoisture()!=null){sql.append(",sandyMoisture");}
		if(po.getClayMoisture()!=null){sql.append(",clayMoisture");}
		if(po.getPM1()!=null){sql.append(",PM1");}
		if(po.getPM2()!=null){sql.append(",PM2");}
		if(po.getPM10()!=null){sql.append(",PM10");}
		if(po.getLiquidLevelPa()!=null){sql.append(",liquidLevelPa");}
		if(po.getLiquidLevelkPa()!=null){sql.append(",liquidLevelkPa");}
		if(po.getLiquidLevelMPa()!=null){sql.append(",liquidLevelMPa");}
		if(po.getLiquidLevelBar()!=null){sql.append(",liquidLevelBar");}
		if(po.getLiquidLevelm()!=null){sql.append(",liquidLevelm");}
		if(po.getOilTemperature()!=null){sql.append(",oilTemperature");}
		if(po.getMailboxLevel()!=null){sql.append(",mailboxLevel");}
		if(po.getSystemPressure()!=null){sql.append(",systemPressure");}
		if(po.getNoRodpressure()!=null){sql.append(",noRodpressure");}
		if(po.getRodpressure()!=null){sql.append(",Rodpressure");}
		if(po.getOutputSwitch1()!=null){sql.append(",outputSwitch1");}
		if(po.getOutputSwitch2()!=null){sql.append(",outputSwitch2");}
		if(po.getOutputSwitch3()!=null){sql.append(",outputSwitch3");}
		if(po.getOutputSwitch4()!=null){sql.append(",outputSwitch4");}
		if(po.getOutputSwitch5()!=null){sql.append(",outputSwitch5");}
		if(po.getOutputSwitch6()!=null){sql.append(",outputSwitch6");}
		if(po.getOutputSwitch7()!=null){sql.append(",outputSwitch7");}
		if(po.getOutputSwitch8()!=null){sql.append(",outputSwitch8");}
		if(po.getInputSwitch1()!=null){sql.append(",inputSwitch1");}
		if(po.getInputSwitch2()!=null){sql.append(",inputSwitch2");}
		if(po.getInputSwitch3()!=null){sql.append(",inputSwitch3");}
		if(po.getInputSwitch4()!=null){sql.append(",inputSwitch4");}
		if(po.getInputSwitch5()!=null){sql.append(",inputSwitch5");}
		if(po.getInputSwitch6()!=null){sql.append(",inputSwitch6");}
		if(po.getInputSwitch7()!=null){sql.append(",inputSwitch7");}
		if(po.getInputSwitch8()!=null){sql.append(",inputSwitch8");}
		if(po.getAnalogA1()!=null){sql.append(",analogA1");}
		if(po.getAnalogA2()!=null){sql.append(",analogA2");}
		if(po.getAnalogA3()!=null){sql.append(",analogA3");}
		if(po.getAnalogA4()!=null){sql.append(",analogA4");}
		if(po.getAnalogA5()!=null){sql.append(",analogA5");}
		if(po.getAnalogA6()!=null){sql.append(",analogA6");}
		if(po.getAnalogA7()!=null){sql.append(",analogA7");}
		if(po.getAnalogA8()!=null){sql.append(",analogA8");}
		if(po.getAnalogV1()!=null){sql.append(",analogV1");}
		if(po.getAnalogV2()!=null){sql.append(",analogV2");}
		if(po.getAnalogV3()!=null){sql.append(",analogV3");}
		if(po.getAnalogV4()!=null){sql.append(",analogV4");}
		if(po.getAnalogV5()!=null){sql.append(",analogV5");}
		if(po.getAnalogV6()!=null){sql.append(",analogV6");}
		if(po.getAnalogV7()!=null){sql.append(",analogV7");}
		if(po.getAnalogV8()!=null){sql.append(",analogV8");}
		
		sql.append(") values(");
		
		if(po.getPk_equipment()!=null && !"".equals(po.getPk_equipment())){sql.append("'"+po.getPk_equipment()+"'");}
		if(po.getDataTime()!=null &&! "".equals(po.getDataTime())){sql.append(",'"+po.getDataTime()+"'");}
		if(po.getTemperature()!=null){sql.append(",'"+po.getTemperature()+"'");}
		if(po.getHumidity()!=null){sql.append(",'"+po.getHumidity()+"'");}
		if(po.getIlluminance()!=null){sql.append(",'"+po.getIlluminance()+"'");}
		if(po.getSoilTemperature()!=null){sql.append(",'"+po.getSoilTemperature()+"'");}
		if(po.getSoliWater()!=null){sql.append(",'"+po.getSoliWater()+"'");}
		if(po.getAirPressure()!=null){sql.append(",'"+po.getAirPressure()+"'");}
		if(po.getLiquidLevel()!=null){sql.append(",'"+po.getLiquidLevel()+"'");}
		if(po.getFlow()!=null){sql.append(",'"+po.getFlow()+"'");}
		if(po.getUltrasonic()!=null){sql.append(",'"+po.getUltrasonic()+"'");}
		if(po.getRadar()!=null){sql.append(",'"+po.getRadar()+"'");}
		if(po.getSingleInterface()!=null){sql.append(",'"+po.getSingleInterface()+"'");}
		if(po.getBiface()!=null){sql.append(",'"+po.getBiface()+"'");}
		if(po.getFlooding()!=null){sql.append(",'"+po.getFlooding()+"'");}
		if(po.getSmokeDetector()!=null){sql.append(",'"+po.getSmokeDetector()+"'");}
		if(po.getOpenFireDetector()!=null){sql.append(",'"+po.getOpenFireDetector()+"'");}
		if(po.getInfraredDetector()!=null){sql.append(",'"+po.getInfraredDetector()+"'");}
		if(po.getFrequencyLevelSwitch()!=null){sql.append(",'"+po.getFrequencyLevelSwitch()+"'");}
		if(po.getFloatSwitch()!=null){sql.append(",'"+po.getFloatSwitch()+"'");}
		if(po.getTuningLevelSwitch()!=null){sql.append(",'"+po.getTuningLevelSwitch()+"'");}
		if(po.getCO2()!=null){sql.append(",'"+po.getCO2()+"'");}
		if(po.getDust()!=null){sql.append(",'"+po.getDust()+"'");}
		if(po.getAirQualityGrade()!=null){sql.append(",'"+po.getAirQualityGrade()+"'");}
		if(po.getCO()!=null){sql.append(",'"+po.getCO()+"'");}
		if(po.getH2()!=null){sql.append(",'"+po.getH2()+"'");}
		if(po.getH2S()!=null){sql.append(",'"+po.getH2S()+"'");}
		if(po.getO2()!=null){sql.append(",'"+po.getO2()+"'");}
		if(po.getSO2()!=null){sql.append(",'"+po.getSO2()+"'");}
		if(po.getCL2()!=null){sql.append(",'"+po.getCL2()+"'");}
		if(po.getNH3()!=null){sql.append(",'"+po.getNH3()+"'");}
		if(po.getCH3OH()!=null){sql.append(",'"+po.getCH3OH()+"'");}
		if(po.getCH3CH2OH()!=null){sql.append(",'"+po.getCH3CH2OH()+"'");}
		if(po.getCH4()!=null){sql.append(",'"+po.getCH4()+"'");}
		if(po.getDewPoint()!=null){sql.append(",'"+po.getDewPoint()+"'");}
		if(po.getFloodAlarmStatus()!=null){sql.append(",'"+po.getFloodAlarmStatus()+"'");}
		if(po.getFloodAlarmData()!=null){sql.append(",'"+po.getFloodAlarmData()+"'");}
		if(po.getTemperature1()!=null){sql.append(",'"+po.getTemperature1()+"'");}
		if(po.getTemperature2()!=null){sql.append(",'"+po.getTemperature2()+"'");}
		if(po.getTemperature3()!=null){sql.append(",'"+po.getTemperature3()+"'");}
		if(po.getTemperature4()!=null){sql.append(",'"+po.getTemperature4()+"'");}
		if(po.getTemperature5()!=null){sql.append(",'"+po.getTemperature5()+"'");}
		if(po.getTemperature6()!=null){sql.append(",'"+po.getTemperature6()+"'");}
		if(po.getHumidity1()!=null){sql.append(",'"+po.getHumidity1()+"'");}
		if(po.getHumidity2()!=null){sql.append(",'"+po.getHumidity2()+"'");}
		if(po.getWindSpeed()!=null){sql.append(",'"+po.getWindSpeed()+"'");}
		if(po.getWindDirection()!=null){sql.append(",'"+po.getWindDirection()+"'");}
		if(po.getRainfall()!=null){sql.append(",'"+po.getRainfall()+"'");}
		if(po.getPH()!=null){sql.append(",'"+po.getPH()+"'");}
		if(po.getEC()!=null){sql.append(",'"+po.getEC()+"'");}
		if(po.getSandyMoisture()!=null){sql.append(",'"+po.getSandyMoisture()+"'");}
		if(po.getClayMoisture()!=null){sql.append(",'"+po.getClayMoisture()+"'");}
		if(po.getPM1()!=null){sql.append(",'"+po.getPM1()+"'");}
		if(po.getPM2()!=null){sql.append(",'"+po.getPM2()+"'");}
		if(po.getPM10()!=null){sql.append(",'"+po.getPM10()+"'");}
		if(po.getLiquidLevelPa()!=null){sql.append(",'"+po.getLiquidLevelPa()+"'");}
		if(po.getLiquidLevelkPa()!=null){sql.append(",'"+po.getLiquidLevelkPa()+"'");}
		if(po.getLiquidLevelMPa()!=null){sql.append(",'"+po.getLiquidLevelMPa()+"'");}
		if(po.getLiquidLevelBar()!=null){sql.append(",'"+po.getLiquidLevelBar()+"'");}
		if(po.getLiquidLevelm()!=null){sql.append(",'"+po.getLiquidLevelm()+"'");}
		if(po.getOilTemperature()!=null){sql.append(",'"+po.getOilTemperature()+"'");}
		if(po.getMailboxLevel()!=null){sql.append(",'"+po.getMailboxLevel()+"'");}
		if(po.getSystemPressure()!=null){sql.append(",'"+po.getSystemPressure()+"'");}
		if(po.getNoRodpressure()!=null){sql.append(",'"+po.getNoRodpressure()+"'");}
		if(po.getRodpressure()!=null){sql.append(",'"+po.getRodpressure()+"'");}
		if(po.getOutputSwitch1()!=null){sql.append(",'"+po.getOutputSwitch1()+"'");}
		if(po.getOutputSwitch2()!=null){sql.append(",'"+po.getOutputSwitch2()+"'");}
		if(po.getOutputSwitch3()!=null){sql.append(",'"+po.getOutputSwitch3()+"'");}
		if(po.getOutputSwitch4()!=null){sql.append(",'"+po.getOutputSwitch4()+"'");}
		if(po.getOutputSwitch5()!=null){sql.append(",'"+po.getOutputSwitch5()+"'");}
		if(po.getOutputSwitch6()!=null){sql.append(",'"+po.getOutputSwitch6()+"'");}
		if(po.getOutputSwitch7()!=null){sql.append(",'"+po.getOutputSwitch7()+"'");}
		if(po.getOutputSwitch8()!=null){sql.append(",'"+po.getOutputSwitch8()+"'");}
		if(po.getInputSwitch1()!=null){sql.append(",'"+po.getInputSwitch1()+"'");}
		if(po.getInputSwitch2()!=null){sql.append(",'"+po.getInputSwitch2()+"'");}
		if(po.getInputSwitch3()!=null){sql.append(",'"+po.getInputSwitch3()+"'");}
		if(po.getInputSwitch4()!=null){sql.append(",'"+po.getInputSwitch4()+"'");}
		if(po.getInputSwitch5()!=null){sql.append(",'"+po.getInputSwitch5()+"'");}
		if(po.getInputSwitch6()!=null){sql.append(",'"+po.getInputSwitch6()+"'");}
		if(po.getInputSwitch7()!=null){sql.append(",'"+po.getInputSwitch7()+"'");}
		if(po.getInputSwitch8()!=null){sql.append(",'"+po.getInputSwitch8()+"'");}
		if(po.getAnalogA1()!=null){sql.append(",analogA1");}
		if(po.getAnalogA2()!=null){sql.append(",analogA2");}
		if(po.getAnalogA3()!=null){sql.append(",analogA3");}
		if(po.getAnalogA4()!=null){sql.append(",analogA4");}
		if(po.getAnalogA5()!=null){sql.append(",analogA5");}
		if(po.getAnalogA6()!=null){sql.append(",analogA6");}
		if(po.getAnalogA7()!=null){sql.append(",analogA7");}
		if(po.getAnalogA8()!=null){sql.append(",analogA8");}
		if(po.getAnalogV1()!=null){sql.append(",analogV1");}
		if(po.getAnalogV2()!=null){sql.append(",analogV2");}
		if(po.getAnalogV3()!=null){sql.append(",analogV3");}
		if(po.getAnalogV4()!=null){sql.append(",analogV4");}
		if(po.getAnalogV5()!=null){sql.append(",analogV5");}
		if(po.getAnalogV6()!=null){sql.append(",analogV6");}
		if(po.getAnalogV7()!=null){sql.append(",analogV7");}
		if(po.getAnalogV8()!=null){sql.append(",analogV8");}
		
		sql.append(")");
		int Result=DbHelper.ExecuteSql(DBBean.mysqldata,sql.toString());
		//System.out.println(sql.toString());
		return Result;
	}
	
	 /**更新最新表数据 */
	public int updateTaDataNew(EquipmetDataPo po){
		StringBuilder sql=new StringBuilder("update ta_equipmet_data_new set ");
		if(po.getDataTime()!=null &&! "".equals(po.getDataTime())){sql.append("dataTime='"+po.getDataTime()+"'");}
		if(po.getTemperature()!=null){sql.append(",temperature='"+po.getTemperature()+"'");}
		if(po.getHumidity()!=null){sql.append(",humidity='"+po.getHumidity()+"'");}
		if(po.getIlluminance()!=null){sql.append(",illuminance='"+po.getIlluminance()+"'");}
		if(po.getSoilTemperature()!=null){sql.append(",soilTemperature='"+po.getSoilTemperature()+"'");}
		if(po.getSoliWater()!=null){sql.append(",soliWater='"+po.getSoliWater()+"'");}
		if(po.getAirPressure()!=null){sql.append(",airPressure='"+po.getAirPressure()+"'");}
		if(po.getLiquidLevel()!=null){sql.append(",liquidLevel='"+po.getLiquidLevel()+"'");}
		if(po.getFlow()!=null){sql.append(",flow='"+po.getFlow()+"'");}
		if(po.getUltrasonic()!=null){sql.append(",ultrasonic='"+po.getUltrasonic()+"'");}
		if(po.getRadar()!=null){sql.append(",radar='"+po.getRadar()+"'");}
		if(po.getSingleInterface()!=null){sql.append(",singleInterface='"+po.getSingleInterface()+"'");}
		if(po.getBiface()!=null){sql.append(",biface='"+po.getBiface()+"'");}
		if(po.getFlooding()!=null){sql.append(",flooding='"+po.getFlooding()+"'");}
		if(po.getSmokeDetector()!=null){sql.append(",SmokeDetector='"+po.getSmokeDetector()+"'");}
		if(po.getOpenFireDetector()!=null){sql.append(",OpenFireDetector='"+po.getOpenFireDetector()+"'");}
		if(po.getInfraredDetector()!=null){sql.append(",infraredDetector='"+po.getInfraredDetector()+"'");}
		if(po.getFrequencyLevelSwitch()!=null){sql.append(",frequencyLevelSwitch='"+po.getFrequencyLevelSwitch()+"'");}
		if(po.getFloatSwitch()!=null){sql.append(",floatSwitch='"+po.getFloatSwitch()+"'");}
		if(po.getTuningLevelSwitch()!=null){sql.append(",tuningLevelSwitch='"+po.getTuningLevelSwitch()+"'");}
		if(po.getCO2()!=null){sql.append(",CO2='"+po.getCO2()+"'");}
		if(po.getDust()!=null){sql.append(",dust='"+po.getDust()+"'");}
		if(po.getAirQualityGrade()!=null){sql.append(",airQualityGrade='"+po.getAirQualityGrade()+"'");}
		if(po.getCO()!=null){sql.append(",CO='"+po.getCO()+"'");}
		if(po.getH2()!=null){sql.append(",H2='"+po.getH2()+"'");}
		if(po.getH2S()!=null){sql.append(",H2S='"+po.getH2S()+"'");}
		if(po.getO2()!=null){sql.append(",O2='"+po.getO2()+"'");}
		if(po.getSO2()!=null){sql.append(",SO2='"+po.getSO2()+"'");}
		if(po.getCL2()!=null){sql.append(",CL2='"+po.getCL2()+"'");}
		if(po.getNH3()!=null){sql.append(",NH3='"+po.getNH3()+"'");}
		if(po.getCH3OH()!=null){sql.append(",CH3OH='"+po.getCH3OH()+"'");}
		if(po.getCH3CH2OH()!=null){sql.append(",CH3CH2OH='"+po.getCH3CH2OH()+"'");}
		if(po.getCH4()!=null){sql.append(",CH4='"+po.getCH4()+"'");}
		if(po.getDewPoint()!=null){sql.append(",dewPoint='"+po.getDewPoint()+"'");}
		if(po.getFloodAlarmStatus()!=null){sql.append(",floodAlarmStatus='"+po.getFloodAlarmStatus()+"'");}
		if(po.getFloodAlarmData()!=null){sql.append(",floodAlarmData='"+po.getFloodAlarmData()+"'");}
		if(po.getTemperature1()!=null){sql.append(",temperature1='"+po.getTemperature1()+"'");}
		if(po.getTemperature2()!=null){sql.append(",temperature2='"+po.getTemperature2()+"'");}
		if(po.getTemperature3()!=null){sql.append(",temperature3='"+po.getTemperature3()+"'");}
		if(po.getTemperature4()!=null){sql.append(",temperature4='"+po.getTemperature4()+"'");}
		if(po.getTemperature5()!=null){sql.append(",temperature5='"+po.getTemperature5()+"'");}
		if(po.getTemperature6()!=null){sql.append(",temperature6='"+po.getTemperature6()+"'");}
		if(po.getHumidity1()!=null){sql.append(",humidity1='"+po.getHumidity1()+"'");}
		if(po.getHumidity2()!=null){sql.append(",humidity2='"+po.getHumidity2()+"'");}
		if(po.getWindSpeed()!=null){sql.append(",windSpeed='"+po.getWindSpeed()+"'");}
		if(po.getWindDirection()!=null){sql.append(",windDirection='"+po.getWindDirection()+"'");}
		if(po.getRainfall()!=null){sql.append(",rainfall='"+po.getRainfall()+"'");}
		if(po.getPH()!=null){sql.append(",PH='"+po.getPH()+"'");}
		if(po.getEC()!=null){sql.append(",EC='"+po.getEC()+"'");}
		if(po.getSandyMoisture()!=null){sql.append(",sandyMoisture='"+po.getSandyMoisture()+"'");}
		if(po.getClayMoisture()!=null){sql.append(",clayMoisture='"+po.getClayMoisture()+"'");}
		if(po.getPM1()!=null){sql.append(",PM1='"+po.getPM1()+"'");}
		if(po.getPM2()!=null){sql.append(",PM2='"+po.getPM2()+"'");}
		if(po.getPM10()!=null){sql.append(",PM10='"+po.getPM10()+"'");}
		if(po.getLiquidLevelPa()!=null){sql.append(",liquidLevelPa='"+po.getLiquidLevelPa()+"'");}
		if(po.getLiquidLevelkPa()!=null){sql.append(",liquidLevelkPa='"+po.getLiquidLevelkPa()+"'");}
		if(po.getLiquidLevelMPa()!=null){sql.append(",liquidLevelMPa='"+po.getLiquidLevelMPa()+"'");}
		if(po.getLiquidLevelBar()!=null){sql.append(",liquidLevelBar='"+po.getLiquidLevelBar()+"'");}
		if(po.getLiquidLevelm()!=null){sql.append(",liquidLevelm='"+po.getLiquidLevelm()+"'");}
		if(po.getOilTemperature()!=null){sql.append(",oilTemperature='"+po.getOilTemperature()+"'");}
		if(po.getMailboxLevel()!=null){sql.append(",mailboxLevel='"+po.getMailboxLevel()+"'");}
		if(po.getSystemPressure()!=null){sql.append(",systemPressure='"+po.getSystemPressure()+"'");}
		if(po.getNoRodpressure()!=null){sql.append(",noRodpressure='"+po.getNoRodpressure()+"'");}
		if(po.getRodpressure()!=null){sql.append(",Rodpressure='"+po.getRodpressure()+"'");}
		if(po.getOutputSwitch1()!=null){sql.append(",outputSwitch1='"+po.getOutputSwitch1()+"'");}
		if(po.getOutputSwitch2()!=null){sql.append(",outputSwitch2='"+po.getOutputSwitch2()+"'");}
		if(po.getOutputSwitch3()!=null){sql.append(",outputSwitch3='"+po.getOutputSwitch3()+"'");}
		if(po.getOutputSwitch4()!=null){sql.append(",outputSwitch4='"+po.getOutputSwitch4()+"'");}
		if(po.getOutputSwitch5()!=null){sql.append(",outputSwitch5='"+po.getOutputSwitch5()+"'");}
		if(po.getOutputSwitch6()!=null){sql.append(",outputSwitch6='"+po.getOutputSwitch6()+"'");}
		if(po.getOutputSwitch7()!=null){sql.append(",outputSwitch7='"+po.getOutputSwitch7()+"'");}
		if(po.getOutputSwitch8()!=null){sql.append(",outputSwitch8='"+po.getOutputSwitch8()+"'");}
		if(po.getInputSwitch1()!=null){sql.append(",inputSwitch1='"+po.getInputSwitch1()+"'");}
		if(po.getInputSwitch2()!=null){sql.append(",inputSwitch2='"+po.getInputSwitch2()+"'");}
		if(po.getInputSwitch3()!=null){sql.append(",inputSwitch3='"+po.getInputSwitch3()+"'");}
		if(po.getInputSwitch4()!=null){sql.append(",inputSwitch4='"+po.getInputSwitch4()+"'");}
		if(po.getInputSwitch5()!=null){sql.append(",inputSwitch5='"+po.getInputSwitch5()+"'");}
		if(po.getInputSwitch6()!=null){sql.append(",inputSwitch6='"+po.getInputSwitch6()+"'");}
		if(po.getInputSwitch7()!=null){sql.append(",inputSwitch7='"+po.getInputSwitch7()+"'");}
		if(po.getInputSwitch8()!=null){sql.append(",inputSwitch8='"+po.getInputSwitch8()+"'");}
		if(po.getAnalogA1()!=null){sql.append(",analogA1='"+po.getAnalogA1()+"'");}
		if(po.getAnalogA2()!=null){sql.append(",analogA2='"+po.getAnalogA2()+"'");}
		if(po.getAnalogA3()!=null){sql.append(",analogA3='"+po.getAnalogA3()+"'");}
		if(po.getAnalogA4()!=null){sql.append(",analogA4='"+po.getAnalogA4()+"'");}
		if(po.getAnalogA5()!=null){sql.append(",analogA5='"+po.getAnalogA5()+"'");}
		if(po.getAnalogA6()!=null){sql.append(",analogA6='"+po.getAnalogA6()+"'");}
		if(po.getAnalogA7()!=null){sql.append(",analogA7='"+po.getAnalogA7()+"'");}
		if(po.getAnalogA8()!=null){sql.append(",analogA8='"+po.getAnalogA8()+"'");}
		if(po.getAnalogV1()!=null){sql.append(",analogV1='"+po.getAnalogV1()+"'");}
		if(po.getAnalogV2()!=null){sql.append(",analogV2='"+po.getAnalogV2()+"'");}
		if(po.getAnalogV3()!=null){sql.append(",analogV3='"+po.getAnalogV3()+"'");}
		if(po.getAnalogV4()!=null){sql.append(",analogV4='"+po.getAnalogV4()+"'");}
		if(po.getAnalogV5()!=null){sql.append(",analogV5='"+po.getAnalogV5()+"'");}
		if(po.getAnalogV6()!=null){sql.append(",analogV6='"+po.getAnalogV6()+"'");}
		if(po.getAnalogV7()!=null){sql.append(",analogV7='"+po.getAnalogV7()+"'");}
		if(po.getAnalogV8()!=null){sql.append(",analogV8='"+po.getAnalogV8()+"'");}		
		
		sql.append(" where pk_equipment='" + po.getPk_equipment()+"'");
		int Result=DbHelper.ExecuteSql(DBBean.mysqldata,sql.toString());
		//System.out.println(sql.toString());
		return Result;
	}
	
	/**
	 * 插入历史表数据
	 * @param po
	 * @return
	 */
	public int AddTaData(EquipmetDataPo po){
		StringBuilder sql=new StringBuilder("insert into ta_equipmet_data (");
		if(po.getPk_equipment()!=null && !"".equals(po.getPk_equipment())){sql.append("pk_equipment");}
		if(po.getDataTime()!=null &&! "".equals(po.getDataTime())){sql.append(",dataTime");}
		if(po.getTemperature()!=null){sql.append(",temperature");}
		if(po.getHumidity()!=null){sql.append(",humidity");}
		if(po.getIlluminance()!=null){sql.append(",illuminance");}
		if(po.getSoilTemperature()!=null){sql.append(",soilTemperature");}
		if(po.getSoliWater()!=null){sql.append(",soliWater");}
		if(po.getAirPressure()!=null){sql.append(",airPressure");}
		if(po.getLiquidLevel()!=null){sql.append(",liquidLevel");}
		if(po.getFlow()!=null){sql.append(",flow");}
		if(po.getUltrasonic()!=null){sql.append(",ultrasonic");}
		if(po.getRadar()!=null){sql.append(",radar");}
		if(po.getSingleInterface()!=null){sql.append(",singleInterface");}
		if(po.getBiface()!=null){sql.append(",biface");}
		if(po.getFlooding()!=null){sql.append(",flooding");}
		if(po.getSmokeDetector()!=null){sql.append(",SmokeDetector");}
		if(po.getOpenFireDetector()!=null){sql.append(",OpenFireDetector");}
		if(po.getInfraredDetector()!=null){sql.append(",infraredDetector");}
		if(po.getFrequencyLevelSwitch()!=null){sql.append(",frequencyLevelSwitch");}
		if(po.getFloatSwitch()!=null){sql.append(",floatSwitch");}
		if(po.getTuningLevelSwitch()!=null){sql.append(",tuningLevelSwitch");}
		if(po.getCO2()!=null){sql.append(",CO2");}
		if(po.getDust()!=null){sql.append(",dust");}
		if(po.getAirQualityGrade()!=null){sql.append(",airQualityGrade");}
		if(po.getCO()!=null){sql.append(",CO");}
		if(po.getH2()!=null){sql.append(",H2");}
		if(po.getH2S()!=null){sql.append(",H2S");}
		if(po.getO2()!=null){sql.append(",O2");}
		if(po.getSO2()!=null){sql.append(",SO2");}
		if(po.getCL2()!=null){sql.append(",CL2");}
		if(po.getNH3()!=null){sql.append(",NH3");}
		if(po.getCH3OH()!=null){sql.append(",CH3OH");}
		if(po.getCH3CH2OH()!=null){sql.append(",CH3CH2OH");}
		if(po.getCH4()!=null){sql.append(",CH4");}
		if(po.getDewPoint()!=null){sql.append(",dewPoint");}
		if(po.getFloodAlarmStatus()!=null){sql.append(",floodAlarmStatus");}
		if(po.getFloodAlarmData()!=null){sql.append(",floodAlarmData");}
		if(po.getTemperature1()!=null){sql.append(",temperature1");}
		if(po.getTemperature2()!=null){sql.append(",temperature2");}
		if(po.getTemperature3()!=null){sql.append(",temperature3");}
		if(po.getTemperature4()!=null){sql.append(",temperature4");}
		if(po.getTemperature5()!=null){sql.append(",temperature5");}
		if(po.getTemperature6()!=null){sql.append(",temperature6");}
		if(po.getHumidity1()!=null){sql.append(",humidity1");}
		if(po.getHumidity2()!=null){sql.append(",humidity2");}
		if(po.getWindSpeed()!=null){sql.append(",windSpeed");}
		if(po.getWindDirection()!=null){sql.append(",windDirection");}
		if(po.getRainfall()!=null){sql.append(",rainfall");}
		if(po.getPH()!=null){sql.append(",PH");}
		if(po.getEC()!=null){sql.append(",EC");}
		if(po.getSandyMoisture()!=null){sql.append(",sandyMoisture");}
		if(po.getClayMoisture()!=null){sql.append(",clayMoisture");}
		if(po.getPM1()!=null){sql.append(",PM1");}
		if(po.getPM2()!=null){sql.append(",PM2");}
		if(po.getPM10()!=null){sql.append(",PM10");}
		if(po.getLiquidLevelPa()!=null){sql.append(",liquidLevelPa");}
		if(po.getLiquidLevelkPa()!=null){sql.append(",liquidLevelkPa");}
		if(po.getLiquidLevelMPa()!=null){sql.append(",liquidLevelMPa");}
		if(po.getLiquidLevelBar()!=null){sql.append(",liquidLevelBar");}
		if(po.getLiquidLevelm()!=null){sql.append(",liquidLevelm");}
		if(po.getOilTemperature()!=null){sql.append(",oilTemperature");}
		if(po.getMailboxLevel()!=null){sql.append(",mailboxLevel");}
		if(po.getSystemPressure()!=null){sql.append(",systemPressure");}
		if(po.getNoRodpressure()!=null){sql.append(",noRodpressure");}
		if(po.getRodpressure()!=null){sql.append(",Rodpressure");}
		if(po.getOutputSwitch1()!=null){sql.append(",outputSwitch1");}
		if(po.getOutputSwitch2()!=null){sql.append(",outputSwitch2");}
		if(po.getOutputSwitch3()!=null){sql.append(",outputSwitch3");}
		if(po.getOutputSwitch4()!=null){sql.append(",outputSwitch4");}
		if(po.getOutputSwitch5()!=null){sql.append(",outputSwitch5");}
		if(po.getOutputSwitch6()!=null){sql.append(",outputSwitch6");}
		if(po.getOutputSwitch7()!=null){sql.append(",outputSwitch7");}
		if(po.getOutputSwitch8()!=null){sql.append(",outputSwitch8");}
		if(po.getInputSwitch1()!=null){sql.append(",inputSwitch1");}
		if(po.getInputSwitch2()!=null){sql.append(",inputSwitch2");}
		if(po.getInputSwitch3()!=null){sql.append(",inputSwitch3");}
		if(po.getInputSwitch4()!=null){sql.append(",inputSwitch4");}
		if(po.getInputSwitch5()!=null){sql.append(",inputSwitch5");}
		if(po.getInputSwitch6()!=null){sql.append(",inputSwitch6");}
		if(po.getInputSwitch7()!=null){sql.append(",inputSwitch7");}
		if(po.getInputSwitch8()!=null){sql.append(",inputSwitch8");}
		if(po.getAnalogA1()!=null){sql.append(",analogA1");}
		if(po.getAnalogA2()!=null){sql.append(",analogA2");}
		if(po.getAnalogA3()!=null){sql.append(",analogA3");}
		if(po.getAnalogA4()!=null){sql.append(",analogA4");}
		if(po.getAnalogA5()!=null){sql.append(",analogA5");}
		if(po.getAnalogA6()!=null){sql.append(",analogA6");}
		if(po.getAnalogA7()!=null){sql.append(",analogA7");}
		if(po.getAnalogA8()!=null){sql.append(",analogA8");}
		if(po.getAnalogV1()!=null){sql.append(",analogV1");}
		if(po.getAnalogV2()!=null){sql.append(",analogV2");}
		if(po.getAnalogV3()!=null){sql.append(",analogV3");}
		if(po.getAnalogV4()!=null){sql.append(",analogV4");}
		if(po.getAnalogV5()!=null){sql.append(",analogV5");}
		if(po.getAnalogV6()!=null){sql.append(",analogV6");}
		if(po.getAnalogV7()!=null){sql.append(",analogV7");}
		if(po.getAnalogV8()!=null){sql.append(",analogV8");}
		
		sql.append(") values(");
		
		if(po.getPk_equipment()!=null && !"".equals(po.getPk_equipment())){sql.append("'"+po.getPk_equipment()+"'");}
		if(po.getDataTime()!=null &&! "".equals(po.getDataTime())){sql.append(",'"+po.getDataTime()+"'");}
		if(po.getTemperature()!=null){sql.append(",'"+po.getTemperature()+"'");}
		if(po.getHumidity()!=null){sql.append(",'"+po.getHumidity()+"'");}
		if(po.getIlluminance()!=null){sql.append(",'"+po.getIlluminance()+"'");}
		if(po.getSoilTemperature()!=null){sql.append(",'"+po.getSoilTemperature()+"'");}
		if(po.getSoliWater()!=null){sql.append(",'"+po.getSoliWater()+"'");}
		if(po.getAirPressure()!=null){sql.append(",'"+po.getAirPressure()+"'");}
		if(po.getLiquidLevel()!=null){sql.append(",'"+po.getLiquidLevel()+"'");}
		if(po.getFlow()!=null){sql.append(",'"+po.getFlow()+"'");}
		if(po.getUltrasonic()!=null){sql.append(",'"+po.getUltrasonic()+"'");}
		if(po.getRadar()!=null){sql.append(",'"+po.getRadar()+"'");}
		if(po.getSingleInterface()!=null){sql.append(",'"+po.getSingleInterface()+"'");}
		if(po.getBiface()!=null){sql.append(",'"+po.getBiface()+"'");}
		if(po.getFlooding()!=null){sql.append(",'"+po.getFlooding()+"'");}
		if(po.getSmokeDetector()!=null){sql.append(",'"+po.getSmokeDetector()+"'");}
		if(po.getOpenFireDetector()!=null){sql.append(",'"+po.getOpenFireDetector()+"'");}
		if(po.getInfraredDetector()!=null){sql.append(",'"+po.getInfraredDetector()+"'");}
		if(po.getFrequencyLevelSwitch()!=null){sql.append(",'"+po.getFrequencyLevelSwitch()+"'");}
		if(po.getFloatSwitch()!=null){sql.append(",'"+po.getFloatSwitch()+"'");}
		if(po.getTuningLevelSwitch()!=null){sql.append(",'"+po.getTuningLevelSwitch()+"'");}
		if(po.getCO2()!=null){sql.append(",'"+po.getCO2()+"'");}
		if(po.getDust()!=null){sql.append(",'"+po.getDust()+"'");}
		if(po.getAirQualityGrade()!=null){sql.append(",'"+po.getAirQualityGrade()+"'");}
		if(po.getCO()!=null){sql.append(",'"+po.getCO()+"'");}
		if(po.getH2()!=null){sql.append(",'"+po.getH2()+"'");}
		if(po.getH2S()!=null){sql.append(",'"+po.getH2S()+"'");}
		if(po.getO2()!=null){sql.append(",'"+po.getO2()+"'");}
		if(po.getSO2()!=null){sql.append(",'"+po.getSO2()+"'");}
		if(po.getCL2()!=null){sql.append(",'"+po.getCL2()+"'");}
		if(po.getNH3()!=null){sql.append(",'"+po.getNH3()+"'");}
		if(po.getCH3OH()!=null){sql.append(",'"+po.getCH3OH()+"'");}
		if(po.getCH3CH2OH()!=null){sql.append(",'"+po.getCH3CH2OH()+"'");}
		if(po.getCH4()!=null){sql.append(",'"+po.getCH4()+"'");}
		if(po.getDewPoint()!=null){sql.append(",'"+po.getDewPoint()+"'");}
		if(po.getFloodAlarmStatus()!=null){sql.append(",'"+po.getFloodAlarmStatus()+"'");}
		if(po.getFloodAlarmData()!=null){sql.append(",'"+po.getFloodAlarmData()+"'");}
		if(po.getTemperature1()!=null){sql.append(",'"+po.getTemperature1()+"'");}
		if(po.getTemperature2()!=null){sql.append(",'"+po.getTemperature2()+"'");}
		if(po.getTemperature3()!=null){sql.append(",'"+po.getTemperature3()+"'");}
		if(po.getTemperature4()!=null){sql.append(",'"+po.getTemperature4()+"'");}
		if(po.getTemperature5()!=null){sql.append(",'"+po.getTemperature5()+"'");}
		if(po.getTemperature6()!=null){sql.append(",'"+po.getTemperature6()+"'");}
		if(po.getHumidity1()!=null){sql.append(",'"+po.getHumidity1()+"'");}
		if(po.getHumidity2()!=null){sql.append(",'"+po.getHumidity2()+"'");}
		if(po.getWindSpeed()!=null){sql.append(",'"+po.getWindSpeed()+"'");}
		if(po.getWindDirection()!=null){sql.append(",'"+po.getWindDirection()+"'");}
		if(po.getRainfall()!=null){sql.append(",'"+po.getRainfall()+"'");}
		if(po.getPH()!=null){sql.append(",'"+po.getPH()+"'");}
		if(po.getEC()!=null){sql.append(",'"+po.getEC()+"'");}
		if(po.getSandyMoisture()!=null){sql.append(",'"+po.getSandyMoisture()+"'");}
		if(po.getClayMoisture()!=null){sql.append(",'"+po.getClayMoisture()+"'");}
		if(po.getPM1()!=null){sql.append(",'"+po.getPM1()+"'");}
		if(po.getPM2()!=null){sql.append(",'"+po.getPM2()+"'");}
		if(po.getPM10()!=null){sql.append(",'"+po.getPM10()+"'");}
		if(po.getLiquidLevelPa()!=null){sql.append(",'"+po.getLiquidLevelPa()+"'");}
		if(po.getLiquidLevelkPa()!=null){sql.append(",'"+po.getLiquidLevelkPa()+"'");}
		if(po.getLiquidLevelMPa()!=null){sql.append(",'"+po.getLiquidLevelMPa()+"'");}
		if(po.getLiquidLevelBar()!=null){sql.append(",'"+po.getLiquidLevelBar()+"'");}
		if(po.getLiquidLevelm()!=null){sql.append(",'"+po.getLiquidLevelm()+"'");}
		if(po.getOilTemperature()!=null){sql.append(",'"+po.getOilTemperature()+"'");}
		if(po.getMailboxLevel()!=null){sql.append(",'"+po.getMailboxLevel()+"'");}
		if(po.getSystemPressure()!=null){sql.append(",'"+po.getSystemPressure()+"'");}
		if(po.getNoRodpressure()!=null){sql.append(",'"+po.getNoRodpressure()+"'");}
		if(po.getRodpressure()!=null){sql.append(",'"+po.getRodpressure()+"'");}
		if(po.getOutputSwitch1()!=null){sql.append(",'"+po.getOutputSwitch1()+"'");}
		if(po.getOutputSwitch2()!=null){sql.append(",'"+po.getOutputSwitch2()+"'");}
		if(po.getOutputSwitch3()!=null){sql.append(",'"+po.getOutputSwitch3()+"'");}
		if(po.getOutputSwitch4()!=null){sql.append(",'"+po.getOutputSwitch4()+"'");}
		if(po.getOutputSwitch5()!=null){sql.append(",'"+po.getOutputSwitch5()+"'");}
		if(po.getOutputSwitch6()!=null){sql.append(",'"+po.getOutputSwitch6()+"'");}
		if(po.getOutputSwitch7()!=null){sql.append(",'"+po.getOutputSwitch7()+"'");}
		if(po.getOutputSwitch8()!=null){sql.append(",'"+po.getOutputSwitch8()+"'");}
		if(po.getInputSwitch1()!=null){sql.append(",'"+po.getInputSwitch1()+"'");}
		if(po.getInputSwitch2()!=null){sql.append(",'"+po.getInputSwitch2()+"'");}
		if(po.getInputSwitch3()!=null){sql.append(",'"+po.getInputSwitch3()+"'");}
		if(po.getInputSwitch4()!=null){sql.append(",'"+po.getInputSwitch4()+"'");}
		if(po.getInputSwitch5()!=null){sql.append(",'"+po.getInputSwitch5()+"'");}
		if(po.getInputSwitch6()!=null){sql.append(",'"+po.getInputSwitch6()+"'");}
		if(po.getInputSwitch7()!=null){sql.append(",'"+po.getInputSwitch7()+"'");}
		if(po.getInputSwitch8()!=null){sql.append(",'"+po.getInputSwitch8()+"'");}
		if(po.getAnalogA1()!=null){sql.append(",analogA1");}
		if(po.getAnalogA2()!=null){sql.append(",analogA2");}
		if(po.getAnalogA3()!=null){sql.append(",analogA3");}
		if(po.getAnalogA4()!=null){sql.append(",analogA4");}
		if(po.getAnalogA5()!=null){sql.append(",analogA5");}
		if(po.getAnalogA6()!=null){sql.append(",analogA6");}
		if(po.getAnalogA7()!=null){sql.append(",analogA7");}
		if(po.getAnalogA8()!=null){sql.append(",analogA8");}
		if(po.getAnalogV1()!=null){sql.append(",analogV1");}
		if(po.getAnalogV2()!=null){sql.append(",analogV2");}
		if(po.getAnalogV3()!=null){sql.append(",analogV3");}
		if(po.getAnalogV4()!=null){sql.append(",analogV4");}
		if(po.getAnalogV5()!=null){sql.append(",analogV5");}
		if(po.getAnalogV6()!=null){sql.append(",analogV6");}
		if(po.getAnalogV7()!=null){sql.append(",analogV7");}
		if(po.getAnalogV8()!=null){sql.append(",analogV8");}
		
		sql.append(")");
		int Result=DbHelper.ExecuteSql(DBBean.mysqldata,sql.toString());
		//System.out.println(sql.toString());
		return Result;
	}
}
