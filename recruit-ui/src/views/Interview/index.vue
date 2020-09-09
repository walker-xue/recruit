<template>
  <div>
    <Information></Information>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">面试信息</div>
        </div>
        <div class="con">
          <div class="stage-wrap">
            <div class="stage-title">面试进度</div>
            <div class="stage-tag">
              <div class="stage-tag-box conduct">进行中</div>
              <div class="stage-tag-box adopt">已通过</div>
              <div class="stage-tag-box fail">未通过</div>
            </div>
          </div>
          <div class="stage">
            <div class="stage-type">
              <div class="stage-type-box stage-type-box-adopt">录入</div>
              <div class="stage-type-box stage-type-box-adopt">初面</div>
              <div class="stage-type-box stage-type-box-conduct">技术面</div>
              <div class="stage-type-box">offer</div>
              <div class="stage-type-box">待入职</div>
              <div class="stage-type-box">已入职</div>
            </div>
            <div></div>
          </div>
          <component :is="comName"></component>
        </div>

        <div class="table-title">流程信息</div>
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
      </div>
    </el-scrollbar>
  </div>
</template>

<script type="text/ecmascript-6">
import Information from "@/components/Information/index.vue";
import EntryStage from "./components/entryState.vue";
import InterviewStage from "./components/interviewState.vue";
import OfferState from "./components/offerState.vue";

import { Page } from "@/utils/commonDataModel";

export default {
  components: {
    Information,
    EntryStage, // 入职阶段
    InterviewStage, // 面试阶段
    OfferState, // offer阶段
  },
  data() {
    return {
      comName: 'EntryStage',
      // 是否开启表格序号
      isIndex: true,
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
    margin-top: 20px;
    .stage-wrap {
      margin-bottom: 10px;
      display: flex;
      .stage-title {
        font-size: 14px;
        font-weight: bold;
        color: #666666;
      }
      .stage-tag {
        display: flex;
        margin-left: 20px;
        .stage-tag-box {
          position: relative;
          width: 80px;
          font-size: 14px;
          color: #666666;
          text-indent: 16px;
          &.conduct::before {
            position: absolute;
            content: "";
            left: 0;
            top: 5px;
            width: 10px;
            height: 10px;
            background: #ec6a41;
          }
          &.adopt::before {
            position: absolute;
            content: "";
            left: 0;
            top: 5px;
            width: 10px;
            height: 10px;
            background: #67c23a;
          }
          &.fail::before {
            position: absolute;
            content: "";
            left: 0;
            top: 5px;
            width: 10px;
            height: 10px;
            background: #d61a21;
          }
        }
      }
    }
    .stage {
      width: 100%;
      margin-bottom: 20px;
      border: 1px solid #d4d4d4;
      padding: 20px;

      .stage-type {
        display: flex;
        justify-content: space-between;
        .stage-type-box {
          position: relative;
          width: 80px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          border: 1px solid #d4d4d4;
          font-size: 14px;
          // 进行中状态
          &.stage-type-box-conduct {
            color: #fff;
            background: #ec6a41;
            border: 1px solid #ec6a41;
            &::before {
              background: #bac7c6;
            }
            &::after {
              border-left-color: #bac7c6;
            }
          }
          // 通过状态
          &.stage-type-box-adopt {
            color: #fff;
            background: #67c23a;
            border: 1px solid #67c23a;
            &::before {
              background: #bac7c6;
            }
            &::after {
              border-left-color: #bac7c6;
            }
          }
          //  失败状态
          &.stage-type-box-fail {
            color: #fff;
            background: #d61a21;
            border: 1px solid #d61a21;
            &::before {
              background: #bac7c6;
            }
            &::after {
              border-left-color: #bac7c6;
            }
          }
          &::before {
            position: absolute;
            content: "";
            width: 18px;
            height: 8px;
            left: 88px;
            top: 10px;
            background: #e9e9e9;
          }
          &::after {
            position: absolute;
            content: "";
            width: 0;
            height: 0;
            left: 100px;
            top: 4px;
            border: 10px solid transparent;
            border-left-color: #e9e9e9;
          }
          // 隐藏最后一个状态的箭头
          &:last-child {
            &::before {
              display: none;
            }
            &::after {
              display: none;
            }
          }
        }
      }
    }
    
  }

  .table-title {
    font-size: 14px;
    font-weight: bold;
    color: #666666;
    margin-top: 20px;
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
}
</style>
