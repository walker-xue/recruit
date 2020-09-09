package com.ncs.recruit.context.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.skunk.data.utils.BasisMapper;
import com.ncs.recruit.context.system.model.Authority;

@Repository
public interface AuthorityMapper extends BasisMapper<Authority> {

    List<Authority> selectAuthorityByUserId(Long userId);

}