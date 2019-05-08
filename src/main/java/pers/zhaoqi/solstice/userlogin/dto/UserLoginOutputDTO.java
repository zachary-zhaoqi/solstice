package pers.zhaoqi.solstice.userlogin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserLoginOutputDTO {

    private Integer id;

    private String userAccount;

    private String userEmail;

    private String userPhone;

    private String userAuthority;

    private String userName;

    private String userSex;

    private LocalDateTime userBirthday;

    private String userChatHead;

    private String type;

    private String jwt;

    private Long jwtExpires;
}