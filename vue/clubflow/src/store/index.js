import { createStore } from 'vuex'

export default createStore({
  state: {
    UserId: window.localStorage.getItem('UserId') == null ? '' : JSON.parse(window.localStorage.getItem('UserId' || '[]')),
    //Role: ,
  },
  getters: {
  },
  mutations: {
    login (state, UserId) {
      state.UserId = UserId
      window.localStorage.setItem('UserId', JSON.stringify(UserId))
    },
    initAccount(state,UserId) {
      state.UserId=UserId
    }
  },
  actions: {
  },
  modules: {
  }
})
