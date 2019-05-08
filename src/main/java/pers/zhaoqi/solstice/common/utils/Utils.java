package pers.zhaoqi.solstice.common.utils;

import javax.servlet.http.Cookie;

public class Utils {
    public static String getTokenForCookies(Cookie[] cookies) {
        String token = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }
        return token;
    }
}
