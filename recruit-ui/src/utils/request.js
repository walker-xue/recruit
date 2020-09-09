"use strict";
import QS from "qs";
import Axios from "axios";
import store from "@/store/index";
import { MessageBox } from "element-ui";

// http request 拦截器
Axios.interceptors.request.use(
  config => {
    // console.log('当前环境变量',process.env.VUE_APP_ENV)
    // console.log('当前环境地址',process.env.VUE_APP_URL)
    config.baseURL = process.env.VUE_APP_URL;
    if (!config["params"]) {
      config["params"] = {};
    }
    config.params["token"] = store.state.user.token;
    config.headers["AUTHORIZATION"] = store.state.user.token;
    return config;
  },
  err => {
    return Promise.reject(err);
  }
);

// 添加响应拦截器
Axios.interceptors.response.use(
  res => {
    // 对响应数据做点什么
    console.log('响应',res)
    switch (res.data.code) {
      case 200:
        return res.data;
      case 402:
        MessageBox.confirm(
          `${res.data.msg}，可以取消继续留在该页面，或者重新登录`,
          "确定登出",
          {
            confirmButtonText: "重新登录",
            cancelButtonText: "取消",
            type: "warning"
          }
        ).then(() => {
          location.reload(); // 为了重新实例化vue-router对象 避免bug
        });
        break;
      case undefined:
        return res;
      default:
        return res.data;
    }
  },
  error => {
    console.log('aaaa')
    // 如果需要通过服务端返回的数据在组件内进行判定，
    // 由于拦截器是reject的错误，并不能在组件中读取err信息，可以改reject为 resolve 并且返回err.response
    // 对响应错误做点什么
    let code = error.response.status; // 获取错误状态码
    let msg = error.response.data.msg; // 获取提示信息
    switch (code) {
      case 401:
        MessageBox.confirm(
          `${msg}，可以取消继续留在该页面，或者重新登录`,
          "确定登出",
          {
            confirmButtonText: "重新登录",
            cancelButtonText: "取消",
            type: "warning"
          }
        ).then(() => {
          location.reload(); // 为了重新实例化vue-router对象 避免bug
        });
        break;
      case undefined:
        return Promise.reject(error);
      default:
        return Promise.reject(error);
    }
  }
);
export default {
  get: option => {
    var options = {
      url: option.url,
      timeout: 10000,
      method: option.method || "get",
      params: option.data || {},
      success: option.succ || function() {},
      error: option.error || function() {}
    };
    return Axios.request(options);
  },
  post: option => {
    var options = {
      url: option.url,
      timeout: 1000000,
      headers: {
        "Content-Type": "application/x-www-form-urlencoded; charset=utf-8"
      },
      method: option.method || "post",
      data: option.data,
      success: option.succ || function() {},
      error: option.error || function() {}
    };
    if (option.data && option.typea == 1) {
      options.headers["content-Type"] = "application/json;charset=utf-8";
      options.beforeSend = function(xhr) {
        xhr.setRequestHeader("Test", "testheadervalue");
      };
    } else if (option.data && option.typeb == "excel") {
      options.responseType = "blob";
      options.data = QS.stringify(options.data);
    } else if (option.data && option.typea == 2) {
      options.headers["content-Type"] = "multipart/form-data";
    } else {
      options.data = QS.stringify(options.data);
    }
    return Axios.request(options);
  },
  delete: option => {
    var options = {
      url: option.url,
      timeout: 10000,
      method: option.method || "delete",
      params: option.data || {},
      success: option.succ || function() {},
      error: option.error || function() {}
    };
    return Axios.request(options);
  },
  put: option => {
    var options = {
      url: option.url,
      timeout: 10000,
      headers: {
        "Content-Type": "application/x-www-form-urlencoded; charset=utf-8"
      },
      method: option.method || "PUT",
      params: option.data || {},
      success: option.succ || function() {},
      error: option.error || function() {}
    };
    if (option.data && option.typea == 1) {
      options.headers["content-Type"] = "application/json;charset=utf-8";
      options.data = QS.stringify(options.data);
    }
    return Axios.request(options);
  }
};
