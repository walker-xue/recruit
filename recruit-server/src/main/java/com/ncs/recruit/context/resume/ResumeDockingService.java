package com.ncs.recruit.context.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.skunk.data.BaseService;
import com.ncs.recruit.context.resume.mapper.ResumeDockingMapper;
import com.ncs.recruit.context.resume.model.ResumeDocking;
import com.ncs.recruit.context.resume.ResumeDockingService;
import com.ncs.recruit.interfaces.command.AddInterviewResultsCommand;

@Service
public class ResumeDockingService extends BaseService<ResumeDocking> {

    @Autowired
    ResumeDockingMapper userDao;

    public void addInterviewResults(AddInterviewResultsCommand interviewResultsCommand) {

    }
}
