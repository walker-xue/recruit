<template>
  <div>
    <Information></Information>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">简历库</div>
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
                    <span class="required">性别</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="sex">
                      <el-radio-group v-model="form.sex">
                        <el-radio label="男"></el-radio>
                        <el-radio label="女"></el-radio>
                      </el-radio-group>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">手机号</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="phone">
                      <el-input class="con-input" v-model="form.phone"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
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
                    <span class="required">工作年限</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="years">
                      <el-select v-model="form.years" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in yearsData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">薪资要求</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="salary">
                      <el-select v-model="form.salary" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in salaryData"
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
                    <span class="required">简历编号</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="resumeNo">
                      <el-input class="con-input" v-model="form.resumeNo"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">当前工作地</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="currentWorkPlace">
                      <el-cascader
                        v-model="form.currentWorkPlace"
                        :options="expectantlyData"
                        clearable
                      ></el-cascader>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span>期望工作地</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="expectantly">
                      <el-cascader v-model="form.expectantly" :options="expectantlyData" clearable></el-cascader>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span>简历状态</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="resumeStatus">
                      <el-input class="con-input" v-model="form.resumeStatus"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span>简历录入人</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="enteredBy">
                      <el-input class="con-input" v-model="form.enteredBy"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span>简历使用者</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="users">
                      <el-input class="con-input" v-model="form.users"></el-input>
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
            <template slot="resumeNo" slot-scope="scope">
              <span class="main-table-resumeNo" @click="pushClick(scope.row)">{{scope.row.resumeNo}}</span>
            </template>
            <template slot="type" slot-scope="scope">
              <span class="main-table-resumeNo">{{scope.row.type}}</span>
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
      expectantlyData: [
        {
          value: "zhinan",
          label: "指南",
          children: [
            {
              value: "shejiyuanze",
              label: "设计原则",
              children: [
                {
                  value: "yizhi",
                  label: "一致",
                },
                {
                  value: "fankui",
                  label: "反馈",
                },
                {
                  value: "xiaolv",
                  label: "效率",
                },
                {
                  value: "kekong",
                  label: "可控",
                },
              ],
            },
            {
              value: "daohang",
              label: "导航",
              children: [
                {
                  value: "cexiangdaohang",
                  label: "侧向导航",
                },
                {
                  value: "dingbudaohang",
                  label: "顶部导航",
                },
              ],
            },
          ],
        },
        {
          value: "zujian",
          label: "组件",
          children: [
            {
              value: "basic",
              label: "Basic",
              children: [
                {
                  value: "layout",
                  label: "Layout 布局",
                },
                {
                  value: "color",
                  label: "Color 色彩",
                },
                {
                  value: "typography",
                  label: "Typography 字体",
                },
                {
                  value: "icon",
                  label: "Icon 图标",
                },
                {
                  value: "button",
                  label: "Button 按钮",
                },
              ],
            },
            {
              value: "form",
              label: "Form",
              children: [
                {
                  value: "radio",
                  label: "Radio 单选框",
                },
                {
                  value: "checkbox",
                  label: "Checkbox 多选框",
                },
                {
                  value: "input",
                  label: "Input 输入框",
                },
                {
                  value: "input-number",
                  label: "InputNumber 计数器",
                },
                {
                  value: "select",
                  label: "Select 选择器",
                },
                {
                  value: "cascader",
                  label: "Cascader 级联选择器",
                },
                {
                  value: "switch",
                  label: "Switch 开关",
                },
                {
                  value: "slider",
                  label: "Slider 滑块",
                },
                {
                  value: "time-picker",
                  label: "TimePicker 时间选择器",
                },
                {
                  value: "date-picker",
                  label: "DatePicker 日期选择器",
                },
                {
                  value: "datetime-picker",
                  label: "DateTimePicker 日期时间选择器",
                },
                {
                  value: "upload",
                  label: "Upload 上传",
                },
                {
                  value: "rate",
                  label: "Rate 评分",
                },
                {
                  value: "form",
                  label: "Form 表单",
                },
              ],
            },
            {
              value: "data",
              label: "Data",
              children: [
                {
                  value: "table",
                  label: "Table 表格",
                },
                {
                  value: "tag",
                  label: "Tag 标签",
                },
                {
                  value: "progress",
                  label: "Progress 进度条",
                },
                {
                  value: "tree",
                  label: "Tree 树形控件",
                },
                {
                  value: "pagination",
                  label: "Pagination 分页",
                },
                {
                  value: "badge",
                  label: "Badge 标记",
                },
              ],
            },
            {
              value: "notice",
              label: "Notice",
              children: [
                {
                  value: "alert",
                  label: "Alert 警告",
                },
                {
                  value: "loading",
                  label: "Loading 加载",
                },
                {
                  value: "message",
                  label: "Message 消息提示",
                },
                {
                  value: "message-box",
                  label: "MessageBox 弹框",
                },
                {
                  value: "notification",
                  label: "Notification 通知",
                },
              ],
            },
            {
              value: "navigation",
              label: "Navigation",
              children: [
                {
                  value: "menu",
                  label: "NavMenu 导航菜单",
                },
                {
                  value: "tabs",
                  label: "Tabs 标签页",
                },
                {
                  value: "breadcrumb",
                  label: "Breadcrumb 面包屑",
                },
                {
                  value: "dropdown",
                  label: "Dropdown 下拉菜单",
                },
                {
                  value: "steps",
                  label: "Steps 步骤条",
                },
              ],
            },
            {
              value: "others",
              label: "Others",
              children: [
                {
                  value: "dialog",
                  label: "Dialog 对话框",
                },
                {
                  value: "tooltip",
                  label: "Tooltip 文字提示",
                },
                {
                  value: "popover",
                  label: "Popover 弹出框",
                },
                {
                  value: "card",
                  label: "Card 卡片",
                },
                {
                  value: "carousel",
                  label: "Carousel 走马灯",
                },
                {
                  value: "collapse",
                  label: "Collapse 折叠面板",
                },
              ],
            },
          ],
        },
        {
          value: "ziyuan",
          label: "资源",
          children: [
            {
              value: "axure",
              label: "Axure Components",
            },
            {
              value: "sketch",
              label: "Sketch Templates",
            },
            {
              value: "jiaohu",
              label: "组件交互文档",
            },
          ],
        },
      ],
      postData: [
        { value: "java" },
        { value: "c" },
        { value: "c++" },
        { value: "C#" },
        { value: "python" },
      ],
      yearsData: [
        { value: "1年" },
        { value: "2年" },
        { value: "3年" },
        { value: "4年" },
        { value: "5年" },
      ],
      salaryData: [
        { value: "5k-8k" },
        { value: "9k-11k" },
        { value: "12k-15k" },
      ],
      skillData: [{ value: "java" }, { value: "js" }, { value: "python" }],
      degreeData: [{ value: "了解" }, { value: "熟悉" }, { value: "熟练" }],
      usageTimeData: [
        { value: "1年" },
        { value: "2年" },
        { value: "3年" },
        { value: "4年" },
        { value: "5年" },
      ],

      // 标签
      dynamicTags: [
        { name: "姓名" },
        { name: "性别" },
        { name: "电话号码" },
        { name: "岗位" },
        { name: "工作年限" },
        { name: "薪资要求" },
        { name: "简历编号" },
        { name: "当前工作地" },
        { name: "期望工作地" },
        { name: "简历状态" },
        { name: "简历录入人" },
        { name: "简历使用者" },
      ],
      // 表格内容
      tableData: [
        {
          resumeNo: "20200819",
          name: "张立华",
          post: "java",
          years: "3-5年",
          expectantly: "杭州",
          type: "已入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
        {
          resumeNo: "20200818",
          name: "周欢",
          post: "c++",
          years: "3-5年",
          expectantly: "上海",
          type: "待入职",
          evaluate: "胡兆鹏",
        },
      ],
      // 表格分页
      pagination: new Page(),
      // 表头配置
      tableCols: [
        {
          label: "简历编号",
          slot: "resumeNo",
        },
        {
          label: "姓名",
          prop: "name",
        },
        {
          label: "岗位",
          prop: "post",
        },
        {
          label: "工作年限",
          prop: "years",
        },
        {
          label: "期望工作地",
          prop: "expectantly",
        },
        {
          label: "状态",
          slot: "type",
        },
        {
          label: "简历使用人",
          prop: "evaluate",
        },
        // {
        //   label: "操作",
        //   align: "center",
        //   "header-align": "center",
        //   width: "220px",
        //   slot: "operation",
        // },
      ],
    };
  },
  methods: {
    // 跳转详情
    pushClick(data) {
      this.$router.push({
        name: "Details",
        params: { odata: data, status: "edit" },
      });
    },
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
  }
}
</style>

