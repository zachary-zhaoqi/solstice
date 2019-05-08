package pers.zhaoqi.solstice.userlogin.check;

import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.zhaoqi.solstice.common.enums.ConstantMessage;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;
import pers.zhaoqi.solstice.userlogin.jwt.JWTUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CheckLoginAspect {

    @Pointcut("within(pers.zhaoqi.solstice.*.controller..*)&&!within(pers.zhaoqi.solstice.userlogin.controller..*)")
    public void checkLogin() {
    }

    @Around("checkLogin()")
    public Object check(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        String token = Utils.getTokenForCookies(cookies);

        try {
            Claims claims = JWTUtils.parseJWT(token);
        } catch (Exception e) {
            return Result.failed(ConstantMessage.LOGIN_ERROR, e.getMessage());
        }
        return joinPoint.proceed();
    }


}
