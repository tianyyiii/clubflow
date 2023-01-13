import {createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'


import $ from 'jquery'
window.jQuery = $
window.$ = $
// Vue.prototype.$=$

// import '@/assets/font/font.css'

import '@/assets/css/global.css'
import '@/assets/fonts/NGlipingshouxie/stylesheet.css'
import '@/assets/fonts/font-awesome-4.7/css/font-awesome.min.css'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'

var axios = require('axios')
const BASE_URL = 'api/'
axios.defaults.baseURL = BASE_URL
// 使请求带上凭证信息
axios.defaults.withCredentials = true


const app=createApp(App)

app.use(store)
app.use(router)
app.use(ElementPlus)
app.config.globalProperties.$axios = axios
app.config.globalProperties.$Baseurl = BASE_URL //全局变量

// 在访问每一个路由前调用
router.beforeEach((to, from, next) => {
    // 登录拦截
    if (to.meta.requireAuth) {
      if (String(store.state.UserId)) {
        //next()
      } else {
        // console.log("转到别的页面")
        // console.log(store.state.UserId)
        next({
          path: 'login',
          query: {redirect: to.fullPath}
        })
      }
    } else {
      //next()
    }

    // 角色拦截  1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
    switch (to.meta.requireClub) {
      // role: 1 -- admin开发人员,   2 -- official account社团管理,   3 -- common user普通用户,   4 -- black user
      case 1:
        if (store.state.Role==2 || store.state.Role==1) {
          next()
        } else {
          // console.log("转到别的页面")
          console.log(store.state.Role)
          console.log(store.state.UserId)
          next({
            path: '/errornotoff',
            query: {redirect: to.fullPath}
          })
        }
        break;
      case 2:
        if (store.state.Role==3 || store.state.Role==1) {
          next()
        } else {
          // console.log("转到别的页面")
          // console.log(store.state.Role)
          next({
            path: '/errornotoff',
            query: {redirect: to.fullPath}
          })
        }
        break;
      default:
        next()
        break;
    }
  }
)

// router.beforeEach((to, from, next) => {
//     if (store.state.username && to.path.startsWith('/admin')) {
//       initAdminMenu(router, store)
//     }
//     if (store.state.username && to.path.startsWith('/login')) {
//       next({
//         name: 'Dashboard'
//       })
//     }
//     // 如果前端没有登录信息则直接拦截，如果有则判断后端是否正常登录（防止构造参数绕过）
//     if (to.meta.requireAuth) {
//       if (store.state.username) {
//         axios.get('/authentication').then(resp => {
//           if (resp) {
//             next()
//           }
//         })
//       } else {
//         next({
//           path: 'login',
//           query: {redirect: to.fullPath}
//         })
//       }
//     } else {
//       next()
//     }
//   }
// )

// 格式化日期
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) :
                (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


// 全局引入 富文本编辑器
// import { QuillEditor } from '@vueup/vue-quill'
// import '@vueup/vue-quill/dist/vue-quill.snow.css'
// import '@vueup/vue-quill/dist/vue-quill.bubble.css'
// app.component('QuillEditor', QuillEditor)
app.mount('#app')
