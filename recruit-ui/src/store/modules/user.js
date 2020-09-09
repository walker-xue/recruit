import { getStorage, setStorage, removeStorage} from '@/utils/auth'

const user = {
  state: {
    token: getStorage('token'),
    name: '',
    userInfo: {},
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
    }
  },

  actions: {
    // 登录
    Login({ commit }, user) {
      console.log('user',user)
      return new Promise((resolve, reject) => {
        let aa = true
        if (aa) {
          commit('SET_TOKEN', user.userInfo.token || '')
          setStorage('token', user.userInfo.token || '');
          resolve()
        } else {
          reject()
        }
      })
    },
    // 登出
    LogOut({ commit }) {
      return new Promise((resolve) => {
        commit('SET_TOKEN', '');
        removeStorage('token');
        resolve();
      });
    }
  }
}

export default user
