import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Home from '../components/Home'

const routes = [
  // {
  //   path: '/',
  //   name: 'home',
  //   component: HomeView
  // },
  {
    path: '/',
    name: 'Default',
    redirect: '/home',
    component: Home
  },
  {
    // home页面并不需要被访问，只是作为其它组件的父组件
    path: '/home',
    name: 'Home',
    component: Home,
    redirect: '/index',
    children: [
      {
        path: '/index',
        name: 'ClubIndex', // 社团社区首页
        component: () => import('../components/club/ClubIndex'),
        meta: {
          requireAuth: false
        }
      },
      {
        path: '/postdetails',
        name: 'PostDetails', // 内容详情页
        component: () => import('../components/post/PostDetails.vue')
      },
      {
        path: '/habbit',
        name: 'HabbitContent', // 内容详情页
        component: () => import('../components/habbit/HabbitContent.vue')
      }

    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../components/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../components/Register.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
