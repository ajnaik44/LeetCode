package com.crr.dsa.crackingtheinterview;

public class ValidIPAddress {

	public static void main(String[] args) {
		String s ="2001:db8:85a3:0::8a2E:0370:7334";
		System.out.println(validIPAddress(s));
	}
	public static String validIPAddress(String ipaddress)
	{
		if(ipaddress.contains("."))
			return validIP4Arress(ipaddress) ?"IPv4":"Neither" ;
		else
			return validIP6Arress(ipaddress)?"IPv6":"Neither" ;
	}
	public static int countOccurrences(String input, char target) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }
	public static boolean validIP6Arress(String ipaddress) {
		String[] ips = ipaddress.split("\\:");
		if(countOccurrences(ipaddress,':')!=7)
			return false;
		System.out.println(ips.length);
		boolean result=true;
		try {
			if (ips.length != 8)
				return false;
			for (String ip : ips) {
				result = result &&  validHexaString(ip);
				if(!result)
					return result;
			}
		} catch (Exception e) {
			return false;
		}
		return result;
	}
	public static boolean validHexaString(String hexaString)
	{
		if(hexaString.length()>=0&&  hexaString.length()<=4)
		{
			for(char c:hexaString.toCharArray())
			{
				if( Character.isLetter(c)  && ( (c >='A' &&  c<='F' ) || (c>='a' &&  c<='f') ) ||  Character.isDigit(c))
					continue;
				else
					return false;
			}
		}
		return hexaString.length()>=1&&  hexaString.length()<=4 ?  true:false;
	}
	public static boolean validIP4Arress(String ipaddress) {
		if(countOccurrences(ipaddress,'.')!=3)
			return false;
		String[] ips = ipaddress.split("\\.");
		boolean result=true;
		try {
			if (ips.length != 4)
				return false;
			for (String ip : ips) {
				int temp = Integer.parseInt(ip);
				if (temp >= 0 && temp <= 255) {
					System.out.println("ddddddddddddd");
					result = result && checkLeadingZero(ip);
					System.out.println(result);
					if(result)
						continue;
					else 
						return false;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return result;
	}

	private static boolean checkLeadingZero(String ip) {
		System.out.println( ip);
		if (ip.contains("0")) {
			if (ip.charAt(0) == '0' && ip.length() > 1)
				return false;

		}
		return true;

	}
}
