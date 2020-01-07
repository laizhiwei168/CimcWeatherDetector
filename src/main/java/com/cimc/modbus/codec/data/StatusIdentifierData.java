package com.cimc.modbus.codec.data;

public class StatusIdentifierData {

	private int decimals;
	private boolean highByte;
	private boolean lenghtByte;
	private boolean valueByte;
	private boolean symbolByte;
	
	@Override
	public String toString() {
		return "StatusIdentifierData [decimals=" + decimals + ", highByte="
				+ highByte + ", lenghtByte=" + lenghtByte + ", valueByte="
				+ valueByte + ", symbolByte=" + symbolByte + "]";
	}
	public int getDecimals() {
		return decimals;
	}
	public void setDecimals(int decimals) {
		this.decimals = decimals;
	}
	public boolean isHighByte() {
		return highByte;
	}
	public void setHighByte(boolean highByte) {
		this.highByte = highByte;
	}
	public boolean isLenghtByte() {
		return lenghtByte;
	}
	public void setLenghtByte(boolean lenghtByte) {
		this.lenghtByte = lenghtByte;
	}
	public boolean isValueByte() {
		return valueByte;
	}
	public void setValueByte(boolean valueByte) {
		this.valueByte = valueByte;
	}
	public boolean isSymbolByte() {
		return symbolByte;
	}
	public void setSymbolByte(boolean symbolByte) {
		this.symbolByte = symbolByte;
	}
		
}
