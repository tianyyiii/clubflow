<template>
    <!-- 底部 -->
    <nav class="footer navbar navbar-expand d-flex justify-content-between align-items-center 
        px-5" style="height: 105px; font-size:12px; color:#999999;background-color: #333333;">
        <div class="ps-5">
            <p class="m-0">Copyright © xxx, All Rights Reserved. </p>
            <p class="m-0">百团聚交 版权待填</p>
        </div>
        <div class="pe-5">
            <div class="d-inline-flex pe-5">
                <div id="icon_weixin" class="icon">
                    <span></span>
                </div>
                <div class="ms-2">
                    <p class="m-0"><span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">微信公众号</span></p>
                    <p class="m-0"><span style="font-family:'微软雅黑', sans-serif;font-weight:400;">搜索关注：xxx</span></p>
                </div>
            </div>
    
            <div class="d-inline-flex pe-5">
                <div id="icon_weixin" class="icon">
                    <span></span>
                </div>
                <div class="ms-2">
                    <p class="m-0"><span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">QQ交流群</span></p>
                    <p class="m-0"><span style="font-family:'微软雅黑', sans-serif;font-weight:400;">查看交流群相关信息</span></p>
                </div>
            </div>
    
            <div class="d-inline-flex pe-5">
                <div id="icon_weixin" class="icon">
                    <span></span>
                </div>
                <div class="ms-2">
                    <p class="m-0"><span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;">联系邮箱</span></p>
                    <p class="m-0"><span style="font-family:'微软雅黑', sans-serif;font-weight:400;">xxx@sjtu.edu.com</span></p>
                </div>
            </div>
        </div>
    

        
    </nav>
</template>



<script>
export default {
    name: 'Footer',
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

/* 底部 */

.footer .icon {
    height: 60%;
    border-width:1px;
    border-style:solid;
    border-left:0px;
    border-top:0px;
    border-right:0px;
    font-family:'FontAwesome', sans-serif;
    font-weight:400;
    font-style:normal;
    font-size:18px;
}
</style>