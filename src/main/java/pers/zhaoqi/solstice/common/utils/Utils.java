package pers.zhaoqi.solstice.common.utils;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.zhaoqi.solstice.common.entity.BaseEntity;
import pers.zhaoqi.solstice.common.enums.KeyEnums;
import pers.zhaoqi.solstice.product.entity.ProductInfo;
import pers.zhaoqi.solstice.userinfo.entity.UserInfo;
import pers.zhaoqi.solstice.userinfo.service.IUserInfoService;
import pers.zhaoqi.solstice.userlogin.jwt.JWTUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Component
public class Utils {

    private static IUserInfoService userInfoService;

    @Autowired()
    public void setUserInfoService(IUserInfoService userInfoService){
        Utils.userInfoService=userInfoService;
    }

    public static Claims getClaimsForCookies() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        String token = Utils.getTokenForCookies(cookies);
        Claims claims = JWTUtils.parseJWT(token);
        return claims;
    }

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

    public static void FillCreate(BaseEntity baseEntity) {
        try {
            Claims claims = Utils.getClaimsForCookies();
            Integer currentUserId = (Integer) claims.get(KeyEnums.CLAIMS_USER_ID);
            UserInfo userInfo = userInfoService.getById(currentUserId);
            baseEntity.setCreate(userInfo.getUserId());
            baseEntity.setCreateName(userInfo.getUserName());
            baseEntity.setCreateTime(LocalDateTime.now());
            baseEntity.setIsRemove(0);
            baseEntity.setVersion(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
