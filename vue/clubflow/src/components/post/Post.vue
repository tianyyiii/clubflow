<template>
    <div class="w-100">
        <div id="art-title" style="border-color: #e1e1e1;border-width: thin; border-top: 0; border-left: 0; border-right: 0; border-style: solid;">
            <p style="font-size:20px;">
                <span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑', sans-serif;font-weight:700;color:#666666;">[招新]xx协会2022年度招新信息</span>
            </p>
            <p style="font-size:14px;">
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#666666;">&nbsp;原创文章</span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">&nbsp; xx协会&nbsp; 分类：</span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#0079FE;">文化艺术类&nbsp; </span>
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;font-size:13px;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:13px;color:#999999;">招新信息</span>
            </p>
            <p style="font-size:14px;">
                <!-- 点赞 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;">&nbsp; </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">7777&nbsp;&nbsp;</span>
                <!-- 评论 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">100&nbsp; </span>
                <!-- 收藏 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">100+&nbsp; </span>
                <!-- 浏览 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">33333&nbsp; &nbsp;&nbsp; </span>
                <!-- 日期 -->
                <span style="font-family:'FontAwesome', sans-serif;font-weight:400;color:#999999;"> </span>
                <span style="font-family:'微软雅黑', sans-serif;font-weight:400;color:#999999;">10-23 12:00</span>
            </p>
        </div>

        <div id="art-text" class="m-3">
            这里是图文内容<br>
            这里是图文内容<br>
            这里是图文内容<br>
            这里是图文内容<br>
        </div>

        <div class="m-3">
            <span style="font-size: 13px; color:#999999;font-family:'FontAwesome', sans-serif;">&nbsp; 招新信息</span>
        </div>

        <div class="d-flex w-100 justify-content-center position-relative">
            <button id="like" class="d-flex justify-content-center align-items-end">
                <p style="font-size:20px;">
                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"> </span>
                    <span style="font-family:'微软雅黑', sans-serif;font-weight:400;font-size:14px;">点赞 50</span>
                </p>
            </button>

            <div class="position-absolute" style="right: 0;">
                <button href="#" id="collect" class="text-center">
                    <span style="font-family:'FontAwesome', sans-serif;font-weight:400;"> </span>
                    <span style="font-family:'FontAwesome','微软雅黑', sans-serif;font-weight:400;font-size:14px;">收藏</span>
                </button>
                <div id="collectnum" class="text-center" style="font-family:sans-serif; font-size:12px; color:#999999;">
                    <span>100+人收藏</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name:"Post",
    components:{},
    data(){
        return {

        }
    },
    methods:{

    },
    created(){

    },
    mounted(){
        
    }
}
</script>

<style scoped>


#like {
    width:148px;
    height:59px;
    background:inherit;
    background-color:var(--themecolor);
    border:none;
    border-left:0px;
    border-top:0px;
    border-right:0px;
    border-radius:74px;
    border-bottom-right-radius:0px;
    border-bottom-left-radius:0px;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
    box-shadow:none;
    font-family:'FontAwesome', sans-serif;
    font-weight:400;
    font-style:normal;
    color:#FFFFFF;
    line-height:22px;
  }


#like:hover {
    opacity:0.8;
    cursor: pointer;
}

#collect {
    display: block;
    border: var(--greycolor);
    border-width:1px;
    border-top: 0;
    border-left: 0;
    border-right: 0;
    border-style: solid;
    width:120px;
    height:40px;
    font-family:'FontAwesome', sans-serif;
    font-weight:400;
    font-style:normal;
    color:#999999;
    text-align: center;
    font-size:20px;
    text-decoration: none;
  }
#collect:hover {
    color: rgb(78, 78, 78);
    cursor: pointer;
}






</style>