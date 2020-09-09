package com.ncs.recruit.interfaces.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddInterviewResultsCommand {

    private String resumeId;

    private String demandDetailId;

    private String demandId;

    private Integer resumeState;

    private String isPass;

    private String information;

    private String expectationSalary;

    private String remark;

}
