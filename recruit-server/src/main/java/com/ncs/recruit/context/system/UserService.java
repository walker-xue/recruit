package com.ncs.recruit.context.system;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.skunk.core.bean.SpringBeanFactory;
import com.github.skunk.core.collectors.CollectorUtils;
import com.github.skunk.core.date.DateUtils;
import com.github.skunk.core.page.ListFilter;
import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.system.mapper.AuthorityMapper;
import com.ncs.recruit.context.system.mapper.UserBusiLineMapper;
import com.ncs.recruit.context.system.mapper.UserMapper;
import com.ncs.recruit.context.system.model.User;
import com.ncs.recruit.context.system.model.UserBusiLine;
import com.ncs.recruit.interfaces.command.AssignUserPermissionCommand;
import com.ncs.recruit.interfaces.command.CreateUserCommand;
import com.ncs.recruit.interfaces.command.UpdateUserPwdCommand;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * 用户服务
 *
 * @author walker
 */
@Service
public class UserService extends BaseService<User> {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserBusiLineMapper busiLineUserMapper;
    @Autowired
    AuthorityMapper authorityMapper;

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return
     */
    public User findByUserName(@NotBlank String userName) {

        Validate.notBlank(userName);

        Weekend<User> weekend = new Weekend<>(User.class);
        WeekendCriteria<User, Object> keywordCriteria = weekend.weekendCriteria();
        keywordCriteria.andEqualTo(User::getUserName, userName);
        return mapper.selectOneByExample(weekend);
    }

    /**
     * 用户列表查询
     *
     * @param operatorId
     * @param listFilter
     * @return
     */
    public List<User> selectList(final String operatorId, ListFilter listFilter) {

        Weekend<User> weekend = new Weekend<>(User.class);
        if (CollectorUtils.isNotEmpty(listFilter.getParams())) {

        }
        if (StringUtils.isNoneBlank(listFilter.getOrderBy()) && listFilter.isOrderBy()) {
            weekend.setOrderByClause(listFilter.getOrderBy());
        }
        return mapper.selectByExample(weekend);
    }

    /**
     * 获取用户权限
     *
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        Set<String> permissions = new HashSet<>();
        permissions.add("sys:user:view");
        permissions.add("sys:user:add");
        permissions.add("sys:user:edit");
        permissions.add("sys:user:delete");
        return permissions;
    }

    /**
     * 创建用户
     *
     * @param createUserCommand
     */
    public void saveOrUpdate(CreateUserCommand createUserCommand) {

        User user = SpringBeanFactory.bean(UserFactory.class).create(createUserCommand);

        user.setGmtCreate(DateUtils.nowDate());
        user.setGmtModified(DateUtils.nowDate());

        List<UserBusiLine> busiLines = user.getBusiLines();

        busiLineUserMapper.insertList(busiLines);
        insertSelective(user);
    }

    /**
     * 更新用户密码
     *
     * @param userPwdCommand
     */
    public void updateUserPwd(UpdateUserPwdCommand userPwdCommand) {
        User user = selectByKey(userPwdCommand.getUserId());
        user.updateUserPwd(userPwdCommand.getOldPwd(), userPwdCommand.getNewPwd());
        updateByKeySelective(user);
    }

    /**
     * 用户权限分配
     *
     * @param userPermissionCommand
     */
    public void assignPermissions(AssignUserPermissionCommand userPermissionCommand) {

    }

    /**
     * 重置用户密码
     *
     * @param userId
     */
    public void restUserPwd(@NotBlank String userId) {
        User user = selectByKey(userId);
        user.rserUserPwd();
        updateByKeySelective(user);
    }
}
