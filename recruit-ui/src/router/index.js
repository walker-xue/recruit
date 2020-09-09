import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
import Layout from '@/Layout/index'

const routes = [
  {
    path: "/login", // 登录
    leftNavType: "login",
    name: "login",
    component: () => import("@/views/Login/index")
  },
  {
    path: "/",
    name: "layout",
    redirect:'/pendingMatters',
    component:resolve=>require(['@/Layout/index.vue'],resolve),
    children: [
      // 待处理事项
      {
        path:'/pendingMatters',
        name:'PendingMatters',
        component:resolve=>require(['@/views/PendingMatters/index.vue'],resolve),
        meta: { title: '待处理事项', icon: 'table' }
      },
      // 导入简历
      {
        path:'/importResume',
        name:'ImportResume',
        component:resolve=>require(['@/views/ImportResume/index.vue'],resolve),
        meta: { title: '导入简历', icon: 'table' }
      },
      // 简历库
      {
        path:'/resumeLibrary',
        name:'ResumeLibrary',
        component:resolve=>require(['@/views/ResumeLibrary/index.vue'],resolve),
        meta: { title: '简历库', icon: 'table' },
      },
      // 应聘人员
      {
        path:'/candidates',
        name:'Candidates',
        component:resolve=>require(['@/views/Candidates/index.vue'],resolve),
        meta: { title: '应聘人员', icon: 'table' },
      },
      // 需求管理
      {
        path:'/demandManagement',
        name:'DemandManagement',
        component:resolve=>require(['@/views/DemandManagement/index.vue'],resolve),
        redirect: '/demandManagement/demandQuery',
        meta: { title: '需求管理', icon: 'table' },
        children: [
          {
            path:'/demandManagement/demandQuery',
            name:'DemandQuery',
            component:resolve=>require(['@/views/DemandManagement/DemandQuery/index.vue'],resolve),
            meta: { title: '需求查询', icon: 'table' ,open: false},
          },
          {
            path:'/demandManagement/demandRelease',
            name:'DemandRelease',
            component:resolve=>require(['@/views/DemandManagement/DemandRelease/index.vue'],resolve),
            meta: { title: '需求发布', icon: 'table' },
          },
        ]
      },
      // 需求审批
      {
        path:'/requirementApproval',
        name:'RequirementApproval',
        component:resolve=>require(['@/views/RequirementApproval/index.vue'],resolve),
        meta: { title: '需求审批', icon: 'table' },
      },
      // 数据统计
      {
        path:'/dataStatistics',
        name:'DataStatistics',
        component: resolve=>require(['@/views/DataStatistics/index.vue'],resolve),
        redirect: '/dataStatistics/businessRequirements',
        meta: { title: '数据统计', icon: 'table' ,open: false},
        children: [
          {
            path:'/dataStatistics/businessRequirements',
            name:'BusinessRequirements',
            component:resolve=>require(['@/views/DataStatistics/BusinessRequirements/index.vue'],resolve),
            meta: { title: '业务需求', icon: 'table' },
          },
          {
            path:'/dataStatistics/recruitmentConsultant',
            name:'RecruitmentConsultant',
            component:resolve=>require(['@/views/DataStatistics/RecruitmentConsultant/index.vue'],resolve),
            meta: { title: '招聘顾问', icon: 'table' },
          },
        ]
      },
      // 用户管理
      {
        path:'/userManagement',
        name:'UserManagement',
        component:resolve=>require(['@/views/UserManagement/index.vue'],resolve),
        meta: { title: '用户管理', icon: 'table' },
      },

      // 需求详情
      {
        path:'/demanddetails',
        name:'DemandDetails',
        component:resolve=>require(['@/views/DemandDetails/index.vue'],resolve),
        meta: { title: '需求详情', icon: 'table', hide: true },
      },
      // 用户详情
      {
        path:'/information',
        name:'Information',
        component:resolve=>require(['@/views/UserManagement/Information/index.vue'],resolve),
        meta: { title: '用户详情', icon: 'table', hide: true },
      },
      // 简历详情
      {
        path:'/details',
        name:'Details',
        component:resolve=>require(['@/views/ResumeLibrary/Details/index.vue'],resolve),
        meta: { title: '简历详情', icon: 'table', hide: true },
      },
      // 面试信息
      {
        path:'/interview',
        name:'Interview',
        component:resolve=>require(['@/views/Interview/index.vue'],resolve),
        meta: { title: '面试信息', icon: 'table', hide: true },
      },
    ],
  } 
 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  linkActiveClass:'active',
  routes,
  scrollBehavior(to, from, savedPosition) { //页面切换回到顶部
    if (savedPosition) {
      return savedPosition
    } else {
      return { x: 0, y: 0 }
    }
  }
})

export default router
