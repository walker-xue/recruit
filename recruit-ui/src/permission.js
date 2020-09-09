import router from './router/index.js'
// import store from './store'
import { getStorage } from '@/utils/auth' // get token from cookie

const whiteList = ['/login'] // 不重定向白名单

router.beforeEach(async (to, from, next) => {
  if (getStorage('token')) {
    console.log('有token',getStorage('token'))
    if (to.path === '/login') {
      next({ path: '/pendingMatters' })
    } else {
      // await store.dispatch('GetInfo')
      next()
    }
  } else {
    console.log('无token')
    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next(`/login`) // 否则全部重定向到登录页
    }
  }
})
