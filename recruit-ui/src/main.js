import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import "@/style/index.less";
import '@/permission'


let echarts = require('echarts/lib/echarts');
require('echarts/lib/chart/line')
require('echarts/lib/chart/bar')
require('echarts/lib/chart/radar')
// 下面的是需要的提示框
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')
require('echarts/lib/component/legend')
//vue全局注入echarts
Vue.prototype.$echarts = echarts

// 自定义公共组件
import Sir from '@/components/common'
Vue.use(Sir)

// ElementUI
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
Vue.use(ElementUI);

Vue.config.productionTip = false

import api from "@/api/index.js"; // api 请求接口
// 绑定在原型上
Vue.prototype.$api = api;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
