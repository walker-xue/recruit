package com.ncs.recruit.interfaces.command;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PublishJobDemandCommand {

    @ApiModelProperty("部门编号")
    private String department;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("业务线")
    private String busiLine;

    @ApiModelProperty("到岗时间")
    private Date arrivalTime;

    @ApiModelProperty("项目介绍")
    private String projectDescription;

    @ApiModelProperty("岗位详情")
    private List<StationDetail> stations;

    @Getter
    @Setter
    class StationDetail {

        @ApiModelProperty("需求岗位")
        private String station;

        @ApiModelProperty("需求人数")
        private Integer needCount;

        @ApiModelProperty("技术水平")
        private String techLevel;

        @ApiModelProperty("岗位要求")
        private String stationRequire;

    }

}
