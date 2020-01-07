package com.cimc.modbus.command.tool;

import com.cimc.modbus.command.common.ParameterConfigurationBean;
import com.cimc.modbus.utils.common.Utilty;



public class EncodeCommand {
	private  Utilty util=new  Utilty();
	public String HandleEncodeCommand(ParameterConfigurationBean contentBean){
		String msg_type=contentBean.getMsg_type();
		String address=contentBean.getAddress();
		String start_loct=contentBean.getStart_loct();
		String eq_number=contentBean.getEq_number();
	    
		
		String A1=contentBean.getA1();
		String A2=contentBean.getA2();
		String A3=contentBean.getA3();
		String A4=contentBean.getA4();
		String A5=contentBean.getA5();
		String A6=contentBean.getA6();
		String A7=contentBean.getA7();
		String A8=contentBean.getA8();
		
		
		String B1=contentBean.getB1();
		String B2=contentBean.getB2();
		String B3=contentBean.getB3();
		String B4=contentBean.getB4();
		String B5=contentBean.getB5();
		String B6=contentBean.getB6();
		
		
		StringBuffer strbf=new StringBuffer();
		
		 if(address!=null && address.length()==2){
			 strbf.append(address);
		 }else{
			 return null;
		 }
		
		 if(msg_type!=null && msg_type.length()==2){
			 strbf.append(msg_type);
		 }else{
			 return null;
		 }
		 
		 if(start_loct!=null && start_loct.length()==4){
			 strbf.append(start_loct);
		 }else{
			 return null;
		 }
		 
		 if(eq_number!=null && eq_number.length()==4){
			 strbf.append(eq_number);
		 }else{
			 return null;
		 }
		 
		 StringBuffer commad_strbf=new StringBuffer();
		 
		 // 控制参数
		 if(A1!=null && A1.length()==4){
			 commad_strbf.append("a104"+A1);
		 }
		 
		 if(A2!=null && A2.length()==4){
			 commad_strbf.append("a204"+A2);
		 }
		 
		 if(A3!=null && A3.length()==4){
			 commad_strbf.append("a304"+A3);
		 }
		 
		 if(A4!=null && A4.length()==4){
			 commad_strbf.append("a404"+A4);
		 }
		 
		 if(A5!=null && A5.length()==4){
			 commad_strbf.append("a504"+A5);
		 }
		 
		 if(A6!=null && A6.length()==4){
			 commad_strbf.append("a604"+A6);
		 }
		 
		 if(A7!=null && A7.length()==4){
			 commad_strbf.append("a704"+A7);
		 }
		 
		 if(A8!=null && A8.length()==4){
			 commad_strbf.append("a804"+A8);
		 }
		 
		 if(B1!=null && B1.length()==4){
			 commad_strbf.append("b104"+B1);
		 }
		 if(B2!=null && B2.length()==4){
			 commad_strbf.append("b204"+B2);
		 }
		 if(B3!=null && B3.length()==4){
			 commad_strbf.append("b304"+B3);
		 }
		 if(B4!=null && B4.length()==4){
			 commad_strbf.append("b404"+B4);
		 }
		 if(B5!=null && B5.length()==4){
			 commad_strbf.append("b504"+B5);
		 }
		 if(B6!=null && B6.length()==4){
			 commad_strbf.append("b604"+B6);
		 }
		 
		 if("10".equals(msg_type) && commad_strbf.length()>0){
			 byte[] leng=util.int2Bytes(commad_strbf.length()/2, 1);
			 String s_leng=util.toStringByte(leng, 0, leng.length-1);
			 strbf.append(s_leng+commad_strbf);
		 }
		 
		 return strbf.toString();
	}
	
	
	/*public static void main(String[] args) {
		EncodeCommand EncodeCommand=new EncodeCommand();
		ParameterConfigurationBean contentBean=new ParameterConfigurationBean();
		contentBean.setPumpFrequencyValue("41C80000");
		String str=EncodeCommand.HandleEncodeCommand(contentBean);
		System.out.println(str);
	}*/
}
