package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses addresses = new RestoreIpAddresses();
        System.out.println(addresses.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        ipAddress(s, 0, new StringBuilder(), answer, 0);
        return answer;
    }

    public void ipAddress(String s, int index, StringBuilder sb, List<String> list, int dot) {
        if (dot == 4 || index >= s.length()) {
            if (dot == 4 && index == s.length() && isValid(sb)) {
                list.add(sb.toString().substring(0, sb.length() - 1)); // Remove the last dot
            }
            return;
        }

        for (int i = index; (i < index + 3) && i < s.length(); i++) {
            if (i == index && s.charAt(i) == '0') { // Leading zero check
                sb.append('0').append('.');
                ipAddress(s, i + 1, sb, list, dot + 1);
                sb.setLength(sb.length() - 2); // Remove the appended '0' and '.'
                break; // A segment starting with '0' must be '0'
            }

            int length = sb.length();
            sb.append(s.substring(index, i + 1)).append('.');
            ipAddress(s, i + 1, sb, list, dot + 1);
            sb.setLength(length); // Reset the StringBuilder to its original state
        }
    }

    public boolean isValid(StringBuilder sb) {
        String[] ips = sb.toString().split("\\.");
        if (ips.length != 4) return false;

        for (String ip : ips) {
            if (ip.isEmpty()) return false; // Check for empty segments
            if (ip.length() > 3) return false; // Length check
            if (ip.length() > 1 && ip.charAt(0) == '0') return false; // Leading zero check

            try {
                int num = Integer.parseInt(ip);
                if (num < 0 || num > 255) return false; // Range check
            } catch (NumberFormatException e) {
                return false; // Non-numeric segment
            }
        }

        return true;
    }
}
