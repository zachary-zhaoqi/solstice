package pers.zhaoqi.solstice.userlogin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLoginInputDTO {
    private String type;

    private String userAccount;

    private String userPassword;

    private String userEmail;

    private String userPhone;

    private String userAuthority;
}
