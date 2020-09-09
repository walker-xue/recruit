
package com.ncs.recruit.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.skunk.core.page.PageResult;
import com.github.skunk.web.HttpParamUtils;
import com.ncs.recruit.context.demand.DemandDetailService;
import com.ncs.recruit.context.demand.model.DemandDetail;
import com.ncs.recruit.context.resume.ResumeDockingService;
import com.ncs.recruit.interfaces.command.AddInterviewResultsCommand;
import com.ncs.recruit.interfaces.core.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 业务需求
 *
 * @author walker
 */
@Slf4j
@Api(tags = "应聘与面试")
@RestController
@RequestMapping("/api/jobdocking")
public class JobDockingController extends BaseController {

    @Autowired
    ResumeDockingService resumeDockingService;
    @Autowired
    DemandDetailService demandService;

    /**
     * 发布招聘需求
     *
     * @param interviewResultsCommand
     * @return
     */
    @ApiOperation(value = "提交面试结果", notes = "提交应聘人员的面试结果信息")
    @PostMapping("/interview")
    public String interviewResult(@Validated @RequestBody AddInterviewResultsCommand interviewResultsCommand) {
        resumeDockingService.addInterviewResults(interviewResultsCommand);
        return SUCESS;
    }

    /**
     * 需求对接列表
     *
     * @param request
     * @return
     */
    @GetMapping("/candidate/list")
    @ApiOperation(value = "应聘人员列表", notes = "项目需求需求应聘人员列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderfield", paramType = "query", value = "排序字段"),
        @ApiImplicitParam(name = "ordermethod", paramType = "query", value = "排序方式"),
        @ApiImplicitParam(name = "pageNo", paramType = "query", value = "页数"),
        @ApiImplicitParam(name = "pageSize", paramType = "query", value = "页数据大小")
    })
    public PageResult<DemandDetail> list(HttpServletRequest request) {
        return demandService.selectPage(CurrentUserId(), HttpParamUtils.pageFilter(request));
    }
}
