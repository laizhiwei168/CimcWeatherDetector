package com.cimc.modbus.utils.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cimc.modbus.bean.common.ConstantBean;

public class DataLogUtil {

	private static DataLogUtil dataLog=new DataLogUtil();
	private DataLogUtil(){}
	public static DataLogUtil getLog_Exception(){
		return dataLog;
	}
	
	private SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd");//设置日期格式
	
	/** 
     * @将错误信息输入到txt中 
     * @param path 
     * @throws IOException 
     */  
    private void writelog_to_txt(String filpath,String filtname,String content) throws IOException{ 
    	//String filtname="";
    	String path =ConstantBean.constantMap.get("LOG_PATH").toString()+filpath;
        File F=new File(path,filtname);  //,filtname
        //如果文件不存在,就动态创建文件  
        /*if(!F.exists()){
        	F.getParentFile().mkdirs();
            F.createNewFile();  
        }*/
        
        if(!F.getParentFile().exists()){
        	F.getParentFile().mkdirs();
    	}
    	if(!F.exists()){
    		F.createNewFile();
    	}
        FileWriter fw=null;  
        String writeDate=this.get_nowDate()+"   "+"recv_data:"+content;  
        try {  
            //设置为:True,表示写入的时候追加数据  
            fw=new FileWriter(F, true);  
            //回车并换行  
            fw.write(writeDate+"\r\n");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            if(fw!=null){  
                fw.close();                  
            }  
        }  
  
    }  
    /** 
     * @获取系统当前时间 
     * @return 
     */  
    private  String get_nowDate(){  
        Calendar D=Calendar.getInstance();  
        int year=0;  
        int moth=0;  
        int day=0;  
        int hour=0;
        int minute=0;
        int second=0;
        year=D.get(Calendar.YEAR);  
        moth=D.get(Calendar.MONTH)+1;  
        day=D.get(Calendar.DAY_OF_MONTH);  
        hour=D.get(Calendar.HOUR_OF_DAY);
        minute=D.get(Calendar.MINUTE);
        second=D.get(Calendar.SECOND);
        String now_date=String.valueOf(year)+"-"+String.valueOf(moth)+"-"+String.valueOf(day)+" "+String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);  
        return now_date;  
    }  
    
    public void SaveGainDeviceMessage(String deviceId,String data_str){
    	String date=df.format(new Date());
    	String path="/iEco_gain/"+date;
    	String filtname=deviceId+".log";
    	if("".equals(deviceId)){
    		filtname="gain"+filtname;
    	}
    	try {
			this.writelog_to_txt(path,filtname, data_str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void SaveSentDeviceMessage(String deviceId,String data_str){
    	String date=df.format(new Date());
    	String path="/iEco_sent/"+date;
    	String filtname=deviceId+".log";
    	if("".equals(deviceId)){
    		filtname="sent"+filtname;
    	}
    	try {
			this.writelog_to_txt(path,filtname, data_str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void SaveGainCommand(String command_str){
    	String date=df.format(new Date());
    	String path="/gaincommand";
    	String filtname="gaincommand_"+date+".log";
    	try {
			this.writelog_to_txt(path,filtname, command_str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void SavePushEventdata(String eventdata_str){
    	String date=df.format(new Date());
    	String path="/pusheventdata";
    	String filtname="pusheventdata_"+date+".log";
    	try {
			this.writelog_to_txt(path,filtname, eventdata_str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void SaveFenceEventCommanddata(String fenceEventCommand_str){
    	String date=df.format(new Date());
    	String path="/fenceeventcommanddata";
    	String filtname="pusheventdata_"+date+".log";
    	try {
			this.writelog_to_txt(path,filtname, fenceEventCommand_str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
