<template>
  <div>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">需求详情</div>
        </div>
        <div class="con">
          <div class="con-use">
            <div class="con-use-view">
              <el-row>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">需求编号：</p>
                    <p>韩明</p>
                  </div>
                </el-col>
                <el-col :span="16">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">交付经理：</p>
                    <p>2016-08-17</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">项目名称：</p>
                    <p>胡兆鹏</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">业务线：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">到岗时间：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">岗位：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">级别：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">需求书：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">岗位：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">级别：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="8">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">需求书：</p>
                    <p>录入</p>
                  </div>
                </el-col>
                <el-col :span="24">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">项目介绍：</p>
                    <p class="con-use-view-col-txt">
                      阿里妈妈MUX倾力打造的矢量图标管理、交流平台。设计师将图标上传到Iconfont平台，用户可以自定义下载多种格式的icon，
                      平台也可将图标转换为字体，便于前端工程师自由调整与调用。
                    </p>
                  </div>
                </el-col>
                <el-col :span="24">
                  <div class="con-use-view-col">
                    <p class="con-use-view-col-title">岗位JD：</p>
                    <p class="con-use-view-col-txt">
                      阿里妈妈MUX倾力打造的矢量图标管理、交流平台。设计师将图标上传到Iconfont平台，用户可以自定义下载多种格式的icon，
                      平台也可将图标转换为字体，便于前端工程师自由调整与调用。
                    </p>
                  </div>
                </el-col>
              </el-row>
            </div>
          </div>
        </div>

        <!-- 表格 -->
        <div class="main-table">
          <SirTable
            :table-cols="tableColsOne"
            :table-data="tableDataOne"
            :pag-ination="paginationOne"
            class="table-wrap"
            @refresh="refreshOne"
          >
            <!-- 状态 -->
            <template slot="code" slot-scope="scope">
              <span class="main-table-resumeNo">{{scope.row.code}}</span>
            </template>
            <!-- 状态 -->
            <template slot="post" slot-scope="scope">
              <span class="main-table-resumeNo">{{scope.row.post}}</span>
            </template>
            <!-- 状态 -->
            <template slot="type" slot-scope="scope">
              <span class="main-table-resumeNo">{{scope.row.type}}</span>
            </template>
          </SirTable>
        </div>
        <!-- 表格 -->
        <div class="main-table">
          <SirTable
            :table-cols="tableCols"
            :table-data="tableData"
            :pag-ination="pagination"
            :isIndex="isIndex"
            class="table-wrap"
            @refresh="refresh"
          >
            <!-- 按钮 -->
            <template slot="operation" slot-scope="scope">
              <span class="main-table-btn" @click="handleSee(scope.row)">
                <i class="iconfont"></i>操作
              </span>
            </template>
          </SirTable>
        </div>
      </div>
    </el-scrollbar>
  </div>
</template>

<script type="text/ecmascript-6">
import { Page } from "@/utils/commonDataModel";

export default {
  data() {
    return {
      isIndex: true,
      form: {
        name: "", // 姓名
        sex: "", // 性别
        phone: "", // 手机号
        post: "", // 岗位
        years: "", // 工作年限
        salary: "", // 薪资要求
        resumeNo: "", // 简历编号
        currentWorkPlace: "", // 当前工作地
        expectantly: "", // 期望工作地
        resumeStatus: "", // 简历状态
        enteredBy: "", // 简历录入人
        evaluate: "", // 简历使用者
      },

      // 表格相关
      tableDataOne: [
        {
          code: "20200824",
          name: "邓斌",
          post: "java",
          level: "高级",
          project: "芝麻信用",
          business: "企业服务",
          type: "待入职",
          user: "胡兆鹏",
        },
        {
          code: "20200824",
          name: "邓斌",
          post: "java",
          level: "高级",
          project: "芝麻信用",
          business: "企业服务",
          type: "待入职",
          user: "胡兆鹏",
        },
        {
          code: "20200824",
          name: "邓斌",
          post: "java",
          level: "高级",
          project: "芝麻信用",
          business: "企业服务",
          type: "待入职",
          user: "胡兆鹏",
        },
        {
          code: "20200824",
          name: "邓斌",
          post: "java",
          level: "高级",
          project: "芝麻信用",
          business: "企业服务",
          type: "待入职",
          user: "胡兆鹏",
        },
        {
          code: "20200824",
          name: "邓斌",
          post: "java",
          level: "高级",
          project: "芝麻信用",
          business: "企业服务",
          type: "待入职",
          user: "胡兆鹏",
        },
      ],
      // 表格分页
      paginationOne: new Page(),
      // 表头配置
      tableColsOne: [
        {
          label: "简历编号",
          slot: "code",
        },
        {
          label: "姓名",
          prop: "name",
        },
        {
          label: "岗位",
          slot: "post",
        },
        {
          label: "级别",
          prop: "level",
        },
        {
          label: "项目",
          prop: "project",
        },
        {
          label: "业务线",
          prop: "business",
        },
        {
          label: "状态",
          slot: "type",
        },
        {
          label: "简历使用人",
          prop: "user",
        },
      ],

      // 流程信息表格相关
      // 表格内容
      tableData: [
        {
          time: "2016年8月8日 17:18:17",
          enteredBy: "胡兆鹏",
          remarks: "备注",
        },
      ],
      // 表格分页
      pagination: new Page(),
      // 表头配置
      tableCols: [
        {
          label: "时间",
          prop: "time",
        },
        {
          label: "录入人",
          prop: "enteredBy",
        },
        {
          label: "备注",
          prop: "remarks",
        },
        {
          label: "操作",
          slot: "operation",
        },
      ],
    };
  },
  created() {
    console.log(this.$route.params);
    //   Object.assign(this.form,this.$route.params.odata)
  },
  methods: {
    getList(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.form);
        } else {
          this.$message.error("请填写必填项");
          return false;
        }
      });
    },

    // 导出
    submitForm(formName) {
      this.$message({
        type: "success",
        message: "导出成功",
      });
    },
    // 返回关闭
    clearClick() {
      this.$router.push({
        name: "ResumeDatabase",
      });
    },

    // 分配
    handleSee(row) {
      console.log("详情", row);
    },

    refreshOne(val) {
      this.paginationOne.pageNo = val.pageNo;
      this.paginationOne.pageSize = val.pageSize;
    },
    // 分页
    refresh(val) {
      this.pagination.pageNo = val.pageNo;
      this.pagination.pageSize = val.pageSize;
      // 执行查询列表
      // this.getList(this.form);
    },
  },
};
</script>

<style scoped lang='less'>
.main {
  width: calc(100% - 20px);
  margin: 0 auto;
  .header {
    height: 41px;
    line-height: 41px;
    margin-bottom: 10px;
    border-bottom: 3px solid #d4d4d4;
    .header-title {
      padding-left: 25px;
      font-size: 16px;
      font-weight: bold;
      color: #333;
      background: url("~@/assets/image/f_i6.gif") no-repeat center left;
    }
  }
  .con {
    width: 100%;
    .con-use {
      width: 100%;
      .con-use-view {
        width: 100%;
        height: auto;
        margin-top: 5px;
        border: 1px solid #d4d4d4;
        padding-top: 20px;
        .con-use-view-col {
          display: flex;
          margin-bottom: 20px;
          p {
            font-size: 14px;
          }
          .con-use-view-col-txt {
            flex: 1;
          }
          .con-use-view-col-title {
            width: 120px;
            text-align: right;
          }
        }
      }
    }
  }
  .main-table {
    width: 100%;
    box-shadow: 0 0 0 1px #d4d4d4, 0 0 0 5px #fff;
    padding: 2px;
    margin-top: 10px;
    margin-bottom: 60px;
    .main-table-resumeNo {
      color: #677e99;
      cursor: pointer;
    }
    .process-wrap {
      display: flex;
      justify-content: space-around;
      .process-item {
        text-align: center;
        p {
          margin: 0 auto;
        }
      }
    }
    .main-table-btn {
      color: #d61a21;
      cursor: pointer;
    }
  }
}
/deep/.el-scrollbar__wrap {
  height: calc(100vh - 162px);
}
</style>
