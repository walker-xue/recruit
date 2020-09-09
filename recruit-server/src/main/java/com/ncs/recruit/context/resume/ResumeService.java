package com.ncs.recruit.context.resume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.skunk.core.bean.SpringBeanFactory;
import com.github.skunk.core.page.ListFilter;
import com.github.skunk.core.page.PageFilter;
import com.github.skunk.core.page.PageResult;
import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.resume.dto.CandidatesDto;
import com.ncs.recruit.context.resume.mapper.ResumeDetailMapper;
import com.ncs.recruit.context.resume.mapper.ResumeMapper;
import com.ncs.recruit.context.resume.model.Resume;
import com.ncs.recruit.interfaces.command.NewAddResumeCommand;

@Service
public class ResumeService extends BaseService<Resume> {

    @Autowired
    ResumeMapper resumeMapper;
    @Autowired
    ResumeDetailMapper resumeDetailMapper;

    /**
     * @param operatorId
     * @param pageFilter
     * @return
     */
    public PageResult<CandidatesDto> selectCandidatesPage(String operatorId, PageFilter pageFilter) {
        PageHelper.startPage(pageFilter.getPageNo(), pageFilter.getPageSize(), pageFilter.getOrderBy());
        PageInfo<CandidatesDto> tPageInfo = new PageInfo<>(selectCandidates(operatorId, pageFilter.listFilter()));
        return new PageResult(tPageInfo.getTotal(), tPageInfo.getList());
    }

    /**
     * @param createUserCommand
     */
    public void addAddResume(NewAddResumeCommand createUserCommand) {
        Resume resume = SpringBeanFactory.bean(ResumeFactory.class).create(createUserCommand);
        insertSelective(resume);
    }

    private List<CandidatesDto> selectCandidates(String operatorId, ListFilter listFilter) {
        List<CandidatesDto> dictionaries = sqlMapper.selectList(" select * from resume ", CandidatesDto.class);
        return dictionaries;
    }
}
