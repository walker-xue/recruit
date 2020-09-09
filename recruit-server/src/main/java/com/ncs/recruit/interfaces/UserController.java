package com.ncs.recruit.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.skunk.core.page.PageFilter;
import com.github.skunk.core.page.PageResult;
import com.github.skunk.web.HttpParamUtils;
import com.ncs.recruit.context.system.UserService;
import com.ncs.recruit.context.system.model.User;
import com.ncs.recruit.interfaces.command.AssignUserPermissionCommand;
import com.ncs.recruit.interfaces.command.CreateUserCommand;
import com.ncs.recruit.interfaces.command.UpdateUserPwdCommand;
import com.ncs.recruit.interfaces.core.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统用户
 *
 * @author walker
 */
@Api(tags = "系统用户")
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 用户列表
     *
     * @param requset
     * @return
     */
    @ApiOperation(value = "用户列表", notes = "用户列表，可以通过条件进行搜索用户")
    @GetMapping("/list")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderfield", paramType = "query", value = "排序字段"),
        @ApiImplicitParam(name = "ordermethod", paramType = "query", value = "排序方式"),
        @ApiImplicitParam(name = "pageNo", paramType = "query", value = "页数"),
        @ApiImplicitParam(name = "pageSize", paramType = "query", value = "页数据大小")
    })
    public PageResult<User> list(HttpServletRequest requset) {
        PageFilter pageFilter = HttpParamUtils.pageFilter(requset);
        return userService.selectPage(CurrentUserId(), pageFilter);
    }

    /**
     * 新增用户
     *
     * @param createUserCommand
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "通过本接口可以创建系统用户")
    @PostMapping("/create")
    public String create(@RequestBody CreateUserCommand createUserCommand) {
        userService.saveOrUpdate(createUserCommand);
        return SUCESS;
    }

    /**
     * 修改用户密码
     *
     * @param userPwdCommand
     * @return
     */
    @ApiOperation(value = "修改密码", notes = "修改用户登录密码")
    @PostMapping("/updatepwd")
    public String updateUserPwd(@RequestBody UpdateUserPwdCommand userPwdCommand) {
        userService.updateUserPwd(userPwdCommand);
        return SUCESS;
    }

    /**
     * 重置用户密码
     *
     * @param restUserPwdCommand
     * @return
     */
    @ApiOperation(value = "重置密码", notes = "重置用户登录密码")
    @PostMapping("/restpwd")
    public String resetUserPwd(@RequestBody RestUserPwdCommand restUserPwdCommand) {
        userService.restUserPwd(restUserPwdCommand.getUserId());
        return SUCESS;
    }

    @Setter
    @Getter
    static class RestUserPwdCommand {

        @ApiModelProperty("用户Id")
        private String userId;
    }

    /**
     * 分配用户权限
     *
     * @param userPermissionCommand
     * @return
     */
    @ApiOperation(value = "分配权限", notes = "给分配用户权限")
    @PostMapping("/assignperm")
    public String assignPermissions(@RequestBody AssignUserPermissionCommand userPermissionCommand) {
        userService.assignPermissions(userPermissionCommand);
        return SUCESS;
    }
}
