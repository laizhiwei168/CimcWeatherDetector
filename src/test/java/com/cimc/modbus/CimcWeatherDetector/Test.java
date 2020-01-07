package com.cimc.modbus.CimcWeatherDetector;

public class Test {

	public static void main(String[] args) {
		System.out.println(0x0001+0xffff);
		System.out.println(0x00010000);
		System.out.println(0x00010000+0xCDB7);
		//System.out.println(bytes2IntAddFFFF(0xff68));
	}
	
	public static int  bytes2IntAddFFFF(int i){
		int i1=(int) ((0xff << 24) + (0xff << 16)+i);
		return i1;
	}
			
	
	public static int  bytes2Int(byte[] b, int start, int length) {
        int sum = 0;
        int end = start + length;
        for (int k = start; k < end; k++) {
            int n = ((int) b[k]) & 0xff;
            n <<= (--length) * 8;
            sum += n;
        }
        return sum;
    }
}
