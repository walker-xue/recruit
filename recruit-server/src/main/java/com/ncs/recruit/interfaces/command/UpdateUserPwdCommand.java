package com.ncs.recruit.interfaces.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserPwdCommand {

    @ApiModelProperty("用户Id")
    private String userId;

    @ApiModelProperty("原始密码")
    private String oldPwd;

    @ApiModelProperty("新密码")
    private String newPwd;
}
