package com.ncs.recruit.context.resume;

import org.springframework.stereotype.Component;

import com.ncs.recruit.context.resume.model.Resume;
import com.ncs.recruit.interfaces.command.NewAddResumeCommand;

@Component
public class ResumeFactory {



    public Resume create(NewAddResumeCommand newAddResume) {


        return new Resume();
    }

}
