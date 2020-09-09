package com.ncs.recruit.context.demand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.system.mapper.UserMapper;
import com.ncs.recruit.context.demand.model.DemandDetail;

@Service
public class DemandDetailService extends BaseService<DemandDetail> {

    @Autowired
    UserMapper userDao;

}
