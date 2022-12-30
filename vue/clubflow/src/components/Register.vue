<template>
    <!-- <img src="@/assets/images/index/backimg-1.png" class="backgroundimg"> -->
    <div class="container">
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
                <div id="u1074" class="ax_default label">
                    <!-- <div id="u1074_div" class=""></div> -->
                    <div id="u1074_text" class="text ">
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
                <div class="form">
                    <!-- 背景框 (矩形) -->
                    <div id="u1084" class="ax_default box_2">
                        <div id="u1084_div" class=""></div>

                        <!-- Unnamed (矩形) -->
                        <div id="u1037" class="ax_default label">
                            <p>
                                <span style="font-family:'FontAwesome', sans-serif ;font-weight:400;color:#881717;"> </span>
                                <span style="font-family:'FontAwesome', sans-serif ;font-weight:400;color:#B82D29;">用户注册</span>
                            </p>
                            <!-- Unnamed (线) -->
                            <div id="u1038" class="ax_default line">
                                <img id="u1038_img" class="img " src="@/assets/images/register/u1038.svg"/>
                            </div>
                        </div>
                        

                        <div class="small-container">
                            <!-- 输入框 (文本框) -->
                            <div style="margin-bottom: 10px;">
                                <div id="username" class="input_boxes" data-label="输入框">
                                    <input v-model="registerForm.name" id="username-input" type="text" placeholder="请输入JAccount账户" class="input text" maxlength="20"/>
                                    <i class="fa fa-user-circle" aria-hidden="true"></i>
                                </div>
                                <div id="password" class="input_boxes" data-label="输入框">
                                    <input v-model="registerForm.password" id="password-input" type="password" placeholder="请输入JAccount登录密码" class="input text" maxlength="20"/>
                                    <i class="fa fa-key" aria-hidden="true"></i>
                                </div>
                                <div id="nickname" class="input_boxes" data-label="输入框">
                                    <input v-model="registerForm.nickName" type="text" placeholder="请设置昵称" class="input text" maxlength="20"/>
                                    <i class="fa fa-id-card" aria-hidden="true"></i>
                                </div>
                            </div>

                            <!-- 注册类型 -->
                            <div id="u1067" class="ax_default label">
                                <span>请选择注册类型：</span>
                                <div style="display: flex; align-items: center; margin-top: 8px; margin-bottom: 35px;">
                                    <!-- role: 1 -- admin, 2 -- official account, 3 -- common user, 4 -- black user -->
                                    <input type="radio" name="userType" value="2" style="font-size:12px; margin-left: 10px;" >&nbsp;社团管理员
                                    <input type="radio" name="userType" value="3" style="font-size:12px;margin-left: 10px;" >&nbsp;普通用户
                                    <input type="radio" name="userType" value="1" style="font-size:12px;margin-left: 10px;" >&nbsp;开发人员
                                </div>
                            </div>


                            <!-- 同意用户协议 -->
                            <div id="u1042" class="" data-label="text">
                                <p>
                                    <input v-model="checked" class="me-1" type="checkbox" name="agree" >
                                    <span style="color:#999999;">勾选同意《</span>
                                    <a href="#" id="u1043" class="link" style="text-decoration:none; color:#666666">用户服务协议</a>
                                    <span style="color:#999999;">》</span>
                                </p>
                            </div>

                            <!-- 注册按钮 (矩形) -->
                            <button v-on:click="register" id="u1086" class="button login">
                                <div id="u1086_div" class="block">
                                    <span>注册</span>
                                </div>
                            </button>

                            
                            <!-- Unnamed (矩形) -->
                            <router-link to="/login" id="u1089" class="button text">
                                <p><span>已有账号，立即登录</span></p>
                            </router-link>
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
            registerForm:{
                name:'',
                password:'',
                nickName:'',
                role:0,
                profile:"0"
            },
            checked: false
        }
    },
    methods:{

        register(){
        this.registerForm.role = $("input[name='userType']:checked").val();
        // console.log(this.registerForm.role)
        if(!this.registerForm.role){
            alert("请勾选注册类型！");
        }
        // console.log(this.checked)
        if(!this.checked){
            alert("请勾选协议！");
        }
        if(!this.registerForm.name || !this.registerForm.password){
            alert("账号或密码不能为空！");
            location.reload();
        }
        // var put={name:userName,passwd:pwd,role:role,profile:"0"};
        var result_json={state:0,UserId:0,name:"0",role:0};
        var _this = this
        this.$axios
        .put('user/create',this.registerForm)
        .then(
            resp => {
                var data=resp.data;
                result_json.state=data.state;
                result_json.UserId=data.id;
                result_json.name=data.name;
                result_json.role=data.role;
                if(result_json.state==1){
                    alert("注册成功！");
                    _this.$store.commit('login', result_json.UserId, result_json.role)
                    // window.location.href = "./shetuanshequ_index.html?UserId="+result_json.UserId;
                    _this.$router.replace('/home')
                }
                else{
                    alert("注册失败！用户名重复！");
                    location.reload();
                }
          }
        )
        .catch(failResponse => {alert("请求异常");})
        
        
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
    font-family:'微软雅黑', NGlipingshouxie, sans-serif;
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
    width: 63vw;
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
    top: -90px;
    float: right;
    display: flex;
    justify-content: flex-start; 
    align-items: center;
    /* 文字居中 */
    text-align: center;
}
.form{
    position: relative;
    width: 462px;
    height: 564px;
}


#u1037 {
    position:absolute;
    left:39px;
    top:35px;
    font-size:28px;
    text-align: left;
}


#u1038 {
    margin-top: 10px;
    width:395px;
    height:2px;
    display:flex;
  }

#u1084_div {
    border-width:0px;
    position:absolute;
    left:0px;
    top:0px;
    width: 462px;
    height: 564px;
    background:inherit;
    background-color:rgba(242, 242, 242, 1);
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
    top:0px;
    width: 462px;
    height: 564px;
    display:flex;
  }

.small-container {
    display: flex;
    flex-flow: column;
    top: 82px;
    position: absolute;
    width: 100%;
    height: 480px;
    justify-content: center;
    align-items: center;
}


#u1067 {
    color:#898989;
    font-family:'微软雅黑', sans-serif;
    font-size:14px;
  }
  

#u1042 {
    height:40px;
    display:flex;
    justify-content: center;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-style:normal;
    font-size:14px;
  }


.login-content .block {
    border-width:0px;
    /* position:absolute; */
    display: flex;
    align-items: center;
    text-align: center;
    justify-content: center;
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
    /* position:absolute; */
    /* left:43px; */
    /* top:229px; */
    width:219px;
    height:36px;
    display:flex;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-style:normal;
    color:#FFFFFF;
    /* line-height:20px; */
    font-size: 13px;
  }

.login-content .button:hover {
    /* 鼠标放上变小手 */
    cursor: pointer;
    opacity:0.8;
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



.input_boxes{
    /* border-width:0px;*/
    position:relative;
    width:219px;
    height:36px;
    display: flex;
    margin-bottom: 24px;
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


  .login-content .button.text {
    margin-top: 20px;
    display:flex;
    font-family:'微软雅黑', sans-serif;
    font-weight:400;
    font-style:normal;
    font-size: 13px;
    color:#0079FE;
    text-align:left;
    text-decoration: none;
  }

</style>