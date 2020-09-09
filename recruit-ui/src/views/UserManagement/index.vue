<template>
  <div>
    <Information></Information>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">用户管理</div>
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
                    <span class="required">姓名</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="name">
                      <el-input class="con-input" v-model="form.name"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">工号</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="jobNumber">
                      <el-input class="con-input" v-model="form.jobNumber"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">部门</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="department">
                      <el-select v-model="form.department" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in departmentData"
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
              </el-row>
            </div>
            <!--操作-->
            <div class="operation-wrap">
              <div class="operation-btn">返回</div>
              <div class="operation-btn" @click="createClick()">新增</div>
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
            :isIndex="isIndex"
            class="table-wrap"
            @refresh="refresh"
            @checkbox-data="checkBoxData"
          >
            <!-- 姓名 -->
            <template slot="name" slot-scope="scope">
              <span class="main-table-resumeNo" @click="pushClick(scope.row)">{{scope.row.name}}</span>
            </template>

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
        jobNumber: "", // 工号
        department: "", // 部门
        business: "", // 业务线
      },
      departmentData: [{ value: "研发部" }, { value: "技术部" }],
      businessData: [{ value: "工厂" }, { value: "车间" }],

      // 标签
      dynamicTags: [
        { name: "姓名" },
        { name: "工号" },
        { name: "部门" },
        { name: "业务线" },
      ],
      // 表格内容
      tableData: [
        {
          name: "张丽华",
          jobNumber: "83456",
          phone: "1501515611",
          mailbox: "1275181746@qq.com",
          resume: "java",
          business: "企业服务",
          qualified: "阿里",
        },
        {
          name: "张丽华",
          jobNumber: "83456",
          phone: "1501515611",
          mailbox: "1275181746@qq.com",
          resume: "java",
          business: "企业服务",
          qualified: "阿里",
        },
        {
          name: "张丽华",
          jobNumber: "83456",
          phone: "1501515611",
          mailbox: "1275181746@qq.com",
          resume: "java",
          business: "企业服务",
          qualified: "阿里",
        },
      ],
      // 表格分页
      pagination: new Page(),
      // 表头配置
      tableCols: [
        {
          label: "姓名",
          slot: "name",
        },
        {
          label: "工号",
          prop: "jobNumber",
        },
        {
          label: "手机号",
          prop: "phone",
        },
        {
          label: "邮箱",
          prop: "mailbox",
        },
        {
          label: "岗位",
          prop: "resume",
        },
        {
          label: "业务线",
          prop: "business",
        },
        {
          label: "部门",
          prop: "qualified",
        },
        {
          label: "操作",
          slot: "operation",
        },
      ],
    };
  },
  methods: {
    // 跳转详情
    pushClick(data) {
      this.$router.push({
        name: "Information",
        params: { odata: data, status: "edit" },
      });
    },
    // 新增
    createClick() {
      this.$router.push({
        name: "Information",
        params: { status: "create" },
      });
    },
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
      console.log("详情", row);
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
/deep/.el-scrollbar__wrap {
  height: calc(100vh - 182px);
}
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
