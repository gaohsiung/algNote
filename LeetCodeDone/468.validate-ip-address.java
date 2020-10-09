/*
 * @lc app=leetcode id=468 lang=java
 *
 * [468] Validate IP Address
 */

// @lc code=start
class Solution {
    public String validIPAddress(String ip) {
        if (ip == null || ip.length() == 0 || ip.charAt(0) == '.' 
            || ip.charAt(ip.length()-1) == '.' || ip.charAt(0) == ':' 
            || ip.charAt(ip.length()-1) == ':') {
            return "Neither";
        }
        String[] ip4List = ip.split("\\.");
        if (ip4List.length == 4) {
            return isIp4(ip4List);
        }
        String[] ip6List = ip.split(":");
        if (ip6List.length == 8) {
            return isIp6(ip6List);
        }
        return "Neither";
    }
    private String isIp4(String[] ip4List) {
        for (String s: ip4List) {
            if (s.length() == 0 || s.length() >= 4) return "Neither";
            if (s.length() == 1 && s.charAt(0) == '0') continue;
            try {
                if (s.charAt(0) == '0' || Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }
    private String isIp6(String[] ip6List) {
        for (String s: ip6List) {
            if (s.length() == 0 || s.length() > 4) return "Neither";
            
            for (char c: s.toCharArray()) {
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')){
                    continue;
                } else {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
    public static void main(String[] args) {
        for (String s: "12::3:1:1:".split(":")) {
            System.out.println(s);
        }
    }
}
// @lc code=end

