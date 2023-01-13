<template>
    <!-- 导航栏 -->
    <nav class="navbar navbar-expand-sm p-0">
        <!-- <ul class="navbar-nav"> -->
        <ul id="Nav" class="nav col-12 col-md-4 d-flex me-auto">
            <li class="nav-item" :class="{ 'active': MyClass.index }">
              <router-link to="/index" class="nav-link text-light">首页</router-link>
            </li>
            <!-- Dropdown -->
            <li class="nav-item dropdown" :class="{ 'active': MyClass.club }">
                <router-link to="/clubspace" class="nav-link text-light" id="navbardrop">
                社团社区
                </router-link>
                <ul class="dropdown-menu" style="border-radius: 2%; visibility: hidden;display: block">
                    <li>
                        <a class="dropdown-item d-flex gap-2 align-items-center" href="#">
                            <img id="u177_img" class="img " src="@/assets/images/shetuanshequ_index/u184.png"/>
                            思想政治
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item d-flex gap-2 align-items-center" href="#">
                            <img class="img " src="@/assets/images/shetuanshequ_index/u184.png"/>
                            公益服务
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item d-flex gap-2 align-items-center" href="#">
                            <img class="img " src="@/assets/images/shetuanshequ_index/u184.png"/>
                            文化艺术
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item d-flex gap-2 align-items-center" href="#">
                            <img class="img " src="@/assets/images/shetuanshequ_index/u184.png"/>
                            学术科技
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item d-flex gap-2 align-items-center" href="#">
                            <img class="img " src="@/assets/images/shetuanshequ_index/u184.png"/>
                            文化体育
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item d-flex gap-2 align-items-center" href="#">
                            <img class="img " src="@/assets/images/shetuanshequ_index/u184.png"/>
                            实践能力
                        </a>
                    </li>
                    <li><hr class="dropdown-divider"></li>
                    <li>
                        <a class="dropdown-item d-flex gap-2 align-items-center" href="#">
                            <img class="img " src="@/assets/images/shetuanshequ_index/说明_u177.svg"/>
                            社团名录
                        </a>
                    </li>
                </ul>
            </li>
            <li class="nav-item" :class="{ 'active': MyClass.habbit }">
              <router-link to="/habbitspace" class="nav-link text-light" href="#">爱好社区</router-link>
            </li>
            <li class="nav-item" :class="{ 'active': MyClass.else }">
              <a class="nav-link text-light disabled" href="#">其他</a>
            </li>
        </ul>




        <form form @submit.prevent="search">
            <div class="search-box me-4">
                <input v-model="search_text" type="text" class="search-txt" placeholder="请输入搜索的文章..." />
                <button type="submit" class="search-btn">
                    <i class="fa fa-search" aria-hidden="true"></i>
                </button>
            </div>
        </form>
        
        <!-- 登录头像 -->
        <span class="pe-5 dropdown">
            <button @click="LoginOrJump" class="image-button">
                <i class="fa fa-user-o" aria-hidden="true"></i>
            </button>
            <button v-if="IsLogin" @click="logout" class="image-button ms-3">
                <i class="fa fa-sign-out" aria-hidden="true"></i>
            </button>
        </span>

        
        
    </nav>
</template>

<script>
import store from '@/store/index.js'
import { useRoute } from 'vue-router';
import { watch,reactive } from 'vue';
 
export default {
    name: 'NavMenu',
    components: [],
    data: function () {
      return {
        IsLogin:false,
        MyClass:reactive({
            index:true,
            club:false,
            habbit:false,
            else:false,
        }),
        search_text:'',
      }
    },
    created:function(){
        if (String(store.state.UserId)){
            this.IsLogin=true
        }
    },
    methods:{
        LoginOrJump(){
            if(this.IsLogin){
                this.$router.push('/userhome')
            }else{
                this.$router.push('/login')
            }
        },
        logout(){
            this.$store.commit('logout')
            alert("已退出登录！")
            this.$router.push('/login')
        },
        search(){
            this.$router.push({path:'/searchpost',query:{key:this.search_text, t: +new Date()}})
        }
    },
    mounted:function(){
        $("#Nav .dropdown").mouseenter(function(){
            var top=$("#Nav .nav-link").offset().top+$("#Nav .nav-link").height(); 
            var left=$("#Nav .nav-item").offset().left;

            // console.log(left);
            // console.log(top);
            $("#Nav .dropdown-menu").css({"visibility": "visible","top":top*2, "left":left-10});
            
            $("Nav .dropdown-menu").show();
        });
        $("#Nav .dropdown").mouseleave(function(){
            $("#Nav .dropdown-menu").css({"visibility": "hidden"});
            $("#Nav .dropdown-menu").hide();
        });

        if(this.IsLogin){

        }
        // 获取当前页面的路径
        let router = useRoute()
        watch(router,(newValue, oldValue) => {
                if(newValue.meta.class!=undefined){
                    var x
                    for (x in this.MyClass)
                    {
                        this.MyClass[x] = false;
                    }
                    switch(newValue.meta.class)
                    {
                        case 'index':
                            this.MyClass.index=true;
                            // console.log(this.MyClass.index);
                            // console.log(this.MyClass.club)
                            break;
                        case 'club':
                            this.MyClass.club=true;
                            break;
                        case 'habbit':
                            this.MyClass.habbit=true;
                            break;
                        case 'else':
                            this.MyClass.else=true;
                            break;
                        default:this.MyClass.else=true;
                    }
                }
            },
            { immediate: true }
            );
    }
  }


</script>

<style scoped>

/* 导航栏 */
.navbar{
    background-color: var(--themecolor);
}
.nav-item {
  height:54px;
  margin-left: 2%;
  width: 20%;
  display: flex;
  background-color:var(--themecolor);
  box-sizing:border-box;
  border-width:5px;
  border-style:solid;
  border-color:var(--darkerthemecolor);
  border-left:0px;
  border-top:0px;
  border-right:0px;
  align-items: center;
  justify-content: center;
  font-family:'微软雅黑', sans-serif;
  font-weight:400;
  font-style:normal;
  font-size:14px;
  color:#F7F1F1;
  text-align: center;
}
.nav-item.active {
    border-color:var(--activecolor);
}
.nav-item:hover {
  border-color:var(--activecolor);
}
.dropdown-menu {
  background-color: var(--greycolor);
  border-radius:0px;
}
.dropdown-menu-2 {
  background-color: var(--greycolor);
  border-radius:0px;
}
.dropdown-item {
    border-width:0px;
    width:177px;
    height:40px;
    display:flex;
    font-size:14px;
    color:#000000;
    text-align:left;
}
.dropdown-item:hover {
    border: var(--themecolor);
    border-width:5px;
    border-style:solid;
    border-bottom:0px;
    border-top:0px;
    border-right:0px;
}
.image-button {
    color: var(--darkerthemecolor);
    font-size: 15pt;
}
.image-button:hover {
    color: white;
}


.search-box{
background-color: #2f3640;
border-radius: 40px;
}
.search-txt{
border:none;
background: none;
outline: none;
/* float: left; */
padding: 0;
color: #fff;
font-size: 15px;
line-height: 40px;
width: 0;
/* 动画过渡 */
transition: 0.4s;
}
.search-btn{
color: #e84118;
float: right;
width: 40px;
height: 40px;
border-radius: 50%;
background-color: #2f3640;
/* 弹性布局 水平垂直居中 */
display: flex;
justify-content: center;
align-items: center;
cursor: pointer;
/* 动画过渡 */
transition: 0.4s;
}
.search-box:hover .search-txt{
width: 200px;
padding: 0 6px;
}
.search-box:hover .search-btn{
background-color: #fff;
}


/* 导航栏结束 */
</style>