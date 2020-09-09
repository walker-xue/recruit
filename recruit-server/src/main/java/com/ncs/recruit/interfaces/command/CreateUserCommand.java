package com.ncs.recruit.interfaces.command;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Api("创建用户")
public class CreateUserCommand {

    @NotBlank
    @ApiModelProperty("工号")
    private String workNum;

    @NotBlank
    @ApiModelProperty("用户名")
    private String userName;

    @NotBlank
    @ApiModelProperty("姓名")
    private String name;

    @NotBlank
    @ApiModelProperty("手机号")
    private String phoneNum;

    @NotBlank
    @ApiModelProperty("邮箱")
    private String email;

    @NotBlank
    @ApiModelProperty("部门")
    private String department;

    @NotBlank
    @ApiModelProperty("岗位")
    private String position;

    @ApiModelProperty("直接领导")
    private String directLeader;

    @ApiModelProperty("业务线，多个使用逗号")
    private String busiLiner;

    @ApiModelProperty("备注")
    private String remark;

}
