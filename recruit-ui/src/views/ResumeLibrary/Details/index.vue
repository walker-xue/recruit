<template>
  <div>
    <Information></Information>
    <el-scrollbar class="main-scrollbar">
    <div class="main">
      <div class="header">
        <div class="header-title">简历详情页面</div>
      </div>
      <div class="con">
        <div class="con-use">
          <div class="con-use-title">
            <div class="con-use-title-txt">使用情况</div>
            <div class="con-use-operation">
              <div class="con-use-operation-btn">关联需求</div>
              <div class="con-use-operation-btn">查看附件</div>
            </div>
          </div>
          <div class="con-use-view">
            <el-row>
              <el-col :span="12">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">录入人：</p>
                  <p>韩明</p>
                </div>
              </el-col>
              <el-col :span="12">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">时间：</p>
                  <p>2016-08-17</p>
                </div>
              </el-col>
              <el-col :span="12">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">简历使用者：</p>
                  <p>胡兆鹏</p>
                </div>
              </el-col>
              <el-col :span="12">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">简历状态：</p>
                  <p>录入</p>
                </div>
              </el-col>
            </el-row>
          </div>
        </div>
        <div class="con-use">
          <div class="con-use-title">
            <div class="con-use-title-txt">简历详情</div>
          </div>
          <div class="con-use-view">
            <div class="con-use-view-punctuation">基本信息</div>
            <el-row>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">姓名：</p>
                  <p>韩明</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">性别：</p>
                  <p>2016-08-17</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">手机号：</p>
                  <p>胡兆鹏</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">邮箱：</p>
                  <p>录入</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">出生日期：</p>
                  <p>录入</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">籍贯：</p>
                  <p>录入</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">居住地：</p>
                  <p>录入</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">期望地：</p>
                  <p>录入</p>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">工作年限：</p>
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
                  <p class="con-use-view-col-title">身份证号：</p>
                  <p>录入</p>
                </div>
              </el-col>
              <el-col :span="24">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">自我评价：</p>
                  <p>录入</p>
                </div>
              </el-col>
              <el-col :span="24">
                <div class="con-use-view-col">
                  <p class="con-use-view-col-title">其他信息：</p>
                  <p>录入</p>
                </div>
              </el-col>
            </el-row>
          </div>
        </div>
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
          @checkbox-data="checkBoxData"
        >
          <!-- 按钮 -->
          <template slot="operation" slot-scope="scope">
            <span class="main-table-btn" @click="handleSee(scope.row)">
              <i class="iconfont"></i>操作
            </span>
          </template>
        </SirTable>
      </div>

      <!--操作-->
      <div class="operation-wrap">
        <div class="operation-btn" @click="submitForm('ruleForm')">导出</div>
        <div class="operation-btn" @click="clearClick()">返回</div>
      </div>
    </div>
    </el-scrollbar>
  </div>
</template>

<script type="text/ecmascript-6">
import Information from "@/components/Information/index.vue";
import { Page } from "@/utils/commonDataModel";

export default {
  components: {
    Information,
  },
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
      console.log(this.$route.params)
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
              type: 'success',
              message: '导出成功'
      })
    },
    // 返回关闭
    clearClick() {
      this.$router.push({
        name:'ResumeLibrary'
      })
    },

    // 分配
    handleSee(row) {
      console.log("详情", row);
    },
    // 分页多选操作
    checkBoxData(val) {
      console.log(val);
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
      .con-use-title {
        display: flex;
        justify-content: space-between;
        .con-use-title-txt {
          font-size: 14px;
          font-weight: bold;
          color: #666666;
        }
        .con-use-operation {
          .con-use-operation-btn {
            width: 85px;
            height: 24px;
            line-height: 24px;
            background: #d61a21;
            font-size: 14px;
            text-align: center;
            color: #fff;
            cursor: pointer;
            float: left;
            margin-right: 10px;
          }
        }
      }
      .con-use-view {
        width: 100%;
        height: auto;
        margin-top: 5px;
        border: 1px solid #d4d4d4;
        padding-top: 20px;
        .con-use-view-punctuation {
          position: relative;
          color: #6b7086;
          font-size: 14px;
          font-weight: bold;
          padding-bottom: 20px;
          padding-left: 15px;
          &::before {
            position: absolute;
            content: "";
            width: calc(100% - 100px);
            height: 1px;
            background: #d4d4d4;
            top: 9px;
            right: 20px;
          }
        }
        .con-use-view-col {
          display: flex;
          margin-bottom: 20px;
          p {
            font-size: 14px;
          }
          .con-use-view-col-title {
            width: 140px;
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
  /*操作*/
  .operation-wrap {
    width: 100%;
    margin-top: 80px;
    height: 42px;
    .operation-btn {
      width: 85px;
      height: 24px;
      line-height: 24px;
      background: #d61a21;
      font-size: 14px;
      text-align: center;
      color: #fff;
      float: left;
      cursor: pointer;
      margin-right: 10px;
    }
  }
}
</style>
