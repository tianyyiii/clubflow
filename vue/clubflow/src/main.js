import {createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// import './common/initHTMLeditor.js'


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
app.config.globalProperties.$axios = axios
app.config.globalProperties.$Baseurl = BASE_URL //全局变量

// 在访问每一个路由前调用
router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {
      if (String(store.state.UserId)) {
        next()
      } else {
        // console.log("转到别的页面")
        // console.log(store.state.UserId)
        next({
          path: 'login',
          query: {redirect: to.fullPath}
        })
      }
    } else {
      next()
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

// import VueHtml5Editor from 'vue-html5-editor'
const opt = {
    // 全局组件名称，使用new VueHtml5Editor(options)时该选项无效
    name: "vue-html5-editor",
    // 是否显示模块名称，开启的话会在工具栏的图标后台直接显示名称
    showModuleName: true,
    // 自定义各个图标的class，默认使用的是font-awesome提供的图标
    icons: {
      text: "fa fa-pencil",
      color: "fa fa-paint-brush",
      font: "fa fa-font",
      align: "fa fa-align-justify",
      list: "fa fa-list",
      link: "fa fa-chain",
      unlink: "fa fa-chain-broken",
      tabulation: "fa fa-table",
      image: "fa fa-file-image-o",
      hr: "fa fa-minus",
      eraser: "fa fa-eraser",
      undo: "fa-undo fa",
      "full-screen": "fa fa-arrows-alt",
      info: "fa fa-info",
    },
    // 配置图片模块
    image: {
      // 文件最大体积，单位字节
      sizeLimit: 512 * 1024 * 10,
      // 上传参数,默认把图片转为base64而不上传
      // upload config,default null and convert image to base64
      upload: {
        url:null,
        headers:{},
        params: {},
        fieldName:{}
      },
      // 压缩参数,默认使用localResizeIMG进行压缩,设置为null禁止压缩
      // width和height是文件的最大宽高
      compress: {
        width: 600,
        height: 600,
        quality: 80
      },
      // 响应数据处理,最终返回图片链接
      uploadHandler(responseText){
//      default accept json data like  {ok:false,msg:"unexpected"} or {ok:true,data:"image url"}
        var json = JSON.parse(responseText);
                if(json.status == 200){
                    return json.data
                }else{
                    alert(json.error)
                }
      }
    },
    // 语言，内建的有英文（en-us）和中文（zh-cn）
    language: "zh-cn",
    // 自定义语言
    i18n: {
      "zh-cn": {
        "align": "对齐方式",
        "image": "图片",
        "list": "列表",
        "link": "链接",
        "unlink": "去除链接",
        "table": "表格",
        "font": "文字",
        "full screen": "全屏",
        "text": "排版",
        "eraser": "格式清除",
        "info": "关于",
        "color": "颜色",
        "please enter a url": "请输入地址",
        "create link": "创建链接",
        "bold": "加粗",
        "italic": "倾斜",
        "underline": "下划线",
        "strike through": "删除线",
        "subscript": "上标",
        "superscript": "下标",
        "heading": "标题",
        "font name": "字体",
        "font size": "文字大小",
        "left justify": "左对齐",
        "center justify": "居中",
        "right justify": "右对齐",
        "ordered list": "有序列表",
        "unordered list": "无序列表",
        "fore color": "前景色",
        "background color": "背景色",
        "row count": "行数",
        "column count": "列数",
        "save": "确定",
        "upload": "上传",
        "progress": "进度",
        "unknown": "未知",
        "please wait": "请稍等",
        "error": "错误",
        "abort": "中断",
        "reset": "重置"
      }
    },
    // 隐藏不想要显示出来的模块
    hiddenModules: [],
    // 自定义要显示的模块，并控制顺序
    visibleModules: [
//    "text",
//    "color",
      "font",
      "align",
//    "list",
//    "link",
//    "unlink",
//    "tabulation",
      "image",
//    "hr",
//    "eraser",
      "undo",
//    "full-screen",
//    "info",
    ],
    // 扩展模块，具体可以参考examples或查看源码
    // extended modules
    modules: {
      //omit,reference to source code of build-in modules
    }
  };

// app.use(VueHtml5Editor, opt)

// 全局引入 富文本编辑器
// import { QuillEditor } from '@vueup/vue-quill'
// import '@vueup/vue-quill/dist/vue-quill.snow.css'
// import '@vueup/vue-quill/dist/vue-quill.bubble.css'
// app.component('QuillEditor', QuillEditor)
app.mount('#app')
