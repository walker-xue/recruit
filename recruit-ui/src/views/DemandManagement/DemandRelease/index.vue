<template>
  <div>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">需求发布</div>
        </div>

        <!-- 表单 -->
        <div class="con">
          <el-form ref="ruleForm" :model="form" :rules="rules">
            <div class="basic-con">
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
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">项目名称</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="entryName">
                      <el-input class="con-input" v-model="form.entryName"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">到岗时间</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="time">
                      <el-date-picker v-model="form.time" type="date" placeholder="选择日期"></el-date-picker>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
              <el-row class="basic-con-row">
                <el-col class="basic-con-col basic-con-col-textarea" :span="24">
                  <div class="basic-con-col-name">
                    <span>项目介绍</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="introduce">
                      <el-input
                        class="con-textarea"
                        type="textarea"
                        placeholder="请输入内容"
                        v-model="form.introduce"
                        maxlength="50"
                        show-word-limit
                      ></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <!-- 岗位 -->
              <el-row class="basic-con-row" v-for="(item,index) in form.postForm" :key="index">
                <el-col class="basic-con-col" :span="7">
                  <div class="basic-con-col-name">
                    <span class="required">岗位</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item :prop="'postForm.'+index+'.post'" :rules="rules.post">
                      <el-select v-model="item.post" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in postData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="7">
                  <div class="basic-con-col-name">
                    <span class="required">级别</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item :prop="'postForm.'+index+'.level'" :rules="rules.level">
                      <el-select v-model="item.level" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in levelData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="7">
                  <div class="basic-con-col-name">
                    <span class="required">需求数</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item :prop="'postForm.'+index+'.demandNum'" :rules="rules.demandNum">
                      <el-input class="con-input" v-model="item.demandNum"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="3">
                  <div class="post-operation-wrap">
                    <div class="post-operation" @click="postAdd(index)">
                      <i class="iconfont iconjia"></i>
                    </div>
                    <div class="post-operation" @click="postClear(index)">
                      <i class="iconfont iconcuohao"></i>
                    </div>
                  </div>
                </el-col>
              </el-row>

              <!-- 岗位JD -->
              <el-row class="basic-con-row">
                <el-col class="basic-con-col basic-con-col-textarea" :span="24">
                  <div class="basic-con-col-name">
                    <span>项目介绍</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="postJD">
                      <el-input
                        class="con-textarea"
                        type="textarea"
                        placeholder="请输入内容"
                        v-model="form.postJD"
                        maxlength="50"
                        show-word-limit
                      ></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>
            <!--操作-->
            <div class="operation-wrap">
              <div class="operation-btn" @click="submitForm('ruleForm')">发布</div>
            </div>
          </el-form>
        </div>
      </div>
    </el-scrollbar>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      isIndex: true,
      status: null, // 用来判断是新增还是编辑
      form: {
        business: "", // 业务线
        entryName: "", // 项目名称
        time: "", // 到岗时间
        introduce: "", // 项目简介
        postJD: "", // 岗位JD
        postForm: [
          {
            post: "", // 岗位
            level: "", // 级别
            demandNum: "", // 需求数
          },
        ],
      },
      levelData: [{ value: "初级" }, { value: "高级" }],
      businessData: [{ value: "业务线1" }, { value: "业务线2" }],
      postData: [{ value: "java" }, { value: "python" }],

      // 正则
      rules: {
        business: [
          { required: true, message: "请选择业务线", trigger: "blur" },
        ],
        entryName: [
          { required: true, message: "请输入项目名称", trigger: "blur" },
        ],
        time: [{ required: true, message: "请选择到岗时间", trigger: "blur" }],
        post: [{ required: true, message: "请输入岗位", trigger: "blur" }],
        level: [{ required: true, message: "请输入级别", trigger: "blur" }],
        demandNum: [
          { required: true, message: "请输入需求数", trigger: "blur" },
        ],
        // business: [{ required: true, message: "请输入业务线", trigger: "blur" }],
      },
    };
  },
  created() {
    // console.log(this.$route.params)
    // // 根据传值判断
    // if (this.$route.params.status==='create') {
    //   this.status = 'create'
    // } else if (this.$route.params.status==='edit') {
    //   this.status = 'edit'
    //   Object.assign(this.form,this.$route.params.odata)
    // } else {
    //   this.$router.push({name:'Administer'})
    // }
  },
  methods: {
    // 确定
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.status === "create") {
            this.$message({
              type: "success",
              message: "添加成功",
            });
          } else {
            this.$message({
              type: "success",
              message: "发布成功",
            });
          }
          
          console.log(this.form);
        } else {
          this.$message.error("请填写必填项");
          return false;
        }
      });
    },
    postAdd(index) {
      let odata = {
        post: "", // 岗位
        level: "", // 级别
        demandNum: "", // 需求数
      };
      this.form.postForm.splice(index + 1, 0, odata);
    },

    postClear(index) {
      if (this.form.postForm.length <= 1) {
        this.$message({
          message: "最少保留一条",
          type: "warning",
        });
      } else {
        this.form.postForm.splice(index, 1);
      }
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
  .el-form-item {
    margin-bottom: 0;
  }
  .main-label {
    width: 100%;
    // padding: 10px 0px;
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
          .con-add {
            height: 36px;
            overflow: hidden;
            overflow: hidden;
            .con-add-input {
              width: 200px;
              height: 28px;
              float: left;
            }
            .con-add-btn {
              float: left;
              width: 85px;
              height: 24px;
              line-height: 24px;
              background: #d61a21;
              font-size: 14px;
              text-align: center;
              color: #fff;
              cursor: pointer;
              margin-left: 10px;
              margin-top: 6px;
            }
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
          /deep/.el-textarea__inner {
            width: 100%;
            height: 90px;
            resize: none;
            margin-top: 4px;
          }
        }
        .post-operation-wrap {
          display: flex;
          .post-operation {
            margin-top: 8px;
            width: 20px;
            height: 20px;
            line-height: 20px;
            background: #d61a21;
            cursor: pointer;
            text-align: center;
            margin-left: 10px;
            i {
              color: #fff;
            }
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
}
/deep/.el-scrollbar__wrap {
  height: calc(100vh - 182px);
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
