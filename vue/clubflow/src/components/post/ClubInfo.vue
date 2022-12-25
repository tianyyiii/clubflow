<template>
    <!-- 协会信息 -->
    <div class="w-100">

        <!-- 社团名片 -->
        <div id="id-card" class="px-3 d-inline-flex w-100" style="background-color:rgb(228, 228, 228); padding-top: 30px; padding-bottom: 30px;">
            <img src="@/assets/images/common/default-user-square-dark.png" style="width: 74px; height: 74px;" alt="用户头像">
            <div class="ms-4 w-100">
                <p class="mt-1 mb-3" style="font-size:14px;">
                    <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">xx协会</span>
                </p>
                <p class="mb-1" style="font-size:12px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">文化艺术类</span>
                </p>
                <p class="m-0" style="font-size:12px;">
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">2011-03-30 成立</span>
                </p>
            </div>
        </div>

        <!-- 关注+私信 -->
        <div class="w-100 d-flex justify-content-center mt-5 mb-4" style="font-size: 13px;">
            <button class="follow-btn">
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;">&nbsp;</span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;"> 关注</span>
            </button>
            <button class="message-btn ms-3">
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;">&nbsp;</span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;"> 私信</span>
            </button>
        </div>

        <!-- 数据信息 -->
        <div class="w-100" >
            <div class="w-100 pb-2 pt-3 px-4 d-inline-flex justify-content-between" style="background-color: rgb(255, 218, 218); border-radius:6px; border-bottom-right-radius:0px; border-bottom-left-radius:0px;">
                <div class="text-center" style="width: 20%;">
                    <p class="mb-2" style="font-size:14px;">
                        <span style="font-family:'微软雅黑', sans-serif; color:#999999;">粉丝</span>
                    </p>
                    <p class="m-0" style="font-size:20px;">
                        <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">222</span>
                    </p>
                </div>
                <div class="text-center" style="width: 20%;">
                    <p class="mb-2" style="font-size:14px;">
                        <span style="font-family:'微软雅黑', sans-serif; color:#999999;">关注</span>
                    </p>
                    <p class="m-0" style="font-size:20px;">
                        <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">111</span>
                    </p>
                </div>
                <div class="text-center" style="width: 20%;">
                    <p class="mb-2" style="font-size:14px;">
                        <span style="font-family:'微软雅黑', sans-serif; color:#999999;">文章</span>
                    </p>
                    <p class="m-0" style="font-size:20px;">
                        <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">333</span>
                    </p>
                </div>
            </div>
            <div class="w-100 mt-3 p-2 px-4 d-inline-flex justify-content-between" style="border-bottom:1px solid rgba(255, 218, 218, 1); font-size:12px;">
                <div class="text-center" style="width: 20%;">
                    <p class="mb-2">
                        <span style="font-family:'微软雅黑', sans-serif; color:#999999;">赞</span>
                    </p>
                    <p class="m-0" style="font-size:14px;">
                        <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">222</span>
                    </p>
                </div>
                <div class="text-center" style="width: 20%;">
                    <p class="mb-2">
                        <span style="font-family:'微软雅黑', sans-serif; color:#999999;">评论</span>
                    </p>
                    <p class="m-0" style="font-size:14px;">
                        <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">111</span>
                    </p>
                </div>
                <div class="text-center" style="width: 20%;">
                    <p class="mb-2">
                        <span style="font-family:'微软雅黑', sans-serif; color:#999999;">收藏</span>
                    </p>
                    <p class="m-0" style="font-size:14px;">
                        <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">333</span>
                    </p>
                </div>
            </div>
        </div>

        <!-- 简介 -->
        <div class="w-100 mt-4">
            <div class="w-100 px-3" style="height:260px; font-size: 13px; font-family:'华文宋体', sans-serif; line-height: 17px;">
                简介：介绍协会。文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例文字示例。
            </div>
            <div class="w-100 pe-4 d-flex justify-content-end">
                <button style="font-family:'Cambria', sans-serif; font-size:13px;">
                    >> more
                </button>
            </div>
        </div>

        <!-- 积极成员 -->
        <div id="act-mems" class="mt-4 position-relative" style="font-family:'微软雅黑', sans-serif; font-size:12px; color:#999999;">
            <!-- 阴影蒙版 -->
            <div class="back-img"></div>
            <div style="background-color: white;">
                <div class="px-3 py-2" style="border-bottom: 1px solid #E4E4E4;">
                    积极成员
                </div>
                <div class="ms-3 w-100" style="height: 160px;">
                    <ul class="m-0 p-0">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        
                    </ul>
                </div>
            </div>

            
        </div>

        <!-- 最新加入 -->
        <div id="new-mems" class="mt-4 position-relative" style="font-family:'微软雅黑', sans-serif; font-size:12px; color:#999999;">
            <!-- 阴影蒙版 -->
            <div class="back-img"></div>
            <div style="background-color: white;">
                <div class="px-3 py-2" style="border-bottom: 1px solid #E4E4E4;">
                    最新加入
                </div>
                <div class="ms-3 w-100" style="height: 160px;">
                    <ul class="m-0 p-0">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        <img class="me-3 mt-3 float-start" src="@/assets/images/common/default-user-square-light.png" alt="用户头像" style="width: 50px; height: 50px;">
                        
                    </ul>
                </div>
            </div>

            
        </div>
    </div>
</template>

<script>
export default {
    name: 'ClubInfo',
    components: {},
    data: function () {
      return {}
    },
    created:function(){
    },
    mounted:function(){
      
    }
  }
</script>

<style scoped>


.message-btn {
    width:80px;
    height:35px;
    color:#0079FE;
    border-bottom: 1px;
    border-top: 0;
    border-left: 0;
    border-right: 0;
    border-style: solid;
    text-align: center;
  }

.message-btn:hover {
    opacity:0.8;
    cursor: pointer;
  }


.follow-btn {
    width:80px;
    height:35px;
    background-color:rgba(184, 45, 41, 1);
    border:none;
    border-radius:3px;
    border-bottom-right-radius:0px;
    border-bottom-left-radius:0px;
    color:#FFFFFF;
    text-align: center;
  }
.follow-btn:hover {
    opacity:0.8;
  }


.back-img {
    visibility:hidden;
    position:absolute;
    left:-1px;
    top:-1px;
    width:0;
    height:198px;
    background:inherit;
    background-color:rgba(228, 228, 228, 1);
    box-sizing:border-box;
    border-width:1px;
    border-style:solid;
    border-color:rgba(121, 121, 121, 1);
    border-radius:0px;
    -moz-box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    -webkit-box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    box-shadow:3px 3px 5px rgba(0, 0, 0, 0.349019607843137);
    z-index: -1;
    transition: ease;
    transition-duration: 0.8s;
}

#act-mems:hover .back-img{
    visibility:visible;
    width:406px;
}

#new-mems:hover .back-img{
    visibility:visible;
    width:406px;
}


</style>