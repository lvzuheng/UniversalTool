package com.lzh.utils.net;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ContrastsIP {
	InetAddress inetAddress = null;
	NetworkInterface networkInterface = null;
	
	public void contrasts(String ip){
		try {
//			inetAddress = InetAddress.getLocalHost();
//			networkInterface = NetworkInterface.getByInetAddress(inetAddress);
			int mask  = getIpV4Value("255.255.255.0");
		       System.out.println(mask);
			int ip1 = getIpV4Value("10.11.33.0");
			  System.out.println(ip1);
			int ip2 = getIpV4Value(ip);
			System.out.println(ip2);
			System.out.println((mask & ip1) +","+ (mask & ip2));
			System.out.println((mask & ip1) == (mask & ip2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String calcMaskByPrefixLength(int length) {
		   int mask = -1 << (32 - length);
	        int partsNum = 4;
	        int bitsOfPart = 8;
	        int maskParts[] = new int[partsNum];
	        int selector = 0x000000ff;
	        for (int i = 0; i < maskParts.length; i++) {
	            int pos = maskParts.length - 1 - i;
	            maskParts[pos] = (mask >> (i * bitsOfPart)) & selector;
	        }
	        String result = "";
	        result = result + maskParts[0];
	        for (int i = 1; i < maskParts.length; i++) {
	            result = result + "." + maskParts[i];
	        }
	        return result;
    }
	

	
	  public static int getIpV4Value(String ipOrMask)  
	     {  
	          byte[] addr = getIpV4Bytes(ipOrMask);  
	          int address1  = addr[3] & 0xFF;  
	          address1 |= ((addr[2] << 8) & 0xFF00);  
	          address1 |= ((addr[1] << 16) & 0xFF0000);  
	          address1 |= ((addr[0] << 24) & 0xFF000000);  
	          return address1;  
	     }  
	  
	     public static byte[] getIpV4Bytes(String ipOrMask)  
	     {  
	          try  
	          {  
	               String[] addrs = ipOrMask.split("\\.");  
	               int length = addrs.length;  
	               byte[] addr = new byte[length];  
	               for (int index = 0; index < length; index++)  
	               {  
	                    addr[index] = (byte) (Integer.parseInt(addrs[index]) & 0xff);  
	               }  
	               return addr;  
	          }  
	          catch (Exception e)  
	          {  
	          }  
	          return new byte[4];  
	     }  
	     
	     public InetAddress getInetAddress() {
	    	 if(inetAddress==null)
				try {
					inetAddress = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return inetAddress;
		}
}
