package com.ncs.recruit.context.demand;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.skunk.core.bean.SpringBeanFactory;
import com.github.skunk.core.page.PageFilter;
import com.github.skunk.core.page.PageResult;
import com.github.skunk.core.utils.BeanConvertUtils;
import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.demand.dto.DemandDetailDto;
import com.ncs.recruit.context.demand.mapper.JobDemandMapper;
import com.ncs.recruit.context.demand.model.JobDemand;
import com.ncs.recruit.interfaces.command.PublishJobDemandCommand;

/**
 * 招聘需求
 */
@Service
public class JobDemandService extends BaseService<JobDemand> {

    @Autowired
    JobDemandMapper jobDemandMapper;

    /**
     * 发布需求
     *
     * @param publishJobDemand
     */
    public void publishJobDemandPublish(PublishJobDemandCommand publishJobDemand) {

        JobDemand jobDemand = SpringBeanFactory.bean(JobDemandFactory.class).create(publishJobDemand);

        jobDemandMapper.insert(jobDemand);
    }

    /**
     * 获取需求详情
     *
     * @param demandId
     * @return
     */
    public DemandDetailDto demandDetail(@NotBlank String demandId) {

        JobDemand jobDemand = selectByKey(demandId);
        DemandDetailDto detailDto = new DemandDetailDto();
        return detailDto;
    }

    /**
     * 获取需求的简历，并且以分页的形式返回
     *
     * @param currentUserId
     *     　当前操作者
     * @param pageFilter
     *     　分页参数
     * @return
     */
    public PageResult<JobDemand> demandDetailOfResumes(String currentUserId, PageFilter pageFilter) {

        JobDemand demandDetail = BeanConvertUtils.mapToObject(pageFilter.getParams(), JobDemand.class);

        PageHelper.startPage(pageFilter.getPageNo(), pageFilter.getPageSize(), pageFilter.getOrderBy());

        PageInfo<JobDemand> tPageInfo = new PageInfo<>(selectList(currentUserId, pageFilter.listFilter()));
        return new PageResult(tPageInfo.getTotal(), tPageInfo.getList());

    }
}
