import VueRouter from "vue-router"

const router=new VueRouter({
    routes:[
        //配置路由的路径
        {
            path:'/register',
            component: () => import('../register.html')
        }
    ]
})
export default router;