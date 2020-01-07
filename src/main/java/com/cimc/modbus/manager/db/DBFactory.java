package com.cimc.modbus.manager.db;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.cimc.modbus.manager.common.DBBean;

public class DBFactory {
	public static MysqldbPool mysqldatamysqldbPool= null;
	public static DruidPooledConnection getConnection(String DBname){		
		DruidPooledConnection dpc = null;
		if(DBBean.mysqldata.equals(DBname)){
			if(mysqldatamysqldbPool==null){
				mysqldatamysqldbPool=new MysqldbPool();				
			}
			dpc=mysqldatamysqldbPool.getConnection("/resources/mysqldatajdbc.properties");
		}
		return dpc;
	}
	
}
