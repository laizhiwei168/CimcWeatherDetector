package com.cimc.modbus.command.common;

public class ParameterConfigurationBean {

	private String msg_type;
	private String address;
	private String start_loct;
	private String eq_number;
	
	
	/**开关量 （输出）*/
	private String A1;//
	private String A2;
	private String A3;
	private String A4;
	private String A5;	
	private String A6;//
 	private String A7;// 
 	private String A8;//
 	
 	/**开关量 （输入）*/
 	private String B1;// 
 	private String B2;// 
 	private String B3;// 
 	private String B4;// 
 	private String B5;// 
 	private String B6; //
 	
	
	public String getA1() {
		return A1;
	}
	public void setA1(String a1) {
		A1 = a1;
	}
	public String getA2() {
		return A2;
	}
	public void setA2(String a2) {
		A2 = a2;
	}
	public String getA3() {
		return A3;
	}
	public void setA3(String a3) {
		A3 = a3;
	}
	public String getA4() {
		return A4;
	}
	public void setA4(String a4) {
		A4 = a4;
	}
	public String getA5() {
		return A5;
	}
	public void setA5(String a5) {
		A5 = a5;
	}
	public String getA6() {
		return A6;
	}
	public void setA6(String a6) {
		A6 = a6;
	}
	public String getA7() {
		return A7;
	}
	public void setA7(String a7) {
		A7 = a7;
	}
	public String getA8() {
		return A8;
	}
	public void setA8(String a8) {
		A8 = a8;
	}
	public String getB1() {
		return B1;
	}
	public void setB1(String b1) {
		B1 = b1;
	}
	public String getB2() {
		return B2;
	}
	public void setB2(String b2) {
		B2 = b2;
	}
	public String getB3() {
		return B3;
	}
	public void setB3(String b3) {
		B3 = b3;
	}
	public String getB4() {
		return B4;
	}
	public void setB4(String b4) {
		B4 = b4;
	}
	public String getB5() {
		return B5;
	}
	public void setB5(String b5) {
		B5 = b5;
	}
	public String getB6() {
		return B6;
	}
	public void setB6(String b6) {
		B6 = b6;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getStart_loct() {
		return start_loct;
	}
	public void setStart_loct(String start_loct) {
		this.start_loct = start_loct;
	}
	
	public String getEq_number() {
		return eq_number;
	}
	public void setEq_number(String eq_number) {
		this.eq_number = eq_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
 
}
