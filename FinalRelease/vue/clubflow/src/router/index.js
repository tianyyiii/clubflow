import { createRouter, createWebHistory } from 'vue-router'
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
        component: () => import('../components/club/ClubIndex.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'index', // 分类
        }
      },
      {
        path: '/clubspace',
        name: 'ClubSpace', // 社团社区广场（列出所有的社团社区）
        component: () => import('../components/club/ClubSpace.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'club',
        }
      },
      {
        path: '/searchclub',
        name: 'SearchClub', // 社团搜索结果
        component: () => import('../components/club/SearchResult.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'club',
        }
      },
      {
        path: '/searchhabbit',
        name: 'SearchHabbit', // 爱好搜索结果
        component: () => import('../components/habbit/SearchResult.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'habbit',
        }
      },
      {
        path: '/habbitspace',
        name: 'HabbitSpace', // 爱好社区广场（列出所有的爱好社区）
        component: () => import('../components/habbit/HabbitSpace.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'habbit',
        }
      },
      {
        path: '/postdetails',
        name: 'PostDetails', // 内容详情页
        component: () => import('../components/post/PostDetails.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'club',
        }
      },
      {
        path: '/searchpost',
        name: 'SearchPost', // 文章搜索结果
        component: () => import('../components/post/SearchResult.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'club',
        }
      },
      {
        path: '/habbit',
        name: 'HabbitContent', // 爱好社区详情页
        component: () => import('../components/habbit/HabbitContent.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'habbit',
        }
      },
      {
        path: '/createhabbit',
        name: 'CreateHabbit', // 创建爱好社区编辑页
        component: () => import('../components/habbit/CreateHabbit.vue'),
        meta: {
          requireAuth: true, // 需要登录
          requireClub: 2, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'habbit',
        }
      },
      {
        path: '/createclub',
        name: 'Createlub', // 创建社团编辑页
        component: () => import('../components/club/CreateClub.vue'),
        meta: {
          requireAuth: true, // 需要登录
          requireClub: 1, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'club',
        }
      },
      {
        path: '/clubeditpage',
        name: 'ClubEditPage', // 社团个人主页(社团管理员的编辑页面)
        component: () => import('../components/club/ClubEditPage.vue'),
        meta: {
          requireAuth: true, // 需要登录
          requireClub: 1, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'club',
        }
      },
      {
        path: '/clubhome',
        name: 'ClubHome', // 社团内容页(展示，所有人可见)
        component: () => import('../components/club/ClubHome.vue'),
        meta: {
          requireAuth: false, // 不需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'club',
        }
      },
      {
        path: '/userhome',
        name: 'UserHome', // 普通用户个人主页
        component: () => import('../components/user/UserHome.vue'),
        meta: {
          requireAuth: true, // 需要登录
          requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
          class: 'else',
        }
      }

    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../components/Login.vue'),
    meta: {
      requireAuth: false, // 不需要登录
      requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
    }
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../components/Register.vue'),
    meta: {
      requireAuth: false, // 不需要登录
      requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
    }
  },
  {
    path: '/errornotoff',
    name: 'ErrorNotOff',
    component: () => import('../components/pages/ErrorNotOff.vue'),
    meta: {
      requireAuth: false, // 不需要登录
      requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
    }
  },
  {
    path: '/upimage',
    name: 'UpImage',
    component: () => import('../components/common/UpImage.vue'),
    meta: {
      requireAuth: false, // 不需要登录
      requireClub: 0, // 1 => 需要社团管理员操作 ;  2 => 需要非社团管理员操作  ;  0 => 没有要求
    }
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
