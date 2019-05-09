package pers.zhaoqi.solstice.userlogin.check;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;

@Aspect
@Component
public class CheckLoginAspect {

    @Pointcut("within(pers.zhaoqi.solstice.*.controller..*)&&!within(pers.zhaoqi.solstice.userlogin.controller..*)")
    public void checkLogin() {
    }

    @Around("checkLogin()")
    public Object check(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            Utils.getClaimsForCookies();
        } catch (Exception e) {
            return Result.failed(ResultCodeAndMessage.LOGIN_ERROR, e.getMessage());
        }
        return joinPoint.proceed();
    }




}
