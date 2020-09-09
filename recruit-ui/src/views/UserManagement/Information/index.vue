<template>
  <div>
    <Information></Information>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">用户信息</div>
        </div>

        <!-- 表单 -->
        <div class="con">
          <el-form ref="ruleForm" :model="form" :rules="rules">
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
                    <span class="required">邮箱</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="mailbox">
                      <el-input class="con-input" v-model="form.mailbox"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">用户名</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="user">
                      <el-input class="con-input" v-model="form.user"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">直系领导</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="leader">
                      <el-input class="con-input" v-model="form.leader"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">职位</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="position">
                      <el-select v-model="form.position" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in positiontData"
                          :key="index"
                          :value="item.value"
                        ></el-option>
                      </el-select>
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
                <el-col class="basic-con-col basic-con-col-business" :span="14">
                  <div class="basic-con-col-name">
                    <span >业务线</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="business">
                      <div class="con-add">
                        <el-input class="con-add-input" v-model="form.business"></el-input>
                        <div class="con-add-btn" @click="businessAdd()">添加</div>
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
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
                <el-col class="basic-con-col basic-con-col-textarea" :span="24">
                  <div class="basic-con-col-name">
                    <span>备注</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="remarks">
                      <el-input
                        class="con-textarea"
                        type="textarea"
                        placeholder="请输入内容"
                        v-model="form.remarks"
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
              <div class="operation-btn" @click="clearClick()">返回</div>
              <div class="operation-btn" @click="submitForm('ruleForm')">确认</div>
            </div>
          </el-form>
        </div>
      </div>
    </el-scrollbar>
  </div>
</template>

<script type="text/ecmascript-6">
import Information from "@/components/Information/index.vue";
export default {
  components: {
    Information,
  },
  data() {
    return {
      isIndex: true,
      status: null, // 用来判断是新增还是编辑
      form: {
        name: "", // 姓名
        jobNumber: "", // 工号
        phone: "", // 手机号
        mailbox: "", // 邮箱
        user: "", // 用户名
        leader: "", // 直系领导
        position: "", // 职位
        department: "", // 部门
        business: "", // 业务线
        remarks: "", // 备注
      },
      departmentData: [{ value: "研发部" }, { value: "技术部" }],
      positiontData: [{ value: "java" }, { value: "python" }],

      // 标签
      dynamicTags: [
        { name: "姓名" },
        { name: "工号" },
        { name: "部门" },
        { name: "业务线" },
        { name: "业务线2" },
      ],

       // 正则
      rules: {
        name: [{ required: true, message: "请输入姓名", trigger: "blur" }],
        jobNumber: [{ required: true, message: "请输入工号", trigger: "blur" }],
        phone: [
          { required: true, message: "请输入手机号", trigger: "blur" },
          // { validator: validate('phone') }
        ],
        mailbox: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        user: [{ required: true, message: "请输入用户名", trigger: "blur" },],
        leader: [{ required: true, message: "请输入直系领导", trigger: "blur" },],
        position: [{ required: true, message: "请选择职位", trigger: "blur" }],
        department: [{ required: true, message: "请选择部门", trigger: "blur" }],
        // business: [{ required: true, message: "请输入业务线", trigger: "blur" }],
        
      },
    };
  },
  created() {
    console.log(this.$route.params)
    // 根据传值判断
    if (this.$route.params.status==='create') {
      this.status = 'create'
    } else if (this.$route.params.status==='edit') {
      this.status = 'edit'
      Object.assign(this.form,this.$route.params.odata)
    } else {
      this.$router.push({name:'UserManagement'})
    }
  },
  methods: {
    // 确定
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if(this.status ==='create') {
            this.$message({
              type: 'success',
              message: '添加成功'
            })
          } else {
            this.$message({
              type: 'success',
              message: '修改成功'
            })
          }
          console.log(this.form);
          this.$router.push({name:'Administer'})
        } else {
          this.$message.error("请填写必填项");
          return false;
        }
      });
    },

    // 标签
    handleClose(tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
    },
    // 关闭
    clearClick() {
      this.$router.push({
        name:'UserManagement'
      })
    },

    // 添加业务线标签
    businessAdd() {
      if (this.form.business) {
        this.dynamicTags.push({"name":this.form.business})
          this.form.business = ''
      } else {
        this.$message({
          message: "请填写业务线",
          type: "warning",
        });
      }
    }
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
        &.basic-con-col-business {
          height: auto;
        }
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
</style>
