package com.jargoncentral.common.util;


import javax.servlet.http.HttpServletRequest;

public class HTTPRequestUtil {

    public static String extractIPAddress(HttpServletRequest request){
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
