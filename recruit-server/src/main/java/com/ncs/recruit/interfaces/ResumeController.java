package com.ncs.recruit.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.skunk.core.page.PageResult;
import com.github.skunk.web.HttpParamUtils;
import com.ncs.recruit.context.resume.ResumeService;
import com.ncs.recruit.context.resume.model.Resume;
import com.ncs.recruit.infrastructure.utils.resumeparase.ResumeParaseRule;
import com.ncs.recruit.interfaces.command.NewAddResumeCommand;
import com.ncs.recruit.interfaces.core.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 应聘者的简历
 *
 * @author walker
 */
@Api(tags = "简历库")
@RestController
@RequestMapping("/api/resume")
public class ResumeController extends BaseController {

    @Autowired
    ResumeService resumeService;

    /**
     * 简历库列表
     *
     * @param request
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "简历库列表", notes = "简历库查询列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderfield", paramType = "query", value = "排序字段"),
        @ApiImplicitParam(name = "ordermethod", paramType = "query", value = "排序方式"),
        @ApiImplicitParam(name = "pageNo", paramType = "query", value = "页数"),
        @ApiImplicitParam(name = "pageSize", paramType = "query", value = "页数据大小"),
    })
    public PageResult<Resume> list(HttpServletRequest request) {
        return resumeService.selectPage(CurrentUserId(), HttpParamUtils.pageFilter(request));
    }

    /**
     * 简历详情
     *
     * @param resumeId
     * @return
     */
    @GetMapping("/details")
    @ApiOperation(value = "简历详情", notes = "应聘者的简历包含简历使用情况、简历详情、简历状态等信息")
    public Resume details(@ApiParam(name = "简历Id") @RequestParam String resumeId) {
        return resumeService.selectByKey(resumeId);
    }

    /**
     * 解析简历
     *
     * @param filepath
     * @return
     */
    @GetMapping("/parase")
    @ApiOperation(value = "解析简历", notes = "invokePost说明")
    public Resume paraseResume(@ApiParam(name = "简历路径") @RequestParam String filepath) {

        ResumeParaseRule resumeParaseRule = new ResumeParaseRule();
        return resumeParaseRule.rusmeParase4BaseField(filepath);
    }

    /**
     * 预览简历
     *
     * @param request
     * @param resp
     * @throws Exception
     */
    @GetMapping("/readOnLine")
    @ApiOperation(value = "在线预览", notes = "在线预览简历")
    public void readOnLine(HttpServletRequest request, HttpServletResponse resp) throws Exception {
        return;
    }

    /**
     * 新增简历
     *
     * @param createUserCommand
     * @return
     */
    @PostMapping("/newadd")
    @ApiOperation(value = "新增简历", notes = "新增简历")
    public String newAdd(@Valid @RequestBody NewAddResumeCommand createUserCommand) {
        resumeService.addAddResume(createUserCommand);
        return SUCESS;
    }

    /**
     * 上传简历
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation(value = "上传简历", notes = "上传应聘者的简历")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        InputStream inputStream = file.getInputStream();
        IOUtils.copy(inputStream, new FileOutputStream(new File("")));
        return SUCESS;
    }

    /**
     * 简历文件下载
     *
     * @param filename·
     * @return
     * @throws IOException
     */
    @GetMapping("/download")
    @ApiOperation(value = "下载简历", notes = "下载应聘者的简历")
    public void download(String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType(request.getSession().getServletContext().getMimeType(filename));
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        String fullFileName = "/uploadResume/";

        try (InputStream in = new FileInputStream(fullFileName); OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[in.available()];
            int b = 0;
            while ((b = in.read(buffer)) != -1) {
                out.write(buffer, 0, b);
            }
        }
    }
}
