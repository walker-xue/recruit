
package com.ncs.recruit.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.skunk.core.bean.SpringBeanFactory;
import com.github.skunk.core.page.PageResult;
import com.github.skunk.web.HttpParamUtils;
import com.ncs.recruit.context.demand.DemandDetailService;
import com.ncs.recruit.context.demand.JobDemandService;
import com.ncs.recruit.context.demand.dto.DemandDetailDto;
import com.ncs.recruit.context.demand.model.DemandDetail;
import com.ncs.recruit.context.demand.model.JobDemand;
import com.ncs.recruit.interfaces.command.PublishJobDemandCommand;
import com.ncs.recruit.interfaces.core.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * 业务需求
 *
 * @author walker
 */
@Slf4j
@Api(tags = "业务需求")
@RestController
@RequestMapping("/api/demand")
public class JobDemandController extends BaseController {

    @Autowired
    DemandDetailService demandService;
    @Autowired
    JobDemandService jobDemandService;

    /**
     * 发布招聘需求
     *
     * @param publishJobDemand
     * @return
     */
    @ApiOperation(value = "发布招聘需求", notes = "发布招聘需求")
    @PostMapping("/publish/jobdemand")
    public String list(@RequestBody PublishJobDemandCommand publishJobDemand) {
        jobDemandService.publishJobDemandPublish(publishJobDemand);
        return SUCESS;
    }

    /**
     * 需求库查询列表
     *
     * @param request
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "需求库列表", notes = "需求库查询列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderfield", paramType = "query", value = "排序字段"),
        @ApiImplicitParam(name = "ordermethod", paramType = "query", value = "排序方式"),
        @ApiImplicitParam(name = "pageNo", paramType = "query", value = "页数"),
        @ApiImplicitParam(name = "pageSize", paramType = "query", value = "页数据大小")
    })
    public PageResult<DemandDetail> list(HttpServletRequest request) {

        log.info(SpringBeanFactory.bean(JdbcTemplate.class).toString());

        return demandService.selectPage(CurrentUserId(), HttpParamUtils.pageFilter(request));
    }

    /**
     * 需求详情
     *
     * @param demandId
     * @return
     */
    @GetMapping("/details")
    @ApiOperation(value = "需求详情", notes = "通过需求Id可以查看需求详情信息")
    public DemandDetailDto demandDetail(@ApiParam(value = "demandId") @RequestParam String demandId) {
        return jobDemandService.demandDetail(demandId);
    }

    /**
     * 需求关联的简历
     *
     * @param request
     * @return
     */
    @GetMapping("/details/resumes")
    @ApiOperation(value = "需求关联的简历", notes = "通过demandId查询需求详情中的简历，并且以分页的形式返回")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderfield", paramType = "query", value = "排序字段"),
        @ApiImplicitParam(name = "ordermethod", paramType = "query", value = "排序方式"),
        @ApiImplicitParam(name = "pageNo", paramType = "query", value = "页数"),
        @ApiImplicitParam(name = "pageSize", paramType = "query", value = "页数据大小"),
        @ApiImplicitParam(name = "demandId", paramType = "query", value = "需求Id", required = true)
    })
    public PageResult<JobDemand> demandDetailOfResumes(HttpServletRequest request) {
        return jobDemandService.demandDetailOfResumes(CurrentUserId(), HttpParamUtils.pageFilter(request));
    }

    /**
     * 业务需求汇总
     *
     * @param request
     * @return
     */
    @GetMapping("/summary")
    @ApiOperation(value = "业务需求汇总", notes = "业务需求汇总列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderfield", paramType = "query", value = "排序字段"),
        @ApiImplicitParam(name = "ordermethod", paramType = "query", value = "排序方式"),
        @ApiImplicitParam(name = "pageNo", paramType = "query", value = "页数"),
        @ApiImplicitParam(name = "pageSize", paramType = "query", value = "页数据大小")
    })
    public PageResult<DemandDetail> summary(HttpServletRequest request) {
        return demandService.selectPage(CurrentUserId(), HttpParamUtils.pageFilter(request));
    }

}
