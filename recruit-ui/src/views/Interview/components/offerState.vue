<template>
  <div>
    <div class="con-use">
      <div class="con-use-view">
        <div class="con-use-title">
          <div class="con-use-title-txt">offer</div>
        </div>
        <el-form ref="ruleForm" :model="form" class="ruleForm">
          <el-row>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">简历编号：</p>
                <p>{{form.resumeNo}}</p>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">姓名：</p>
                <p>{{form.name}}</p>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">岗位：</p>
                <p>{{form.post}}</p>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">项目：</p>
                <p>{{form.project}}</p>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">业务线：</p>
                <p>{{form.business}}</p>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">offer结果：</p>
                <div class="basic-con-col-r">
                    <el-form-item prop="offer">
                      <el-select v-model="form.offer" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in offerData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </div>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">时间：</p>
                <div class="basic-con-col-r">
                    <el-form-item prop="time">
                      <el-date-picker v-model="form.time" type="date" placeholder="选择日期"></el-date-picker>
                    </el-form-item>
                  </div>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="con-use-view-col">
                <p class="con-use-view-col-title">薪资：</p>
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
              </div>
            </el-col>
            
            <el-col :span="24">
              <div class="con-use-view-col">
                <div class="basic-con-col-r">
                  <el-form-item>
                    <el-input
                      class="con-textarea"
                      type="textarea"
                      placeholder="请输入内容"
                      v-model="form.details"
                      maxlength="50"
                      show-word-limit
                    ></el-input>
                  </el-form-item>
                </div>
              </div>
            </el-col>
          </el-row>
          <!-- 操作 -->
          <div class="operation">
            <div class="operation-btn" @click="submitForm('ruleForm')">提交</div>
            <div class="operation-btn" @click="clearClick()">取消</div>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      form: {
        resumeNo: "20200827", // 简历编号
        name: "李丽华", // 姓名
        post: "java", // 岗位
        project: "芝麻信用", // 项目
        business: "企业服务", // 业务线
        offer: '', // offer结果
        time: '', // 时间
        salary: '', // 薪资
        details: "", // 详情

      },
      offerData: [{ value: "同意" }, { value: "拒绝" }],
      salaryData: [{ value: "9-12" }, { value: "13-15" }],
    };
  },
  created() {},
  methods: {
    // 导出
    submitForm(formName) {
      this.$message({
        type: "success",
        message: "提交成功",
      });
    },
    // 返回关闭
    clearClick() {
      this.$router.push({
        name: "Candidates",
      });
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
.con-use {
  width: 100%;
  .con-use-title {
    position: absolute;
    left: 10px;
    top: -10px;
    width: 60px;
    height: 20px;
    background: #fff;
    .con-use-title-txt {
      text-align: center;
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
    position: relative;
    width: 100%;
    height: auto;
    margin-top: 5px;
    border: 1px solid #d4d4d4;
    padding-top: 20px;
    .ruleForm {
      padding: 0 20px;
    }
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
      margin-bottom: 16px;
      min-height: 36px;
      line-height: 36px;
      .el-form-item {
        margin-bottom: 0;
      }
      .basic-con-col-r {
        flex: 1;
        padding: 0 5px;
        line-height: initial;
      }
      p {
        font-size: 14px;
      }
      .con-use-view-col-title {
        width: 100px;
        text-align: right;
      }
    }
    // 操作
    .operation {
      display: flex;
      margin-bottom: 15px;
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
}
/deep/.el-date-editor.el-input,
.el-date-editor.el-input__inner {
  width: 140px;
  margin-top: 1px;
  .el-input__inner {
    height: 30px;
    line-height: 30px;
  }
  .el-input__icon {
    line-height: 30px;
  }
}
</style>
