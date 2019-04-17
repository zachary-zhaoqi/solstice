package pers.zhaoqi.solstice.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserOutputDTO {

    private Integer id;

    private String userAccount;

    private String userEmail;

    private String userPhone;

    private String userAuthority;

    private String userName;

    private String userSex;

    private LocalDateTime userBirthday;

    private String userChatHead;
}
