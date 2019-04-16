package pers.zhaoqi.solstice.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInputDTO {
    private String userAccount;

    private String userPassword;

    private String userEmail;

    private String userPhone;

    private String userAuthority;
}
