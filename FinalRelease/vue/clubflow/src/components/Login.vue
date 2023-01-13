<template>
    <!-- <img src="@/assets/images/index/backimg-1.png" class="backgroundimg"> -->
    <div id="login-page" class="container">
        <img src="@/assets/images/index/backimg-1.png" class="backgroundimg">
        <div class="wrapper">
            <div class="logobacks">
                <!-- 灰色阴影 (矩形) -->
                <div id="u1070" class="shadow">
                    <div id="u1070_div" class=""></div>
                </div>
                <!-- 白色阴影 (矩形) -->
                <div id="u1071" class="box">
                    <img id="u1071_img" class="img " src="@/assets/images/index/u1017.svg"/>
                </div>
                <!-- Unnamed (线) -->
                <div id="u1072" class="line">
                    <img id="u1072_img" class="img " src="@/assets/images/index/u1018.svg"/>
                </div>
                <!-- Unnamed (线) -->
                <div id="u1073" class="line">
                    <img id="u1073_img" class="img " src="@/assets/images/index/u1019.svg"/>
                </div>
                <!-- 英文logo (矩形) -->
                <div id="u1074" class="">
                    <!-- <div id="u1074_div" class=""></div> -->
                    <div id="u1074_text" class="text justify-content-left">
                    <p><span>Clubflow</span></p>
                    </div>
                </div>
                <!-- 红色框 (矩形) -->
                <div id="u1075" class="ax_default box_1">
                    <div id="u1075_div" class=""></div>
                </div>
                <!-- Logo (图片) -->
                <div id="u1077" class="ax_default image1">
                    <img id="u1077_img" class="img " src="@/assets/images/index/logo-ad.png"/>
                </div>
            </div>
            <div class="login-content">
                <div class="form"  >
                    <!-- Unnamed (椭圆形) -->
                    <img id="u1081_img" class="ellipse " src="@/assets/images/index/u1081.svg"/>
                    <!-- 大头像 (矩形) -->
                    <div id="u1082" class="ax_default _默认样式">
                        <div id="u1082_text" class="text ">
                        <p><span></span></p>
                        </div>
                    </div>
                    <!-- 背景框 (矩形) -->
                    <div id="u1084" class="ax_default box_2">
                        <div id="u1084_div" class=""></div>
                        <!-- 登录按钮 (矩形) -->
                        <button v-on:click="login" id="u1086" class="button login">
                            <div id="u1086_div" class="block"></div>
                            <div id="u1086_text" class="text ">
                            <span>登录</span>
                            </div>
                            <!-- 加载图标 (SVG) -->
                            <!-- <div id="u1087" class="ax_default image1 ax_default_hidden" data-label="加载图标" style="display:none; visibility: hidden"> -->
                            <div id="u1087" class="hidden" data-label="加载图标">
                                <img id="u1087_img" class="img " src="@/assets/images/index/加载图标_u1062.svg"/>
                            </div>
                        </button>

                        <!-- 关闭键 (矩形) -->
                        <div id="u1088" class="button close" title="关闭">
                            <div id="u1088_text" class="text ">
                            <p><span></span></p>
                            </div>
                        </div>

                        <!-- Unnamed (矩形) -->
                        <!-- <a href="./register.html" to="/register" id="u1089" class="button text"> -->
                        <router-link to="/register" id="u1089" class="button text">
                            <div id="u1089_text" class="text ">
                            <p><span>首次登录请注册</span></p>
                            </div>
                        </router-link>
                        <!-- </a> -->

                        <!-- Unnamed (矩形) -->
                        <div id="u1090" class="button text">
                            <div id="u1090_text" class="text ">
                            <p><span>忘记密码?</span></p>
                            </div>
                        </div>
                        <!-- 输入框 (文本框) -->
                        <div id="username" class="input_boxes" data-label="输入框">
                            <input v-model="loginForm.username" type="text" placeholder="请输入JAccount账户" class="input text" maxlength="20"/>
                            <i class="fa fa-user-circle" aria-hidden="true"></i>
                        </div>
                        <div id="password" class="input_boxes" data-label="输入框">
                            <input v-model="loginForm.password" type="password" placeholder="请输入登录密码" class="input text" maxlength="20"/>
                            <i class="fa fa-lock" aria-hidden="true"></i>
                        </div>
                        <div id="verifycode" class="input_boxes" data-label="输入框">
                            <input v-model="loginForm.verifycode" type="text" placeholder="验证码" class="input text" maxlength="20"/>
                            <i class="fa fa-shield" aria-hidden="true"></i>
                        </div>
                        <!-- 验证码图片 (图片) -->
                        <div id="u1105" class="verify_image">
                            <img id="u1105_img" class="img " src="@/assets/images/index/u116.png"/>
                        </div>
                        <!-- 复选图标 (矩形) -->
                        <div id="u1103" class="ax_default _默认样式" data-label="复选图标">
                            <input v-model="checked" type="checkbox" class="checkbox">
                            <div id="u1102_text" class="text "><span>记住密码</span></div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default{
    data(){
        return {
        checked: false,
        loginForm: {
          username: '',
          password: '',
          verifycode: ''
        },
        SuccessState:1,
        }
    },
    mounted(){
        // console.log($("#login-page"));
        this.ellipse(); // 控制椭圆形升降
    },
    methods:{
        ellipse(){
            $(".login-content").mouseenter(function(){
                $(".ellipse").animate({top:'-8px'},"slow");
            });
            $(".login-content").mouseleave(function(){
                $(".ellipse").animate({top:'38px'},"slow");
            });
        },
        login () {
            // console.log(this.loginForm.username)
        var _this = this
        if(!this.loginForm.verifycode){
            alert("请填写验证码");
            location.reload();
        }else{
            this.$axios
            .get('/user/check', {params:{
                    UserName: this.loginForm.username,
                    Password: this.loginForm.password
                }})
            .then(resp => {
                if (resp.data.state!=this.SuccessState) {
                    alert("不存在该用户或密码错误！", {confirmButtonText: '确定'});
                    location.reload(); // 刷新当前页面
                //   var data = resp.data.result
                //   _this.$store.commit('login', data)
                //   var path = _this.$route.query.redirect
                //   _this.$router.replace({path: path === '/' || path === undefined ? '/admin/dashboard' : path})
                } else {
                    alert("登录成功")
                    var UserId = resp.data.id
                    var Role = resp.data.role
                    _this.$store.commit('login', {UserId:UserId, Role:Role})
                    // console.log("commit成功")
                    // const store = useStore();
                    console.log(_this.$store.state.UserId);
                    console.log(_this.$store.state.Role);
                    var path = _this.$route.query.redirect
                    // console.log(path)
                    // alert(path)
                    _this.$router.replace({path: (path === '/' || path === undefined) ? '/home' : path})
                
                }
            })
            .catch(failResponse => {})
        }
      }
    }
}


</script>

<style scoped>
*{
    padding: 0;
    margin: 0;
    /* 标准盒子 */
    box-sizing: border-box;
}
.backgroundimg {
    /* position: fixed; */
    position: absolute;
    /* bottom: 0; */
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    /* 让他当作一个背景 */
    z-index: -1;
}
body{
    /* 引入字体 */
    font-family: NGlipingshouxie, sans-serif;
    /* 溢出隐藏 */
    /* display: flex; */
    /* align-items: center; */
    /* justify-content: center; */
    overflow: hidden;
}
.container {
    /* position :absolute; */
    width: 100vw;
    height: 100vh;
    display: flex;
    /* grid-template-columns: repeat(2,1fr); */
    /* grid-gap: 7rem; */
    /* padding: 0 2rem; */
    /* width: 90vw; */
    /* max-width: 900px; */
    /* height: 400px; */
    align-items: center;
    justify-content: center;
    /* 溢出隐藏 */
    overflow: hidden;
}

.wrapper {
    position: relative;
    /* 弹性布局 */
    /* display: flex; */
    /* width: 90vw; */
    width: 51vw;
    /* max-width: 900px; */
    height: 454px;
    /* 溢出隐藏 */
    /* overflow: hidden; */
}
.logobacks {
    position: absolute;
    left:0;
    bottom: 92px;
    height: 190px;
    margin-bottom:10px;
    overflow: visible;
}
#u1070_div {
    border-width:0px;
    position:absolute; 
    /* position:relative; */
    left:0px;
    top:0px;
    width:408px;
    height:172px;
    background:inherit;
    background-color:rgba(224, 222, 222, 1);
    border:none;
    border-radius:0px;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
    box-shadow:none;
}
#u1070 {
    border-width:0px;
    /* position:absolute; */
    position:absolute;
    /* left:0px; */
    left:41px;
    /* top:316px; */
    bottom: 0;
    width:408px;
    height:172px;
    display:flex;
}
#u1071_img {
    border-width:0px;
    position:absolute;
    left:0px;
    top:0px;
    width:718px;
    height:158px;
}
#u1071 {
    border-width:0px;
    /* position:absolute; */
    position:absolute;
    /* left:358px; */
    left:0;
    /* top:301px; */
    top:0;
    width:718px;
    height:158px;
    display:flex;
}
#u1072_img {
    border-width:0px;
    position:absolute;
    left:0px;
    top:0px;
    width:105px;
    height:2px;
}
#u1072 {
    border-width:0px;
    position:absolute;
    /* left:446px; */
    left: 89px;
    /* top:434px; */
    top: 132px;
    width:104px;
    height:1px;
    display:flex;
    -webkit-transform:rotate(0.183344166289117deg);
    -moz-transform:rotate(0.183344166289117deg);
    -ms-transform:rotate(0.183344166289117deg);
    transform:rotate(0.183344166289117deg);
    color:#FFFFFF;
}
#u1073_img {
    border-width:0px;
    position:absolute;
    left:0px;
    top:0px;
    width:79px;
    height:2px;
}
#u1073 {
    border-width:0px;
    position:absolute;
    /* left:727px; */
    left: 372px;
    top: 132px;
    /* top:435px; */
    width:78px;
    height:1px;
    display:flex;
    -webkit-transform:rotate(0.100682103648485deg);
    -moz-transform:rotate(0.100682103648485deg);
    -ms-transform:rotate(0.100682103648485deg);
    transform:rotate(0.100682103648485deg);
    color:#FFFFFF;
}
#u1074 {
    border-width:0px;
    position:absolute;
    /* left:564px; */
    /* top:402px; */
    left: 212px;
    top: 100px;
    width:217px;
    height:50px;
    display:flex;
    justify-content:left;
    /* font-family:'南构丽萍手写 Bold', '南构丽萍手写 Regular', '南构丽萍手写', sans-serif; */
    font-family: NGlipingshouxie, sans-serif;
    font-weight:700;
    font-style:normal;
    font-size:44px;
    color:#FFFFFF;
}

#u1075_div {
    border-width:0px;
    position:absolute;
    left:0px;
    top:0px;
    width:450px;
    height:103px;
    background:inherit;
    background-color:rgba(255, 255, 255, 0);
    box-sizing:border-box;
    border-width:3px;
    border-style:solid;
    border-color:rgba(184, 45, 41, 1);
    border-right:0px;
    border-bottom:0px;
    border-radius:0px;
    border-top-right-radius:0px;
    border-bottom-left-radius:0px;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
    box-shadow:none;
  }
  #u1075 {
    border-width:0px;
    position:absolute;
    /* left:358px; */
    /* top:299px; */
    left: 0;
    top:0;
    width:450px;
    height:103px;
    display:flex;
  }
#u1077 {
    border-width:0px;
    position:absolute;
    /* left:383px; */
    /* top:284px; */
    left: 26px;
    top:6px;
    
    /* width:384px; */
    /* height:191px; */
    height: 74%;
    display:flex;
  }
.footer {
    background-color:rgba(51, 51, 51, 1);
    padding: 10px;
    text-align: center;
    width: 100%;
    height: 80px;
}

.login-content{
    position: relative;
    /* left: 450px; */
    float: right;
    display: flex;
    justify-content: flex-start; 
    align-items: center;
    /* 文字居中 */
    text-align: center;
}
.form{
    width: 296px;
    height: 346px;
}
#u1081_img {
    position: absolute;
    /* left:87px; */
    /* display: flex; */
    top: 38px;
    left: 55px;
    width:186px;
    height:186px;
}


#u1082 {
    border-width:0px;
    position: absolute;
    /* left:133px; */
    /* top:16px; */
    left:101px;
    top: -12px;
    width:94px;
    height:90px;
    /* display:flex; */
    font-family:'FontAwesome', sans-serif;
    font-weight:400;
    font-style:normal;
    font-size:72px;
    color:#CCCCCC;
    padding: 0;
    text-align: center;
}

#u1084_div {
    border-width:0px;
    position:absolute;
    left:0px;
    top:0px;
    width:296px;
    height:326px;
    background:inherit;
    background-color:rgba(242, 242, 242, 1);
    
    /* background-color:rgb(232, 246, 246); */
    /* background-color: rgb(224, 217, 209); */
    /* background-color: rgb(235, 243, 247); */
    border:none;
    border-radius:11px;
    -moz-box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    -webkit-box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
  }
  #u1084 {
    border-width:0px;
    position:absolute;
    left:0px;
    top:85px;
    width:296px;
    height:326px;
    display:flex;
  }

.login-content .block {
    border-width:0px;
    /* position:absolute; */
    display: inline-block;
    left:0px;
    top:0px;
    width:219px;
    height:36px;
    background:inherit;
    background-color:rgba(0, 121, 254, 0.847058823529412);
    border:none;
    border-radius:3px;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
    box-shadow:none;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    
    font-style:normal;
    color:#FFFFFF;
    line-height:20px;
}

.login-content .button.login {
    border-width:0px;
    position:absolute;
    left:43px;
    top:229px;
    width:219px;
    height:36px;
    display:flex;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-style:normal;
    color:#FFFFFF;
    line-height:20px;
  }
.login-content .button.login .text {
    position:absolute;
    align-self:center;
    padding:0px 0px 0px 0px;
    box-sizing:border-box;
    font-size: 13px;
    width:100%;
  }

.login-content .button:hover {
    /* 鼠标放上变小手 */
    cursor: pointer;
    opacity:0.8;
  }
  
.hidden .img {
    width:17px;
    height:17px;
}
.hidden {
    border-width:0px;
    position:absolute;
    left:70px;
    top:10px;
    width:17px;
    height:17px;
    display:flex;
    display:none; visibility: hidden
}

.login-content .button.close {
    border-width:0px;
    position:absolute;
    left:259px;
    top:0px;
    width:37px;
    height:37px;
    display:flex;
    font-family:'FontAwesome Regular', 'FontAwesome', sans-serif;
    font-weight:400;
    font-style:normal;
    font-size:18px;
    color:#999999;
  }
.login-content .button.close .text {
    position:absolute;
    align-self:center;
    padding:2px 2px 2px 2px;
    box-sizing:border-box;
    width:100%;
  }
  

.login-content .button.text {
    border-width:0px;
    position:absolute;
    /* left:43px;
    top:279px; */
    width:108px;
    height:26px;
    display:flex;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-style:normal;
    font-size: 13px;
    color:#0079FE;
    text-align:left;
  }
.login-content .button.text .text {
    position:absolute;
    align-self:center;
    padding:2px 2px 2px 2px;
    box-sizing:border-box;
    width:100%;
}

#u1089 {
    left:43px;
    top:279px;
    width:108px;
    height:26px;
    text-align:left;
}

#u1090 {
    /* left:55px; */
    /* margin-right: 0px; */
    right:34px;
    top:279px;
    width:108px;
    height:26px;
    text-align:right;
}


#username {
    /* border-width:0px;
    position:absolute;*/
    /* left:79px; */
    position: absolute;
    left:43px;
    top:38px;
    width:219px;
    height:36px;
    display: flex;
    /* text-align:left; */
  }

  
  input[type=text] {
    position: inherit;
    width: 100%;
    /* height: 100%; */
    /* width:219px; */
    height:36px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 2px;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-size: 13px;
    font-style:normal;
    color:#999999;
    padding: 12px 20px 12px 40px;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
  }

  input[type=text]:hover, input[type=password]:hover {
    border: 1px solid #0079FE;
  }
  input[type=text]:focus, input[type=password]:focus {
    /* border: 1px solid #0079FE; */
    box-shadow: 0px 0px 2px 2px #459fffba;
  }

input::-webkit-input-placeholder { /* WebKit, Blink, Edge */
    color:    #cccccc;
}
input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
   color:    #cccccc;
   opacity:  1;
}
input::-moz-placeholder { /* Mozilla Firefox 19+ */
   color:    #cccccc;
   opacity:  1;
}
input:-ms-input-placeholder { /* Internet Explorer 10-11 */
   color:    #cccccc;
}

.login-content i {
    position: absolute;
    left:0px;
    top:0px;
    width:36px;
    height:36px;
    /* background:inherit; */
    /* background-color:rgba(255, 255, 255, 0); */
    color:#cccccc;
    padding: 10px 18px 18px 12px;
    font-size: 17px;
}

#password {
    /* border-width:0px;
    position:absolute;*/
    /* left:79px; */
    position: absolute;
    left:43px;
    top:95px;
    width:219px;
    height:36px;
    display: flex;
    /* text-align:left; */
  }

  input[type=password] {
    position: inherit;
    /* width: 100%; */
    /* height: 100%; */
    width:219px;
    height:36px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 2px;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-size: 13px;
    font-style:normal;
    color:#999999;
    padding: 12px 20px 12px 40px;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
  }

  #verifycode {
    /* border-width:0px;
    position:absolute;*/
    /* left:79px; */
    position: absolute;
    left:43px;
    top:152px;
    width:140px;
    height:36px;
    display: flex;
    /* text-align:left; */
  }

.verify_image img{
    position:absolute;
    left:0px;
    top:0px;
    width:69px;
    height:29px;
  }
.verify_image {
    border-width:0px;
    position:absolute;
    left:190px;
    top:155px;
    width:69px;
    height:29px;
    display:flex;
  }
.verify_image:hover{
    cursor: pointer;
}
 
#u1103 {
    border-width:0px;
    position:absolute;
    left:43px;
    top:193px;
    width:79px;
    height:36px;
    display:flex;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-style:normal;
    font-size:13px;
    color:#999999;
    text-align:left;
    line-height:28px;
  }

#u1103 .text{
    padding: 4px;
}


</style>