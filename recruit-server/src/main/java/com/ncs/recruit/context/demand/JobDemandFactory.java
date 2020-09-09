package com.ncs.recruit.context.demand;

import org.springframework.stereotype.Component;

import com.ncs.recruit.context.demand.model.JobDemand;
import com.ncs.recruit.interfaces.command.PublishJobDemandCommand;

@Component
public class JobDemandFactory {

    public JobDemand create(PublishJobDemandCommand publishJobDemand) {
        return new JobDemand();
    }

}
