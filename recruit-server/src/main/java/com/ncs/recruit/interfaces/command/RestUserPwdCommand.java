package com.ncs.recruit.interfaces.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestUserPwdCommand {

    @ApiModelProperty("用户名称")
    private String userName;
}
