<template>
    <div>
        <header class="header">
            <div class="header-logo">
            </div>
        </header>
        <section class="main">
            <div class="main-con-wrap">
                <div class="main-con-introduce">
                    <p class="main-con-introduce-title">
                        <span>有追溯</span>
                        <span>有品牌</span>
                        <span>有未来</span>
                    </p>
                </div>
                <div class="main-con">
                    <p class="main-con-title">登录</p>
                    <el-form class="userform" ref="form" :model="form" :rules="rules">
                        <el-row>
                            <el-col style="margin-bottom: 20px" :span="24">
                                <el-form-item prop="username">
                                    <el-input
                                            v-model="form.username"
                                            class="userform-user"
                                            :maxlength="20"
                                            placeholder="请输入用户名"
                                    >
                                    </el-input>
                                    <div class="userform-mask">
                                        <i class="iconfont iconyonghu1"></i>
                                    </div>
                                </el-form-item>
                            </el-col>
                            <el-col :span="24">
                                <el-form-item prop="password">
                                    <el-input
                                            v-model="form.password"
                                            class="userform-pwd"
                                            type="password"
                                            :maxlength="20"
                                            placeholder="请输入密码"
                                    ></el-input>
                                    <div class="userform-mask">
                                        <i class="iconfont iconmm"></i>
                                    </div>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="24">
                                <el-form-item>
                                    <el-button
                                            class="logon-btn"
                                            type="primary"
                                            @click="loginClick('form')"
                                    >登录</el-button
                                    >
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-form>
                </div>
            </div>
        </section>
    </div>
</template>

<script type="text/ecmascript-6">
  export default {
    name: 'login',
    data() {
      return {
        form: {
          username: 'admin',
          password: '123456',
          remember: false
        },
        rules: {
          username: [
            { required: true, message: "请输入用户名", trigger: "blur" },
            { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
          ],
          password: [
            { required: true, message: "请输入密码", trigger: "blur" },
            { min: 1, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
          ]
        },
      }
    },
    mounted() {
      // this.getCookie()
    },
    methods: {
      // 登录
      loginClick(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {

            let ouser = {
              username: this.form.username,
              password: this.form.password,
            }
            this.$api.Common.login(ouser).then(res=> {
              console.log('数据',res)
              if (res.code == 200) {
                this.$store.dispatch('Login',res.data).then(async()=>{
                  //登录成功
                  this.$message({message: '登录成功', type: 'success'});
                  this.$router.push({
                    path: "/pendingMatters"
                  });
                })
              }else {
                this.$message.error('账号密码错误');
              }
            })
          } else {
            return false;
          }
        });
      },
    }
  }
</script>

<style scoped lang="less">
    .header {
        width: 1200px;
        height: 79px;
        margin: 0 auto;
        overflow: hidden;
        .header-logo {
            padding-top: 16px;
        }
    }
    .main {
        position: relative;
        width: 100%;
        height: calc(100vh - 79px);
        .main-banner {
            position: absolute;
            width: 100%;
            height: 100%;
            object-fit: cover;
            z-index: -1;
        }
        .main-con-wrap {
            position: relative;
            width: 1200px;
            height: calc(100vh - 79px);
            margin: 0 auto;
            .main-con-introduce {
                position: absolute;
                top: 32%;
                left: 50px;
                .main-con-introduce-title {
                    font-size: 50px;
                    font-weight: bold;
                    color: #fff;
                    span {
                        margin-right: 50px;
                        &:last-child {
                            margin-right: 0;
                        }
                    }
                }
                .main-con-introduce-txt {
                    margin-top: 50px;
                    text-align: right;
                    font-weight: bold;
                    font-size: 22px;
                    color: #d7d8d4;
                    span {
                        position: relative;
                        letter-spacing: 5px;
                        &:before {
                            content: "";
                            position: absolute;
                            left: -84px;
                            top: 15px;
                            width: 68px;
                            height: 2px;
                            background: #d7d8d4;
                        }
                    }
                }
            }
            .main-con {
                position: absolute;
                right: 0;
                top: 50%;
                margin-top: -260px;
                width: 463px;
                height: 460px;
                background: rgba(255, 255, 255, 0.8);
                box-shadow: 5px 9px 15px 0px rgba(62, 64, 66, 0.07);
                .main-con-title {
                    font-size: 24px;
                    color: #010101;
                    padding: 40px 0;
                    text-align: center;
                }
                .userform {
                    padding: 0 55px;
                    .userform-user {
                        /deep/.el-input__inner {
                            padding-left: 70px;
                        }
                    }
                    .userform-pwd {
                        /deep/.el-input__inner {
                            padding-left: 70px;
                        }
                    }
                    .userform-mask {
                        position: absolute;
                        left: 0;
                        top: 0;
                        width: 60px;
                        height: 54px;
                        line-height: 54px;
                        text-align: center;
                        i {
                            font-size: 20px;
                            color: #7d878e;
                        }
                        &:before {
                            content: "";
                            position: absolute;
                            right: 0;
                            top: 12px;
                            width: 1px;
                            height: 30px;
                            background: #dddddd;
                        }
                    }
                    .userform-remember {
                        float: left;
                        /deep/.el-checkbox__label {
                            font-size: 16px;
                            color: #7c868d;
                        }
                    }
                    .userform-retrieve {
                        line-height: 39px;
                        float: right;
                        color: #7c868d;
                        font-size: 16px;
                        cursor: pointer;
                    }
                    .logon-btn {
                        width: 100%;
                        height: 53px;
                        border-radius: 0;
                    }
                    .register {
                        text-align: center;
                        color: #499bfc;
                        font-size: 14px;
                        margin-top: 25px;
                        cursor: pointer;
                    }
                    .modify {
                        text-align: center;
                        font-size: 14px;
                        color: #707070;
                        margin-top: 5px;
                        cursor: pointer;
                    }
                }
            }
        }
    }
    /deep/.el-input__inner {
        height: 54px;
        line-height: 54px;
    }
</style>
