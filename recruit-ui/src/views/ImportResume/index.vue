<template>
  <div>
    <Information></Information>
    <el-scrollbar class="main-scrollbar">
      <div class="main">
        <div class="header">
          <div class="header-title">导入简历</div>
        </div>
        <el-form ref="ruleForm" :model="form" :rules="rules" class="demo-ruleForm form-rules-show">
          <!-- 基本信息 -->
          <div class="basic">
            <div class="basic-title">
              <p class="basic-title-l">基本信息</p>
              <p class="basic-title-r">
                注：此
                <span>*</span> 符号为必填字段
              </p>
            </div>
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
                    <span class="required">邮箱</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="mail">
                      <el-input class="con-input" v-model="form.mail"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">居住地</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="habitation">
                      <el-cascader v-model="form.habitation" :options="expectantlyData" clearable></el-cascader>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span class="required">期望地</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="expectantly">
                      <el-cascader v-model="form.expectantly" :options="expectantlyData" clearable></el-cascader>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span>籍贯</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="nativePlace">
                      <el-select v-model="form.nativePlace" placeholder="请选择">
                        <el-option
                          v-for="(item,index) in nativePlace"
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
                    <span>出生日期</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="birth">
                      <el-input class="con-input" v-model="form.birth"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span>身份证号</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="id">
                      <el-input class="con-input" v-model="form.id"></el-input>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col class="basic-con-col" :span="8">
                  <div class="basic-con-col-name">
                    <span></span>
                  </div>
                  <div class="basic-con-col-r"></div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
                <el-col class="basic-con-col basic-con-col-textarea" :span="24">
                  <div class="basic-con-col-name">
                    <span>自我评价</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="evaluate">
                      <el-input
                        class="con-textarea"
                        type="textarea"
                        placeholder="请输入内容"
                        v-model="form.evaluate"
                        maxlength="50"
                        show-word-limit
                      ></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>

              <el-row class="basic-con-row">
                <el-col class="basic-con-col basic-con-col-textarea" :span="24">
                  <div class="basic-con-col-name">
                    <span>其他信息</span>
                  </div>
                  <div class="basic-con-col-r">
                    <el-form-item prop="other">
                      <el-input
                        class="con-textarea"
                        type="textarea"
                        placeholder="请输入内容"
                        v-model="form.other"
                        maxlength="50"
                        show-word-limit
                      ></el-input>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>
          </div>

          <!--IT技能-->
          <div class="skill">
            <div class="skill-title">
              <p class="skill-title-l">IT技能</p>
            </div>
            <div class="skill-con">
              <el-form
                ref="ruleFormSkill"
                :model="form"
                :rules="rules"
                class="demo-ruleForm form-rules-show"
              >
                <el-row class="skill-con-row" v-for="(item,index) in form.dataForm" :key="index">
                  <el-col :span="24">
                    <el-row class="skill-con-box">
                      <el-col class="basic-con-col" :span="8">
                        <div class="basic-con-col-name">
                          <span class="required">技能名称</span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item :prop="'dataForm.'+index+'.skill'" :rules="rules.skill">
                            <el-select v-model="item.skill" placeholder="请选择">
                              <el-option
                                v-for="(item,index) in skillData"
                                :key="index"
                                :value="item.value"
                              ></el-option>
                            </el-select>
                          </el-form-item>
                        </div>
                      </el-col>
                      <el-col class="basic-con-col" :span="8">
                        <div class="basic-con-col-name">
                          <span class="required">使用时间</span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item
                            :prop="'dataForm.'+index+'.usageTime'"
                            :rules="rules.usageTime"
                          >
                            <el-select v-model="item.usageTime" placeholder="请选择">
                              <el-option
                                v-for="(item,index) in usageTimeData"
                                :key="index"
                                :value="item.value"
                              ></el-option>
                            </el-select>
                          </el-form-item>
                        </div>
                      </el-col>
                      <el-col class="basic-con-col" :span="8">
                        <div class="basic-con-col-name">
                          <span class="required">掌握程度</span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item :prop="'dataForm.'+index+'.degree'" :rules="rules.degree">
                            <el-select v-model="item.degree" placeholder="请选择">
                              <el-option
                                v-for="(item,index) in degreeData"
                                :key="index"
                                :value="item.value"
                              ></el-option>
                            </el-select>
                          </el-form-item>
                        </div>
                      </el-col>
                    </el-row>
                  </el-col>
                  <el-col :span="24">
                    <div class="skill-operation-wrap">
                      <div class="skill-operation">
                        <div class="skill-operation-btn" @click="skillAdd(index)">添加</div>
                        <div class="skill-operation-btn" @click="skillClear(index)">删除</div>
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </el-form>
            </div>
          </div>

          <!--工作经验-->
          <div class="work">
            <div class="work-title" style="width: 66px">
              <p class="work-title-l">工作经验</p>
            </div>
            <div class="work-con">
              <el-form
                ref="ruleFormWork"
                :model="form"
                :rules="rules"
                class="demo-ruleForm form-rules-show"
              >
                <el-row class="work-con-row" v-for="(item,index) in form.workForm" :key="index">
                  <el-col :span="24">
                    <el-row class="work-con-box">
                      <el-col class="basic-con-col" :span="14">
                        <div class="basic-con-col-name">
                          <span class="required">时间</span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item
                            :prop="'workForm.'+index+'.workTimeStart'"
                            :rules="rules.workTimeStart"
                          >
                            <el-date-picker
                              v-model="item.workTimeStart"
                              type="date"
                              placeholder="选择日期"
                            ></el-date-picker>-
                            <el-date-picker
                              v-model="item.workTimeEnd"
                              type="date"
                              placeholder="选择日期"
                            ></el-date-picker>
                          </el-form-item>
                        </div>
                      </el-col>
                      <el-col class="basic-con-col" :span="10">
                        <div class="basic-con-col-name">
                          <span class="required">工作单位</span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item :prop="'workForm.'+index+'.company'" :rules="rules.company">
                            <el-input class="con-input" v-model="item.company"></el-input>
                          </el-form-item>
                        </div>
                      </el-col>
                    </el-row>
                    <el-row class="work-con-box">
                      <el-col class="basic-con-col basic-con-col-textarea" :span="24">
                        <div class="basic-con-col-name">
                          <span></span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item>
                            <el-input
                              class="con-textarea"
                              type="textarea"
                              placeholder="请输入内容"
                              v-model="item.textarea"
                              maxlength="50"
                              show-word-limit
                            ></el-input>
                          </el-form-item>
                        </div>
                      </el-col>
                    </el-row>
                  </el-col>
                  <el-col :span="24">
                    <div class="work-operation-wrap">
                      <div class="work-operation">
                        <div class="work-operation-btn" @click="workAdd(index)">添加</div>
                        <div class="work-operation-btn" @click="workClear(index)">删除</div>
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </el-form>
            </div>
          </div>

          <!--项目经验-->
          <div class="work">
            <div class="work-title" style="width: 66px">
              <p class="work-title-l">项目经验</p>
            </div>
            <div class="work-con">
              <el-form
                ref="ruleFormProject"
                :model="form"
                :rules="rules"
                class="demo-ruleForm form-rules-show"
              >
                <el-row class="work-con-row" v-for="(item,index) in form.projectForm" :key="index">
                  <el-col :span="24">
                    <el-row class="work-con-box">
                      <el-col class="basic-con-col" :span="14">
                        <div class="basic-con-col-name">
                          <span class="required">时间</span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item
                            :prop="'projectForm.'+index+'.projectTimeStart'"
                            :rules="rules.projectTimeStart"
                          >
                            <el-date-picker
                              v-model="item.projectTimeStart"
                              type="date"
                              placeholder="选择日期"
                            ></el-date-picker>-
                            <el-date-picker
                              v-model="item.projectTimeEnd"
                              type="date"
                              placeholder="选择日期"
                            ></el-date-picker>
                          </el-form-item>
                        </div>
                      </el-col>
                      <el-col class="basic-con-col" :span="10">
                        <div class="basic-con-col-name">
                          <span class="required">工作单位</span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item
                            :prop="'projectForm.'+index+'.projectName'"
                            :rules="rules.projectName"
                          >
                            <el-input class="con-input" v-model="item.projectName"></el-input>
                          </el-form-item>
                        </div>
                      </el-col>
                    </el-row>
                    <el-row class="work-con-box">
                      <el-col class="basic-con-col basic-con-col-textarea" :span="24">
                        <div class="basic-con-col-name">
                          <span></span>
                        </div>
                        <div class="basic-con-col-r">
                          <el-form-item>
                            <el-input
                              class="con-textarea"
                              type="textarea"
                              placeholder="请输入内容"
                              v-model="item.textarea"
                              maxlength="50"
                              show-word-limit
                            ></el-input>
                          </el-form-item>
                        </div>
                      </el-col>
                    </el-row>
                  </el-col>
                  <el-col :span="24">
                    <div class="work-operation-wrap">
                      <div class="work-operation">
                        <div class="work-operation-btn" @click="projectAdd(index)">添加</div>
                        <div class="work-operation-btn" @click="projectClear(index)">删除</div>
                      </div>
                    </div>
                  </el-col>
                </el-row>
              </el-form>
            </div>
          </div>

          <!--教育/培训经历-->
          <div class="education">
            <div class="education-title">
              <p class="education-title-l">教育/培训经历</p>
            </div>
            <div class="education-con">
              <el-row class="education-con-row">
                <el-col :span="24">
                  <el-row class="education-con-box">
                    <el-col class="basic-con-col" :span="14">
                      <div class="basic-con-col-name">
                        <span class="required">时间</span>
                      </div>
                      <div class="basic-con-col-r">
                        <el-form-item prop="educationFrom.educationTimeStart">
                          <el-date-picker
                            v-model="form.educationFrom.educationTimeStart"
                            type="date"
                            placeholder="选择日期"
                          ></el-date-picker>-
                          <el-date-picker
                            v-model="form.educationFrom.educationTimeEnd"
                            type="date"
                            placeholder="选择日期"
                          ></el-date-picker>
                        </el-form-item>
                      </div>
                    </el-col>
                    <el-col class="basic-con-col" :span="10">
                      <div class="basic-con-col-name">
                        <span class="required">学校名称</span>
                      </div>
                      <div class="basic-con-col-r">
                        <el-form-item prop="educationFrom.educationName">
                          <el-input class="con-input" v-model="form.educationFrom.educationName"></el-input>
                        </el-form-item>
                      </div>
                    </el-col>
                  </el-row>
                  <el-row class="education-con-box">
                    <el-col class="basic-con-col" :span="14">
                      <div class="basic-con-col-name">
                        <span class="required">学业/学历</span>
                      </div>
                      <div class="basic-con-col-r">
                        <el-form-item prop="educationFrom.education">
                          <el-input class="con-input" v-model="form.educationFrom.education"></el-input>
                        </el-form-item>
                      </div>
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
            </div>
          </div>

          <!--证书-->
          <div class="education">
            <div class="education-title" style="width: 48px">
              <p class="education-title-l">证书</p>
            </div>
            <div class="education-con">
              <el-row class="education-con-row">
                <el-col :span="24">
                  <el-row class="education-con-box">
                    <el-col class="basic-con-col" :span="14">
                      <div class="basic-con-col-name">
                        <span>时间</span>
                      </div>
                      <div class="basic-con-col-r">
                        <el-form-item>
                          <el-date-picker
                            v-model="form.certificateFrom.certificateTimeStart"
                            type="date"
                            placeholder="选择日期"
                          ></el-date-picker>-
                          <el-date-picker
                            v-model="form.certificateFrom.certificateTimeEnd"
                            type="date"
                            placeholder="选择日期"
                          ></el-date-picker>
                        </el-form-item>
                      </div>
                    </el-col>
                    <el-col class="basic-con-col" :span="10">
                      <div class="basic-con-col-name">
                        <span>名称</span>
                      </div>
                      <div class="basic-con-col-r">
                        <el-form-item>
                          <el-input
                            class="con-input"
                            v-model="form.certificateFrom.certificateName"
                          ></el-input>
                        </el-form-item>
                      </div>
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
            </div>
          </div>
        </el-form>

        <!--操作-->
        <div class="operation-wrap">
          <div class="operation-btn" @click="submitForm('ruleForm')">提交</div>
          <div class="operation-btn">预览</div>
          <div class="operation-btn">返回</div>
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
      form: {
        name: "", // 姓名
        sex: "", // 性别
        phone: "", // 手机号
        post: "", // 岗位
        years: "", // 工作年限
        mail: "", // 邮箱
        habitation: "", // 居住地
        expectantly: "", // 期望地
        nativePlace: "", // 籍贯
        birth: "", // 出生日期
        id: "", // 身份证
        evaluate: "", // 自我评价
        other: "", // 其他信息
        dataForm: [
          {
            skill: "", // 技能名称
            usageTime: "", // 使用时间
            degree: "", // 掌握程度
          },
        ],
        workForm: [
          {
            workTimeStart: "", // 开始日期
            workTimeEnd: "", // 结束日期
            company: "", // 工作单位
            textarea: "",
          },
        ],
        projectForm: [
          {
            projectTimeStart: "", // 开始日期
            projectTimeEnd: "", // 结束日期
            projectName: "", // 工作单位
            textarea: "",
          },
        ],
        educationFrom: {
          educationTimeStart: "", // 开始日期
          educationTimeEnd: "", // 结束日期
          educationName: "",
          education: "",
        },
        certificateFrom: {
          certificateTimeStart: "", // 开始日期
          certificateTimeEnd: "", // 结束日期
          certificateName: "",
        },
      },
      // 三级联动
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
      nativePlace: [
        { value: "山东" },
        { value: "北京" },
        { value: "黑龙江" },
        { value: "浙江" },
        { value: "山西" },
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
      skillData: [{ value: "java" }, { value: "js" }, { value: "python" }],
      degreeData: [{ value: "了解" }, { value: "熟悉" }, { value: "熟练" }],
      usageTimeData: [
        { value: "1年" },
        { value: "2年" },
        { value: "3年" },
        { value: "4年" },
        { value: "5年" },
      ],

      // 正则
      rules: {
        name: [{ required: true, message: "请输入客户名称", trigger: "blur" }],
        sex: [{ required: true, message: "请选择性别", trigger: "blur" }],
        phone: [
          { required: true, message: "请输入手机号", trigger: "blur" },
          // { validator: validate('phone') }
        ],
        mail: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        habitation: [
          { required: true, message: "请输入居住地", trigger: "blur" },
        ],
        expectantly: [
          { required: true, message: "请输入期望地", trigger: "blur" },
        ],
        years: [{ required: true, message: "请选择工作年限", trigger: "blur" }],
        post: [{ required: true, message: "请选择岗位", trigger: "blur" }],
        // IT技能
        skill: [{ required: true, message: "请选择技能名称", trigger: "blur" }],
        usageTime: [
          { required: true, message: "请选择使用时间", trigger: "blur" },
        ],
        degree: [
          { required: true, message: "请选择掌握程度", trigger: "blur" },
        ],
        // 工作经验
        workTimeStart: [
          { required: true, message: "请选择使用时间", trigger: "blur" },
        ],
        company: [
          { required: true, message: "请输入工作单位", trigger: "blur" },
        ],
        //
        projectTimeStart: [
          { required: true, message: "请选择使用时间", trigger: "blur" },
        ],
        projectName: [
          { required: true, message: "请输入工作单位", trigger: "blur" },
        ],

        company: [
          { required: true, message: "请输入工作单位", trigger: "blur" },
        ],
        // 教育/培训经历
        "educationFrom.educationTimeStart": [
          { required: true, message: "请选择开始时间", trigger: "blur" },
        ],
        "educationFrom.educationTimeEnd": [
          { required: true, message: "请选择结束时间", trigger: "blur" },
        ],
        "educationFrom.educationName": [
          { required: true, message: "请输入学校名称", trigger: "blur" },
        ],
        "educationFrom.education": [
          { required: true, message: "请输入学历", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    skillAdd(index) {
      let odata = {
        skill: "", // 技能名称
        usageTime: "", // 使用时间
        degree: "", // 掌握程度
      };
      this.form.dataForm.splice(index + 1, 0, odata);
    },
    skillClear(index) {
      if (this.form.dataForm.length <= 1) {
        this.$message({
          message: "最少保留一条",
          type: "warning",
        });
      } else {
        this.form.dataForm.splice(index, 1);
      }
    },

    // 工作经历
    workAdd(index) {
      let odata = {
        workTimeStart: "", // 开始日期
        workTimeEnd: "", // 结束日期
        company: "", // 工作单位
        textarea: "",
      };
      this.form.workForm.splice(index + 1, 0, odata);
    },
    workClear(index) {
      if (this.form.workForm.length <= 1) {
        this.$message({
          message: "最少保留一条",
          type: "warning",
        });
      } else {
        this.form.workForm.splice(index, 1);
      }
    },

    // 项目经历
    projectAdd(index) {
      let odata = {
        projectTimeStart: "", // 开始日期
        projectTimeEnd: "", // 结束日期
        projectName: "", // 项目名称
        textarea: "",
      };
      this.form.projectForm.splice(index + 1, 0, odata);
    },
    projectClear(index) {
      if (this.form.projectForm.length <= 1) {
        this.$message({
          message: "最少保留一条",
          type: "warning",
        });
      } else {
        this.form.projectForm.splice(index, 1);
      }
    },

    // 提交
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        this.$refs["ruleFormSkill"].validate((skill) => {
          this.$refs["ruleFormWork"].validate((work) => {
            this.$refs["ruleFormProject"].validate((project) => {
              if (valid && skill && work && project) {
                console.log(this.form);
              } else {
                this.$message.error("请填写必填项");
                return false;
              }
            });
          });
        });
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
/deep/.el-textarea__inner {
  height: 100%;
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
  .basic {
    width: 100%;
    .basic-con {
      border: 1px solid #d4d4d4;
    }
  }
  .basic-title {
    height: 30px;
    display: flex;
    font-size: 14px;
    font-weight: bold;
    justify-content: space-between;
    .basic-title-l {
      color: #697186;
    }
    .basic-title-r {
      color: #465d66;
      span {
        color: red;
      }
    }
  }
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

  /*it技能*/
  .skill {
    position: relative;
    width: 100%;
    height: auto;
    border: 1px solid #fff;
    box-shadow: 0 0 0 1px #d4d4d4, 0 0 0 5px #fff;
    margin-top: 26px;
    .skill-title {
      position: absolute;
      width: 56px;
      height: 26px;
      text-align: center;
      background: #fff;
      top: -10px;
      left: 5px;
      .skill-title-l {
        color: #6b7089;
        font-size: 14px;
        font-weight: bold;
      }
    }
    .skill-con {
      margin-top: 20px;
      border: 1px solid #d4d4d4;
      .skill-operation-wrap {
        height: 42px;
        .skill-operation {
          float: right;
          margin-top: 10px;
          .skill-operation-btn {
            width: 85px;
            height: 24px;
            line-height: 24px;
            background: #d61a21;
            text-align: center;
            color: #fff;
            float: left;
            cursor: pointer;
            margin-right: 10px;
          }
        }
      }
    }
  }
  .skill-con-row {
    .skill-con-box {
      border-bottom: 1px solid #e9e9e9;
    }
  }

  /*工作经验  项目经验*/
  .work {
    position: relative;
    width: 100%;
    height: auto;
    border: 1px solid #fff;
    box-shadow: 0 0 0 1px #d4d4d4, 0 0 0 5px #fff;
    margin-top: 26px;
    .work-title {
      position: absolute;
      width: 56px;
      height: 26px;
      text-align: center;
      background: #fff;
      top: -10px;
      left: 5px;
      .work-title-l {
        color: #6b7089;
        font-size: 14px;
        font-weight: bold;
      }
    }
    .work-con {
      margin-top: 20px;
      border: 1px solid #d4d4d4;
      .work-operation-wrap {
        height: 42px;
        .work-operation {
          float: right;
          margin-top: 10px;
          .work-operation-btn {
            width: 85px;
            height: 24px;
            line-height: 24px;
            background: #d61a21;
            text-align: center;
            color: #fff;
            float: left;
            cursor: pointer;
            margin-right: 10px;
          }
        }
      }
    }
  }
  .work-con-row {
    .work-con-box {
      border-bottom: 1px solid #e9e9e9;
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
    }
  }

  /*教育/培训经历*/
  .education {
    position: relative;
    width: 100%;
    height: auto;
    border: 1px solid #fff;
    box-shadow: 0 0 0 1px #d4d4d4, 0 0 0 5px #fff;
    margin-top: 26px;
    .education-title {
      position: absolute;
      width: 100px;
      height: 26px;
      text-align: center;
      background: #fff;
      top: -10px;
      left: 5px;
      .education-title-l {
        color: #6b7089;
        font-size: 14px;
        font-weight: bold;
      }
    }
    .education-con {
      margin-top: 20px;
      border: 1px solid #d4d4d4;
      .education-operation-wrap {
        height: 42px;
        .education-operation {
          float: right;
          margin-top: 10px;
          .education-operation-btn {
            width: 85px;
            height: 24px;
            line-height: 24px;
            background: #d61a21;
            text-align: center;
            color: #fff;
            float: left;
            cursor: pointer;
            margin-right: 10px;
          }
        }
      }
    }
  }
  .education-con-row {
    .education-con-box {
      border-bottom: 1px solid #e9e9e9;
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
    }
  }

  /*操作*/
  .operation-wrap {
    width: 100%;
    margin-top: 10px;
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
/deep/.el-form-item__content {
  line-height: 34px;
}
/deep/.el-form-item__error {
  display: none;
}
/deep/.el-scrollbar__wrap {
  height: calc(100vh - 182px);
}
</style>
