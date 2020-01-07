package com.cimc.modbus.command.common;

public class HttpCommandPo {
	private String equipmet_id;
	private String command_type;
	private String command_content;
	private String start_loct;
	private String eq_number;
	private String type;
	private String address;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEquipmet_id() {
		return equipmet_id;
	}
	public void setEquipmet_id(String equipmet_id) {
		this.equipmet_id = equipmet_id;
	}
	public String getCommand_type() {
		return command_type;
	}
	public void setCommand_type(String command_type) {
		this.command_type = command_type;
	}
	public String getCommand_content() {
		return command_content;
	}
	public void setCommand_content(String command_content) {
		this.command_content = command_content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
}
