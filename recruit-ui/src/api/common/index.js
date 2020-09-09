import http from "@/utils/request";

const apis = {
  // 获取信息
  getInfo(data) {
    return http.get({
      url: "/get",
      data: data,
      // typea:1
    });
  },
  // 登录
  login(data) {
    return http.post({
      url: "/login",
      data: Object.assign(data),
      typea: 1
    });
  }
};

export default apis;
