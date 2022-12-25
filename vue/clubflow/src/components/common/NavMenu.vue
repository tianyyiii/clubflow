<template>
    <!-- 导航栏 -->
    <nav id="Nav" class="navbar navbar-expand-sm p-0">
        <!-- <ul class="navbar-nav"> -->
        <ul class="nav col-12 col-md-4 d-flex me-auto">
            <li class="nav-item ">
              <a class="nav-link text-light" href="#">首页</a>
            </li>
             <!-- Dropdown -->
             <li class="nav-item active dropdown">
                <a class="nav-link text-light" href="#" id="navbardrop" data-bs-toggle="dropdown">
                社团社区
                </a>
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
            <li class="nav-item">
              <a class="nav-link text-light" href="#">爱好社区</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-light disabled" href="#">其他</a>
            </li>
        </ul>




        <div class="search-box me-4">
            <input type="text" class="search-txt" placeholder="请输入搜索的内容..." />
            <a href="#" class="search-btn">
                <i class="fa fa-search" aria-hidden="true"></i>
            </a>
        </div>


        <!-- 登录头像 -->
        <span class="pe-5">
            <a class="image-button" href="#">
                <i class="fa fa-user-o" aria-hidden="true"></i>
            </a>
        </span>
        
    </nav>
</template>

<script>
export default {
    name: 'NavMenu',
    components: {},
    data: function () {
      return {}
    },
    created:function(){
    },
    mounted:function(){
      $("#Nav .dropdown").mouseenter(function(){
        var top=$("#Nav .nav-link").offset().top+$("#Nav .nav-link").height(); 
        var left=$("#Nav .nav-item").offset().left;

        console.log(left);
        $("#Nav .dropdown-menu").css({"visibility": "visible","top":top*2, "left":left-10});
        
      $("Nav .dropdown-menu").show();
    });
    $("#Nav .dropdown").mouseleave(function(){
        $("#Nav .dropdown-menu").css({"visibility": "hidden"});
      $("#Nav .dropdown-menu").hide();
    });
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