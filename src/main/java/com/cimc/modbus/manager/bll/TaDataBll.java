package com.cimc.modbus.manager.bll;

import java.util.List;
import java.util.Map;

import com.cimc.modbus.manager.dal.TaDataDal;
import com.cimc.modbus.manager.po.EquipmetDataPo;


public class TaDataBll {

	private TaDataDal taDataDal=new TaDataDal();
	
	public List<Map<String, Object>> selectEquipmentById(String EQUIPMENT_ID){	
		List<Map<String, Object>> ls_Equipment=taDataDal.selectEquipmentById(EQUIPMENT_ID);
		return ls_Equipment;
	}
	
	
	public int addInfoTaDataNew(EquipmetDataPo po){
		List<Map<String, Object>> ls_TaData=taDataDal.selectTaDataByID(po.getPk_equipment());
		
		if(ls_TaData.isEmpty()){
			//插入最新表数据
			taDataDal.AddTaDataNew(po);
		}else{
			taDataDal.updateTaDataNew(po);
		}
		// 插入历史数据
		taDataDal.AddTaData(po);
		
		return 1;
	}
}
