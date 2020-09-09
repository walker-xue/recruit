package com.ncs.recruit.context.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.skunk.data.utils.BasisMapper;
import com.ncs.recruit.context.system.model.User;

@Repository
public interface UserMapper extends BasisMapper<User> {

    List<User> queryUserByUser(User user);

}