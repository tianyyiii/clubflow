import { createStore } from 'vuex'

export default createStore({
  state: {
    UserId: window.localStorage.getItem('UserId') == null ? '' : JSON.parse(window.localStorage.getItem('UserId' || '[]')),
    Role: window.localStorage.getItem('Role') == null ? 0 : JSON.parse(window.localStorage.getItem('UserId' || '[]')),
    // role: 1 -- admin开发人员,   2 -- official account社团管理,   3 -- common user普通用户,   4 -- black user
  },
  getters: {
  },
  mutations: {
    login (state, UserId, Role) {
      state.UserId = UserId
      state.Role = Role
      window.localStorage.setItem('UserId', JSON.stringify(UserId))
      window.localStorage.setItem('Role', Role)
    },
    initAccount(state,UserId) {
      state.UserId=UserId
    },
    logout (state) {
      // 注意不能用 null 清除，否则将无法判断 user 里具体的内容
      state.UserId = ''
      window.localStorage.removeItem('UserId')
      state.Role = 0
      window.localStorage.removeItem('Role')
    }
  },
  actions: {
  },
  modules: {
  }
})
