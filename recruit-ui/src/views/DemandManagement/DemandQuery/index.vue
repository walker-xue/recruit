<template>
  <div>
    <Information></Information>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">需求查询</div>
        </div>
        <!-- 标签 -->
        <div class="main-label">
          <div>
            <el-tag
              v-for="item in dynamicTags"
              :key="item.name"
              closable
              type="info"
              @close="handleClose(item)"
            >{{item.name}}</el-tag>
          </div>
        </div>
        <!-- 表单 -->
        <div class="con">
          <el-form ref="ruleForm" :model="form">
            <div class="basic-con">
              <el-row class="basic-con-row">
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">需求编号</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="code">
                      <el-input class="con-input" v-model="form.code"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">岗位</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="post">
                      <el-select v-model="form.post" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in postData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                 <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">需求状态</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="type">
                      <el-select v-model="form.type" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in typeData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">项目</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="project">
                      <el-input class="con-input" v-model="form.project"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">业务线</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="business">
                      <el-select v-model="form.business" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in businessData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">交互经理</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="manager">
                      <el-input class="con-input" v-model="form.manager"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>
            <!--操作-->
            <div class="operation-wrap">
              <div class="operation-btn">返回</div>
              <div class="operation-btn" @click="getList('ruleForm')">查询</div>
            </div>
          </el-form>
        </div>
        <!-- 表格 -->
        <div class="main-table">
          <SirTable
            :table-cols="tableCols"
            :table-data="tableData"
            :pag-ination="pagination"
            class="table-wrap"
            @refresh="refresh"
            @checkbox-data="checkBoxData"
          >
            <!-- 编号 -->
            <template slot="resumeNo" slot-scope="scope">
              <span class="main-table-resumeNo">{{scope.row.resumeNo}}</span>
            </template>
            <!-- 状态 -->
            <template slot="type" slot-scope="scope">
              <span class="main-table-resumeNo">{{scope.row.type}}</span>
            </template>
            <!-- 招聘进程 -->
            <template slot="process" slot-scope="scope">
              <div class="process-wrap">
                <div class="process-item">
                  <p>需求数</p><p>{{scope.row.process.demandNumber}}</p>
                </div>
                <div class="process-item">
                  <p>已入职</p><p>{{scope.row.process.employed}}</p>
                </div>
                <div class="process-item">
                  <p>待入职</p><p>{{scope.row.process.toBeEmployed}}</p>
                </div>
                <div class="process-item">
                  <p>缺口</p><p>{{scope.row.process.gap}}</p>
                </div>
              </div>
            </template>
            <!-- 按钮 -->
            <template slot="distribution" slot-scope="scope">
              <span class="main-table-btn" @click="handleSee(scope.row)">
                <i class="iconfont iconfenpei"></i> </span
              >
            </template>
          </SirTable>
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
      form: {
        code: "", // 需求编号
        post: "", // 岗位
        type: "", // 需求状态
        project: "", // 项目
        business: "", // 业务线
        manager: "", // 交互经理
      },
      postData: [
        { value: "java" },
        { value: "c" },
        { value: "c++" },
        { value: "C#" },
        { value: "python" },
      ],
      typeData: [
        { value: "已审批" },
        { value: "未审批" },
        { value: "已通过" },
        { value: "未通过" },
      ],
      businessData: [
        { value: "工厂" },
        { value: "车间" },
      ],
      


      // 标签
      dynamicTags: [
        { name: "需求编号" },
        { name: "岗位" },
        { name: "需求状态" },
        { name: "项目" },
        { name: "业务线" },
        { name: "交互经理" },
      ],
      // 表格内容
      tableData: [
        {
          resumeNo: "20200819",
          business: "企业服务",
          project: "芝麻信用",
          post: "java",
          level: "高级",
          process: {
            demandNumber: '25',
            employed: '13',
            toBeEmployed: '5',
            gap: '7'
          },
          type: "已保存",
          manager: "胡兆鹏",
        },
        {
          resumeNo: "20200819",
          business: "企业服务",
          project: "芝麻信用",
          post: "java",
          level: "高级",
          process: {
            demandNumber: '36',
            employed: '18',
            toBeEmployed: '2',
            gap: '16'
          },
          type: "已保存",
          manager: "胡兆鹏",
        },
        {
          resumeNo: "20200819",
          business: "企业服务",
          project: "芝麻信用",
          post: "java",
          level: "高级",
          process: {
            demandNumber: '15',
            employed: '6',
            toBeEmployed: '5',
            gap: '4'
          },
          type: "已保存",
          manager: "胡兆鹏",
        },
      ],
      // 表格分页
      pagination: new Page(),
      // 表头配置
      tableCols: [
        {
          label: "需求编号",
          slot: "resumeNo",
        },
        {
          label: "业务线",
          prop: "business",
        },
        {
          label: "项目",
          prop: "project",
        },
        {
          label: "岗位",
          prop: "post",
        },
        {
          label: "级别",
          prop: "level",
        },
        {
          label: "招聘进程",
          slot: "process",
          width: "300px",
          "header-align": "center",
        },
        {
          label: "状态",
          slot: "type",
        },
        {
          label: "交互经理",
          prop: "manager",
        },
        {
          label: "分配",
          align: "center",
          "header-align": "center",
          slot: "distribution",
        },
      ],
    };
  },
  methods: {
    // 查询
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
      console.log('详情',row)
    },

    // 标签
    handleClose(tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
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
/deep/.el-form-item__content {
  line-height: 36px;
}
/deep/.el-input__inner {
  height: 28px;
  line-height: 28px;
}
/deep/.el-form-item__error {
  display: none;
}
/deep/.el-input__icon {
  line-height: 36px;
}
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
  .main-label {
    width: 100%;
    padding: 10px 0px;
    height: auto;
    .el-tag {
      margin-right: 10px;
      margin-bottom: 10px;
    }
  }
  .con {
    width: 100%;
    box-shadow: 0 0 0 1px #d4d4d4, 0 0 0 5px #fff;
    padding: 2px;
    .basic-con {
      border: 1px solid #d4d4d4;
      .basic-con-row {
        border-bottom: 1px solid #e9e9e9;
      }
      .basic-con-col {
        height: 36px;
        line-height: 36px;
        display: flex;
        &.basic-con-col-textarea {
          height: 100px;
          line-height: 100px;
        }
        .basic-con-col-name {
          width: 90px;
          background: #f8f8f8;
          text-align: right;
          color: #666666;
          font-size: 14px;
          padding-right: 5px;
          border-right: 1px solid #e9e9e9;
          span.required {
            position: relative;
            &:before {
              position: absolute;
              content: "*";
              top: -5px;
              left: -8px;
              color: #d61a21;
              font-weight: bold;
            }
          }
        }
        .basic-con-col-r {
          flex: 1;
          padding: 0 5px;
          line-height: initial;
          border-right: 1px solid #e9e9e9;
          .con-input {
            width: 100%;
            height: 28px;
          }
          .con-radio {
            font-size: 14px;
            input {
              vertical-align: middle;
              margin-left: 10px;
              cursor: pointer;
            }
          }
          .con-select {
            width: 100%;
            height: 28px;
            margin-top: 4px;
          }
          .con-textarea {
            width: 100%;
            height: 90px;
            resize: none;
            margin-top: 4px;
          }
        }
      }
    }
    /*操作*/
    .operation-wrap {
      width: 100%;
      padding-top: 10px;
      height: 42px;
      .operation-btn {
        width: 85px;
        height: 24px;
        line-height: 24px;
        background: #d61a21;
        font-size: 14px;
        text-align: center;
        color: #fff;
        float: right;
        cursor: pointer;
        margin-right: 10px;
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
        p{
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
  height: calc(100vh - 182px);
}
</style>
