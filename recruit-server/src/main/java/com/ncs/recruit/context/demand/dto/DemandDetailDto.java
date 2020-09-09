package com.ncs.recruit.context.demand.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandDetailDto {

    private String jobDemandId;
    private String demandNum;
    private String department;
    private String projectName;
    private String projectNum;
    private String busiLine;
    private String isDeleted;
    private String remark;

}
