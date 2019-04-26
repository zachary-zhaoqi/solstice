package pers.zhaoqi.solstice.userlogin.jwt;

import io.jsonwebtoken.Claims;
import org.junit.Test;

import static org.junit.Assert.*;

public class JWTUntilTest {

    @Test
    public void createJWT() {
    }

    @Test
    public void parseJWT() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9." +
                "eyJleHAiOjE1NTU4NTI2MjMsInVzZXIiOnsiaWQiOjEsInVzZXJBY2NvdW50Ijoicm9vdCIsInVzZXJFbWFpbCI6IjEyMzQ1NkBlbWFpbC5jb20iLCJ1c2VyUG" +
                "hvbmUiOiIxMzYwMTAyMDMwNCIsIanVzZXJBdXRob3JpdHkiOiJhZG1pbi0wMSIsInVzZXJOYW1lIjpudWxsLCJ1c2VyU2V4Ijpud" +
                "WxsLCJ1c2VyQmlydGhkYXkiOm51bGwsInVzZXJDaGF0SGVhZCI6bnVsbH0sImlhdCI6MTU1NTQ5MjYyMywianRpIjoiMSJ9" +
                ".V4iiSlzM41K5lC58sNWIdj7qPaBsc1Hmiff1yvBhSds";

        try {
            Claims claims = JWTUntil.parseJWT(jwt);
            System.out.println("aaa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}