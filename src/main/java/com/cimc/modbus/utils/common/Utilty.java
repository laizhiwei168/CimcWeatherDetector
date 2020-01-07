package com.cimc.modbus.utils.common;

import java.util.Arrays;
import java.util.List;



public class Utilty {    

    public static final int MIN_MID_VALUE = 1;

    public static final int MAX_MID_VALUE = 65535;


    //�ֽ���תΪ�޷�������
    public int bytes2Int(byte[] b, int start, int length) {
        int sum = 0;
        int end = start + length;
        for (int k = start; k < end; k++) {
            int n = ((int) b[k]) & 0xff;
            n <<= (--length) * 8;
            sum += n;
        }
        return sum;
    }
    
    public long bytes2Long(byte[] b, int start, int length) {
        long sum = 0;
        int end = start + length;
        for (int k = start; k < end; k++) {
        	long n = ((int) b[k]) & 0xff;
            n <<= (--length) * 8;
            sum += n;
        }
        return sum;
    }

    //����תΪ�ֽ���
    public byte[] int2Bytes(int value, int length) {
        byte[] b = new byte[length];
        for (int k = 0; k < length; k++) {
            b[length - k - 1] = (byte) ((value >> 8 * k) & 0xff);
        }
        return b;
    }

    //�ж�mid�Ƿ���Ч
    public boolean isValidofMid(int mId) {
        if (mId < MIN_MID_VALUE || mId > MAX_MID_VALUE) {
            return false;
        }
        return true;
    }

    /***
     * ���ֽ���ת��Ϊ16�����ַ���
     */
    public  String parseByte2HexStr(byte[] buf) {
        if (null == buf) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    
    /*CRC16-IBM 校验码*/
	public  int CRC16IBM(byte[] Buf, int len) {
		
		//CRC16-IBM Table
		 int[] CRC16Table = {
		    0x0000, 0xC0C1, 0xC181, 0x0140, 0xC301, 0x03C0, 0x0280, 0xC241,
		    0xC601, 0x06C0, 0x0780, 0xC741, 0x0500, 0xC5C1, 0xC481, 0x0440,
		    0xCC01, 0x0CC0, 0x0D80, 0xCD41, 0x0F00, 0xCFC1, 0xCE81, 0x0E40,
		    0x0A00, 0xCAC1, 0xCB81, 0x0B40, 0xC901, 0x09C0, 0x0880, 0xC841,
		    0xD801, 0x18C0, 0x1980, 0xD941, 0x1B00, 0xDBC1, 0xDA81, 0x1A40,
		    0x1E00, 0xDEC1, 0xDF81, 0x1F40, 0xDD01, 0x1DC0, 0x1C80, 0xDC41,
		    0x1400, 0xD4C1, 0xD581, 0x1540, 0xD701, 0x17C0, 0x1680, 0xD641,
		    0xD201, 0x12C0, 0x1380, 0xD341, 0x1100, 0xD1C1, 0xD081, 0x1040,
		    0xF001, 0x30C0, 0x3180, 0xF141, 0x3300, 0xF3C1, 0xF281, 0x3240,
		    0x3600, 0xF6C1, 0xF781, 0x3740, 0xF501, 0x35C0, 0x3480, 0xF441,
		    0x3C00, 0xFCC1, 0xFD81, 0x3D40, 0xFF01, 0x3FC0, 0x3E80, 0xFE41,
		    0xFA01, 0x3AC0, 0x3B80, 0xFB41, 0x3900, 0xF9C1, 0xF881, 0x3840,
		    0x2800, 0xE8C1, 0xE981, 0x2940, 0xEB01, 0x2BC0, 0x2A80, 0xEA41,
		    0xEE01, 0x2EC0, 0x2F80, 0xEF41, 0x2D00, 0xEDC1, 0xEC81, 0x2C40,
		    0xE401, 0x24C0, 0x2580, 0xE541, 0x2700, 0xE7C1, 0xE681, 0x2640,
		    0x2200, 0xE2C1, 0xE381, 0x2340, 0xE101, 0x21C0, 0x2080, 0xE041,
		    0xA001, 0x60C0, 0x6180, 0xA141, 0x6300, 0xA3C1, 0xA281, 0x6240,
		    0x6600, 0xA6C1, 0xA781, 0x6740, 0xA501, 0x65C0, 0x6480, 0xA441,
		    0x6C00, 0xACC1, 0xAD81, 0x6D40, 0xAF01, 0x6FC0, 0x6E80, 0xAE41,
		    0xAA01, 0x6AC0, 0x6B80, 0xAB41, 0x6900, 0xA9C1, 0xA881, 0x6840,
		    0x7800, 0xB8C1, 0xB981, 0x7940, 0xBB01, 0x7BC0, 0x7A80, 0xBA41,
		    0xBE01, 0x7EC0, 0x7F80, 0xBF41, 0x7D00, 0xBDC1, 0xBC81, 0x7C40,
		    0xB401, 0x74C0, 0x7580, 0xB541, 0x7700, 0xB7C1, 0xB681, 0x7640,
		    0x7200, 0xB2C1, 0xB381, 0x7340, 0xB101, 0x71C0, 0x7080, 0xB041,
		    0x5000, 0x90C1, 0x9181, 0x5140, 0x9301, 0x53C0, 0x5280, 0x9241,
		    0x9601, 0x56C0, 0x5780, 0x9741, 0x5500, 0x95C1, 0x9481, 0x5440,
		    0x9C01, 0x5CC0, 0x5D80, 0x9D41, 0x5F00, 0x9FC1, 0x9E81, 0x5E40,
		    0x5A00, 0x9AC1, 0x9B81, 0x5B40, 0x9901, 0x59C0, 0x5880, 0x9841,
		    0x8801, 0x48C0, 0x4980, 0x8941, 0x4B00, 0x8BC1, 0x8A81, 0x4A40,
		    0x4E00, 0x8EC1, 0x8F81, 0x4F40, 0x8D01, 0x4DC0, 0x4C80, 0x8C41,
		    0x4400, 0x84C1, 0x8581, 0x4540, 0x8701, 0x47C0, 0x4680, 0x8641,
		    0x8201, 0x42C0, 0x4380, 0x8341, 0x4100, 0x81C1, 0x8081, 0x4040
		};
		
		int result  = 0;
	    int tableNo = 0;
	    int i;

	    for(i = 0; i < len; i++)
	    {
	        tableNo = ((result & 0xff) ^ (Buf[i] & 0xff));
	        result  = ((result >> 8) & 0xff) ^ CRC16Table[tableNo];
	    }

	    return result;  

	}
    
    
    /*CRC16校验码*/
   	public  int CRC16(byte[] Buf, int len) {  
           int CRC;  
           int i, j;  
           CRC = 0xffff;  
           for (i = 0; i < len; i++) {  
               CRC = CRC ^ (Buf[i] & 0xff);  
               for (j = 0; j < 8; j++) {  
                   if ((CRC & 0x01) == 1)  
                       CRC = (CRC >> 1) ^ 0xA001;  
                   else  
                       CRC = CRC >> 1;  
               }  
           }  
           return CRC;  
       }
   	
   	
   	
   	
   	/*转换时间格式*/
   	public  String toDateTime(String dateTime) {    	
       	/*170804095101*/       	
   		return "20"+dateTime.substring(0,6)+"T"+dateTime.substring(6)+"Z";
   	}

   	/*十六进制数组数据根据起始索引与结束索引定位转换为字符串*/
   	@SuppressWarnings("unused")
   	public  String toStringByte(byte[] bytes, int start,int end) {
   		StringBuffer strbf=new StringBuffer();		
   		for(int i=start ; i<=end;i++) {
   			
   			if(Integer.toHexString(bytes[i]).length()==1) {
   				strbf.append("0"+Integer.toHexString(bytes[i]& 0xFF));
   			}else {
   				strbf.append(Integer.toHexString(bytes[i]& 0xFF).toUpperCase());
   			}
   			
   		}
   		
   		return strbf.toString();
   	}
   	
   	/*String转换为byte数组*/
   	public  byte[] hexStrToByteArray(String str)
	{
	    if (str == null) {
	        return null;
	    }
	    if (str.length() == 0) {
	        return new byte[0];
	    }
	    byte[] byteArray = new byte[str.length() / 2];
	    for (int i = 0; i < byteArray.length; i++){
	        String subStr = str.substring(2 * i, 2 * i + 2);
	        byteArray[i] = ((byte)Integer.parseInt(subStr, 16));
	    }
	    return byteArray;
	}
   	
   	public static int  bytes2IntAddFFFF(int i){
		int i1=(int) ((0xff << 24) + (0xff << 16)+i);
		return i1;
	}
    
    /*
     *处理16进制的String变成ACSLL码 
     */
    public String convertHexToString(String hex){  
    	  
        StringBuilder sb = new StringBuilder();  
        StringBuilder temp = new StringBuilder();  
    
        //49204c6f7665204a617661 split into two characters 49, 20, 4c...  
        for( int i=0; i<hex.length()-1; i+=2 ){  
    
            //grab the hex in pairs  
            String output = hex.substring(i, (i + 2));  
            //convert hex to decimal  
            int decimal = Integer.parseInt(output, 16);  
            //convert the decimal to character  
            sb.append((char)decimal);  
    
            temp.append(decimal);  
        }  
    
        return sb.toString();  
        }
    
    /*
     *处理ACSLL码变成16进制的String
     */
    public String convertStringToHex(String str){  
    	  
        char[] chars = str.toCharArray();
    
        StringBuffer hex = new StringBuffer();  
        for(int i = 0; i < chars.length; i++){  
          hex.append(Integer.toHexString((int)chars[i]));  
        }  
    
        return hex.toString();  
      }
    
    /**
	 * 合并字节数组
	 * 
	 * @param first
	 * @param rest
	 * @return
	 */
	public byte[] concatAll(byte[] first, byte[]... rest) {
		int totalLength = first.length;
		for (byte[] array : rest) {
			if (array != null) {
				totalLength += array.length;
			}
		}
		byte[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (byte[] array : rest) {
			if (array != null) {
				System.arraycopy(array, 0, result, offset, array.length);
				offset += array.length;
			}
		}
		return result;
	}

	/**
	 * 合并字节数组
	 * 
	 * @param rest
	 * @return
	 */
	public byte[] concatAll(List<byte[]> rest) {
		int totalLength = 0;
		for (byte[] array : rest) {
			if (array != null) {
				totalLength += array.length;
			}
		}
		byte[] result = new byte[totalLength];
		int offset = 0;
		for (byte[] array : rest) {
			if (array != null) {
				System.arraycopy(array, 0, result, offset, array.length);
				offset += array.length;
			}
		}
		return result;
	}
    

}
