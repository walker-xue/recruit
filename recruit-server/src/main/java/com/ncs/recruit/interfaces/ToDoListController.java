package com.ncs.recruit.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.skunk.core.page.PageFilter;
import com.github.skunk.core.page.PageResult;
import com.github.skunk.web.HttpParamUtils;
import com.ncs.recruit.context.todo.ToDoListService;
import com.ncs.recruit.context.todo.model.ToDoList;
import com.ncs.recruit.interfaces.core.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 待处理事项表
 *
 * @author walker
 */
@Api(tags = "待处理事项")
@RestController
@RequestMapping("/api/todolist")
public class ToDoListController extends BaseController {

    @Autowired
    ToDoListService toDoListService;

    /**
     * 待处理事项列表
     *
     * @param requset
     * @return
     */
    @ApiOperation(value = "待处理事项列表", notes = "待处理事项列表")
    @GetMapping("/list")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderfield", paramType = "query", value = "排序字段"),
        @ApiImplicitParam(name = "ordermethod", paramType = "query", value = "排序方式"),
        @ApiImplicitParam(name = "pageNo", paramType = "query", value = "页数"),
        @ApiImplicitParam(name = "pageSize", paramType = "query", value = "页数据大小"),
    })
    public PageResult<ToDoList> list(HttpServletRequest requset) {
        PageFilter pageFilter = HttpParamUtils.pageFilter(requset);
        return toDoListService.selectPage(CurrentUserId(), pageFilter);
    }

}
